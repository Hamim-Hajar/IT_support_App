import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {Router} from "@angular/router";
import {RegisterUserDto} from "../../../dto/register-user-dto";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {
  /*registrationForm: FormGroup;
  errorMessage: string | undefined;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.registrationForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.registrationForm.invalid) {
      return;
    }

    const registerDto: RegisterUserDto = {
      ...this.registrationForm.value,
      role: 'USER' // Définir le rôle automatiquement ici
    };

    this.authService.signup(registerDto).subscribe(
      response => {
        // Rediriger vers la page de connexion ou une autre page
        this.router.navigate(['/login']);
      },
      error => {
        this.errorMessage = 'Registration failed';
      }
    );
  }*/
}
