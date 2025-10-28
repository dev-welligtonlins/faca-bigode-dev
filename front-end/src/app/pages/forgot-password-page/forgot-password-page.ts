import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ForgotPasswordComponent } from '../../components/forgot-password-component/forgot-password-component';
import { VerifyCodeComponent } from '../../components/verify-code-component/verify-code-component';
import { NewPasswordComponent } from '../../components/new-password-component/new-password-component';

@Component({
  selector: 'app-forgot-password-page',
  templateUrl: './forgot-password-page.html',
  standalone: true,
  imports: [CommonModule, ForgotPasswordComponent, VerifyCodeComponent, NewPasswordComponent]
})
export class ForgotPasswordPage {
  etapa: 'email' | 'codigo' | 'nova-senha' = 'email';

  mostrarCodigo() {
    this.etapa = 'codigo';
  }

  voltarParaEmail() {
    this.etapa = 'email';
  }

  mostrarNovaSenha() {
    this.etapa = 'nova-senha';
  }

}