import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { ModalTimeComponent } from '../modal-time-component/modal-time-component';

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

  // para selecionar login/register
  isLogin = true;

  // referência ao modal de horário
  @ViewChild('modalTime') modalTime!: ModalTimeComponent;

  // Lista de acomodações
  amenities = [
    { name: 'Wi-Fi', icon: 'bi-wifi', selected: false },
    { name: 'Estacionamento', icon: 'bi-car-front', selected: false },
    { name: 'Climatizado', icon: 'bi-wind', selected: false },
    { name: 'Banheiro', icon: 'bi-water', selected: false },
  ];

  // Lista de formas de pagamento
  payments = [
    { name: 'Dinheiro', icon: 'bi-cash', selected: false },
    { name: 'Pix', icon: 'bi-piggy-bank', selected: false },
    { name: 'Cartão de Crédito', icon: 'bi-credit-card', selected: false },

  ];

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

  toggleMode() {
    this.isLogin = !this.isLogin;
  }

  openModal() {
    if (this.modalTime) {
      this.modalTime.openModal();
    }
  }

  // Seleção de acomodações
  toggleAmenity(amenity: any) {
    amenity.selected = !amenity.selected;
  }

  // Seleção de formas de pagamento ✅ (AGORA EXISTE)
  togglePayment(payment: any) {
    payment.selected = !payment.selected;
  }
}
