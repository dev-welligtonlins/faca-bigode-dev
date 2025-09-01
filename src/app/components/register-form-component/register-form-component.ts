import { Component } from '@angular/core';

@Component({
  selector: 'app-register-form-component',
  standalone: true,
  imports: [],
  templateUrl: './register-form-component.html',
  styleUrl: './register-form-component.scss'
})
export class RegisterFormComponent {

  registerUser() {
    console.log('Usuário cadastrado!')
  }
}
