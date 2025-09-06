import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-perfil-barbershop-form-barber-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-barber-component.html',
  styleUrl: './perfil-barbershop-form-barber-component.scss'
})
export class PerfilBarbershopFormBarberComponent {
  @Input() form!: FormGroup;
  
  preview: string | ArrayBuffer | null = null;

  uploadFile(event: Event): void{
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      this.form.patchValue({ imagem: file });
      
      // carregando a imagem na página
      const reader = new FileReader();
      reader.onload = () => {
        this.preview = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }

}
