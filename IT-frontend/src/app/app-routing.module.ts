import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./Compenents/dashboard/dashboard.component";
import {LoginComponent} from "./Compenents/shared/login/login.component";
import {HomeComponent} from "./Compenents/shared/home/home.component";
import {EquipmentListComponent} from "./Compenents/equipment/equipment-list/equipment-list.component";
import {Home2Component} from "./Compenents/shared/home2/home2.component";
import {AddEquipmentComponent} from "./Compenents/equipment/add-equipment/add-equipment.component";
import {UserTicketListComponent} from "./Compenents/ticket/user-ticket-list/user-ticket-list.component";

const routes: Routes = [
  {path:'dashboard',component: DashboardComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'home2', component: Home2Component},
  { path: 'equipement-list', component: EquipmentListComponent},
  {path :'edit-equipment/:id', component: AddEquipmentComponent},
  {path: 'user-tickets', component: UserTicketListComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
