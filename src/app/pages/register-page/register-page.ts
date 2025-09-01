import { Component } from '@angular/core';
import { LoginFormComponent } from '../../components/login-form-component/login-form-component';
import { CommonModule } from '@angular/common';
import { RegisterFormComponent } from '../../components/register-form-component/register-form-component';

@Component({
  selector: 'app-register-page',
  standalone: true,
  imports: [CommonModule, LoginFormComponent, RegisterFormComponent],
  templateUrl: './register-page.html',
  styleUrl: './register-page.scss'
})
export class RegisterPage {
  isLogin = true;

  toggleMode() {
    this.isLogin = !this.isLogin;
  }
}
