import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Equipement} from "../models/equipement";

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {

  private apiUrl = 'http://localhost:8080/api/equipments';


  constructor(private http: HttpClient) { }

  getAll(): Observable<Equipement[]> {
    return this.http.get<Equipement[]>(`${this.apiUrl}/admin/get`);
  }

  getById(id: number | undefined): Observable<Equipement> {
    return this.http.get<Equipement>(`${this.apiUrl}/admin/get/${id}`);
  }

  create(equipment: Equipement): Observable<Equipement> {
    return this.http.post<Equipement>(`${this.apiUrl}/admin/add`, equipment);
  }

  update(id: number, equipment: Equipement): Observable<Equipement> {
    return this.http.put<Equipement>(`${this.apiUrl}/admin/update/${id}`, equipment);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/admin/delete/${id}`);
  }
}
