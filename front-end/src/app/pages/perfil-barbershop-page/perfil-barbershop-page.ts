import { Component } from '@angular/core';
import { PerfilBarbeshopFormAddressComponent } from '../../components/perfil-barbeshop-form-address-component/perfil-barbeshop-form-address-component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PerfilBarbershopFormServicesComponent } from '../../components/perfil-barbershop-form-services-component/perfil-barbershop-form-services-component';
import { PerfilBarbershopFormBarberComponent } from '../../components/perfil-barbershop-form-barber-component/perfil-barbershop-form-barber-component';
import { PerfilBarbershopFormPerfilComponent } from '../../components/perfil-barbershop-form-perfil-component/perfil-barbershop-form-perfil-component';
import { ModalTimeComponent } from '../../components/modal-time-component/modal-time-component';
import { ServiceListComponent } from '../../components/service-list-component/service-list-component';
import { BarberListComponent } from '../../components/barber-list-component/barber-list-component';
@Component({
  selector: 'app-perfil-barbershop-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, PerfilBarbeshopFormAddressComponent, PerfilBarbershopFormServicesComponent, PerfilBarbershopFormBarberComponent, PerfilBarbershopFormPerfilComponent, ModalTimeComponent, ServiceListComponent, BarberListComponent],
  templateUrl: './perfil-barbershop-page.html',
  styleUrl: './perfil-barbershop-page.scss'
})
export class PerfilBarbershopPage {
  start = 1;
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      cep: this.fb.control('', { nonNullable: true, validators: [Validators.required] }),
      number: this.fb.control('', { nonNullable: true, validators: [Validators.required] }),
      logradouro: this.fb.control('', { nonNullable: true, validators: [Validators.required] }),
      bairro: this.fb.control('', { nonNullable: true }),
      complemento: this.fb.control('', { nonNullable: true }),
      localidade: this.fb.control('', { nonNullable: true }),
      uf: this.fb.control('', { nonNullable: true }),

      descricao: this.fb.control('', {nonNullable: true}),
      duracao: this.fb.control('', {nonNullable: true}),
      valor: this.fb.control('', {nonNullable: true}),
      tipo_servico: this.fb.control('', {nonNullable: true}),

    });
  }

  nextStep() {
    if (this.start < 4) {
      this.start++;
    } else {
      this.finish();
    }
  }

  prevStep() {
    if (this.start > 1) this.start--;
  }

  finish() {
    const dados: any = this.form.getRawValue();
    console.log('📌 Dados finais prontos para backend:', dados);
  }
}