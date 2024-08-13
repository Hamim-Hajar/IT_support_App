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
export class AddEquipmentComponent implements OnInit{

  formEquipment!:FormGroup;
  equipmentId?:number
  constructor(private service: EquipmentService, private fb: FormBuilder,private route:ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.Equipement()

    this.route.params.subscribe(params => {
      this.equipmentId = +params['id'];
      if (this.equipmentId) {
        this.loadEquipment();
      }
    })
  }

  loadEquipment(){
    this.service.getById(this.equipmentId).subscribe(
      (equipment: Equipement) => {
        this.formEquipment.patchValue(equipment);
      },
      error => {
        console.error('Error fetching equipment', error);
      }
    )

  }



  Equipement(){
    this.formEquipment = this.fb.group({
      nome: ['', Validators.required],
      type: ['', Validators.required],
      status: ['', Validators.required],

    });
  }




  onSubmit(){
    const valuer = this.formEquipment.value
    console.log(valuer)

    this.service.create(valuer).subscribe()

    this.Equipement()

  }

}
