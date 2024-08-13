import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RegisterUserDto} from "../dto/register-user-dto";
import {Observable} from "rxjs";
import {Loginuserdto} from "../dto/loginuserdto";
import {Loginresponce} from "../models/loginresponce";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private apiUrl = 'http://localhost:8080/api/auth';


  // URL de l'API d'authentification

  constructor(private http: HttpClient) { }

 /* signup(registerUserDto: RegisterUserDto): Observable<any> {
     Ajouter le rôle automatiquement avant l'envoi
    registerUserDto.role = 'USER'; // Vous pouvez définir le rôle en fonction de la logique nécessaire
    return this.http.post<any>(`${this.apiUrl}/signup`, registerUserDto);
 } */


  login(loginUser: Loginuserdto): Observable<Loginresponce> {
    return this.http.post<Loginresponce>(`${this.apiUrl}/login`, loginUser);
  }
}
