import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EquipmentService} from "../../../services/equipment.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Equipement} from "../../../models/equipement";

@Component({
  selector: 'app-add-equipment',
  templateUrl: './add-equipment.component.html',
  styleUrls: ['./add-equipment.component.scss']
})
export class AddEquipmentComponent implements OnInit {

  formEquipment!: FormGroup;
  equipmentId?: number;

  constructor(
    private service: EquipmentService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.initializeForm();

    this.route.params.subscribe(params => {
      this.equipmentId = +params['id'];
      if (this.equipmentId) {
        this.loadEquipment();
      }
    });
  }

  loadEquipment() {
    if (this.equipmentId) {
      this.service.getById(this.equipmentId).subscribe(
        (equipment: Equipement) => {
          this.formEquipment.patchValue(equipment);
        },
        error => {
          console.error('Error fetching equipment', error);
        }
      );
    }
  }

  initializeForm() {
    this.formEquipment = this.fb.group({
      nome: ['', Validators.required],
      type: ['', Validators.required],
      status: ['', Validators.required],
    });
  }

  onSubmit() {
    const formValue = this.formEquipment.value;

    if (this.equipmentId) {
      // Update the equipment
      this.service.update(this.equipmentId, formValue).subscribe(
        () => {
          console.log('Equipment updated successfully');
          this.router.navigate(['/equipment-list']); // Redirect to the list view or another page
        },
        error => {
          console.error('Error updating equipment', error);
        }
      );
    } else {
      // Create a new equipment
      this.service.create(formValue).subscribe(
        () => {
          console.log('Equipment created successfully');
          this.router.navigate(['/equipment-list']); // Redirect to the list view or another page
        },
        error => {
          console.error('Error creating equipment', error);
        }
      );
    }
  }
}
