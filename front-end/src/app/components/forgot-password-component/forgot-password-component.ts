import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-forgot-password-component',
  templateUrl: './forgot-password-component.html',
  standalone: true,
  imports: [FormsModule]
})
export class ForgotPasswordComponent {
  email: string = '';

  @Output() emailEnviado = new EventEmitter<void>();

  onSubmit() {
    // Lógica para envio do e-mail de recuperação
    this.emailEnviado.emit();
  }
}