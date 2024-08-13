import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {Router} from "@angular/router";
import {Loginuserdto} from "../../../dto/loginuserdto";
import {Loginresponce} from "../../../models/loginresponce";
import {jwtDecode} from 'jwt-decode';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
  export class LoginComponent {
  userName: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    const loginUser: Loginuserdto = new Loginuserdto(this.userName, this.password);
    this.authService.login(loginUser).subscribe({
      next: (response) => {
        console.log('Login successful:', response);
        localStorage.setItem('token', response.token);
        console.log('Token expires in:', response.expiresIn);

        const token = response.token;
        const decodedToken: any = jwtDecode(token);

        if (decodedToken.role === 'ADMIN') {
          this.router.navigate(['/dashboard']);
        } else if (decodedToken.role === 'USER') {
          this.router.navigate(['/home']);
        }else if(decodedToken.role === 'TECHNICIEN') {
          this.router.navigate(['/home']);
        } else {
          console.error('Unknown role:', decodedToken.role);
        }
      },
      error: (err) => {
        console.error('Login failed:', err);
      },
      complete: () => {
        console.log('Login process complete.');
      }
    });
  }

  openSignUp() {
    this.router.navigate(['/dashboard']);
  }

}
