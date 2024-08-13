import { Injectable } from '@angular/core';
import {Panne} from "../models/panne";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PanneService {

  private apiUrl = 'http://localhost:8080/api/pannes'; // URL de l'API

  constructor(private http: HttpClient) { }

  getAllPannes(): Observable<Panne[]> {
    return this.http.get<Panne[]>(this.apiUrl);
  }

  getPanneById(id: number): Observable<Panne> {
    return this.http.get<Panne>(`${this.apiUrl}/${id}`);
  }

  reportPanne(panne: Panne, equipmentId: number): Observable<Panne> {
    return this.http.post<Panne>(`${this.apiUrl}/report/${equipmentId}`, panne);
  }

  updatePanneStatus(id: number, status: string): Observable<Panne> {
    return this.http.put<Panne>(`${this.apiUrl}/status/${id}`, { status });
  }

  getPannesByEquipment(equipmentId: number): Observable<Panne[]> {
    return this.http.get<Panne[]>(`${this.apiUrl}/equipment/${equipmentId}`);
  }
}
