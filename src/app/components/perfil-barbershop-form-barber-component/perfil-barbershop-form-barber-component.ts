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

  previewUrl: string | null = null;   // prévia da foto
  selectedFile: File | null = null;   // arquivo selecionado

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;

    if (!input.files || input.files.length === 0) {
      return;
    }

    this.selectedFile = input.files[0];

    const reader = new FileReader();
    reader.onload = () => {
      this.previewUrl = reader.result as string;
    };
    reader.readAsDataURL(this.selectedFile);
  }

}
