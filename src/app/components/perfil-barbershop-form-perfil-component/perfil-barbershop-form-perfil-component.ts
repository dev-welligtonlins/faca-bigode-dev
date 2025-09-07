import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-perfil-barbershop-form-perfil-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './perfil-barbershop-form-perfil-component.html',
  styleUrls: ['./perfil-barbershop-form-perfil-component.scss']
})
export class PerfilBarbershopFormPerfilComponent {
  previewUrl: string | null = null;   // prévia da foto
  selectedFile: File | null = null;   // arquivo selecionado

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;

    if (!input.files || input.files.length == 0) {
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

