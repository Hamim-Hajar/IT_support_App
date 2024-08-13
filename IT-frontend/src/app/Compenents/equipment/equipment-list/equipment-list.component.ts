import {Component, OnInit} from '@angular/core';
import {Equipement} from "../../../models/equipement";
import {EquipmentService} from "../../../services/equipment.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-equipment-list',
  templateUrl: './equipment-list.component.html',
  styleUrls: ['./equipment-list.component.scss']
})
export class EquipmentListComponent implements OnInit{
  equipments: Equipement[] = [];

  constructor(private equipmentService: EquipmentService, private router:Router) { }

  ngOnInit(): void {
    this.loadEquipments();
  }
  loadEquipments() {
    this.equipmentService.getAll().subscribe(data => {
      this.equipments = data;
    });
  }

  deleteEquipment(id: number): void {
    this.equipmentService.delete(id).subscribe(() => {
      this.loadEquipments();
    });
  }
 updateEquipment(id:number){
    this.router.navigate(['/edit-equipment',id])
 }
}
