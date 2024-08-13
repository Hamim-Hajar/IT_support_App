import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './Compenents/shared/registration/registration.component';
import { EquipmentListComponent } from './Compenents/equipment/equipment-list/equipment-list.component';
import { EquipmentDetailComponent } from './Compenents/equipment/equipment-detail/equipment-detail.component';
import { PanneManagementComponent } from './Compenents/panne/panne-management/panne-management.component';
import { SupportTicketFormComponent } from './Compenents/ticket/support-ticket-form/support-ticket-form.component';
import { UserTicketListComponent } from './Compenents/ticket/user-ticket-list/user-ticket-list.component';
import { AdminTicketManagementComponent } from './Compenents/ticket/admin-ticket-management/admin-ticket-management.component';
import { TechnicianTicketListComponent } from './Compenents/ticket/technician-ticket-list/technician-ticket-list.component';
import { HeaderComponent } from './Compenents/shared/header/header.component';
import { DashboardComponent } from './Compenents/dashboard/dashboard.component';
import { LoginComponent } from './Compenents/shared/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './Compenents/shared/home/home.component';
import { Home2Component } from './Compenents/shared/home2/home2.component';
import { FooterComponent } from './Compenents/shared/footer/footer.component';
import {authInterceptorInterceptor} from "./interceptors/auth-interseptor.service";
import {AddEquipmentComponent} from "./Compenents/equipment/add-equipment/add-equipment.component";

@NgModule({
  declarations: [
    AppComponent,

    RegistrationComponent,
    EquipmentListComponent,
    EquipmentDetailComponent,
    PanneManagementComponent,
    SupportTicketFormComponent,
    UserTicketListComponent,
    AdminTicketManagementComponent,
    TechnicianTicketListComponent,
    HeaderComponent,
    DashboardComponent,
    LoginComponent,
    HomeComponent,
    Home2Component,
    FooterComponent,
    AddEquipmentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: authInterceptorInterceptor,
    multi:true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
