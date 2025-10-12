import { CommonModule } from '@angular/common';
import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { sBarber } from '../../services/sBarber';
import { BarberModel } from '../../models/barber-model';

@Component({
  selector: 'app-perfil-barbershop-form-barber-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-barber-component.html',
  styleUrl: './perfil-barbershop-form-barber-component.scss'
})
export class PerfilBarbershopFormBarberComponent {
  private fb = inject(FormBuilder);
  private barberService = inject(sBarber);

  @Output() barberAddEvent = new EventEmitter<BarberModel>();

  form: FormGroup = this.fb.group({
    nome: ['', Validators.required],
    midia_social: ['', [Validators.required]],
  });

  // função para adicionar o form na lista de serviços
  addBarber(): void {
    if (this.form.valid) {
      const newBarber = this.form.value as BarberModel;
      this.barberService.addBarber(newBarber);
      this.barberAddEvent.emit(newBarber);
      this.form.reset({ nome: '', midia_social: '' });
    }
  }

}
