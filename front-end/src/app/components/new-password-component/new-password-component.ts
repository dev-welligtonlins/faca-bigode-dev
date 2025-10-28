import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-password-component',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './new-password-component.html',
  styleUrl: './new-password-component.scss'
})
export class NewPasswordComponent {
   newPassword: string = '';     // ADICIONADO
  confirmPassword: string = ''; // ADICIONADO

  onSubmit() {
    if (this.newPassword !== this.confirmPassword) {
      alert('As senhas não coincidem');
      return;
    }
    // enviar para backend / lógica de alteração de senha
  }
}
