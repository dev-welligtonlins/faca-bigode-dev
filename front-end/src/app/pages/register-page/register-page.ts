import { Component, ViewChild } from '@angular/core';
import { LoginFormComponent } from '../../components/login-form-component/login-form-component';
import { CommonModule } from '@angular/common';
import { RegisterFormComponent } from '../../components/register-form-component/register-form-component';
import { ModalRegisterComponent } from '../../components/modal-register-component/modal-register-component';

@Component({
  selector: 'app-register-page',
  standalone: true,
  imports: [CommonModule, LoginFormComponent, RegisterFormComponent, ModalRegisterComponent],
  templateUrl: './register-page.html',
  styleUrl: './register-page.scss'
})
export class RegisterPage {
  // para selecionar o component de login e register
  isLogin = true;
  // para abrir o modal de sucesso de registro
  @ViewChild('modalRegister') modalRegister!: ModalRegisterComponent;

  toggleMode() {
    this.isLogin = !this.isLogin;
  }

  openModal() {
    this.modalRegister.openModal();
  }
}
