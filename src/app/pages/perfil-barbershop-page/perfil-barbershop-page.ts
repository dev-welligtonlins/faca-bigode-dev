import { Component } from '@angular/core';
import { PerfilBarbeshopFormAddressComponent } from '../../components/perfil-barbeshop-form-address-component/perfil-barbeshop-form-address-component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PerfilBarbershopFormServicesComponent } from '../../components/perfil-barbershop-form-services-component/perfil-barbershop-form-services-component';
<<<<<<< HEAD
import { PerfilBarbershopFormBarberComponent } from '../../components/perfil-barbershop-form-barber-component/perfil-barbershop-form-barber-component';
=======
import { PerfilBarbershopFormPerfilComponent } from '../../components/perfil-barbershop-form-perfil-component/perfil-barbershop-form-perfil-component';
>>>>>>> 1603834 (modificações na page de barber perfil)

@Component({
  selector: 'app-perfil-barbershop-page',
  standalone: true,
<<<<<<< HEAD
  imports: [CommonModule, ReactiveFormsModule, PerfilBarbeshopFormAddressComponent, PerfilBarbershopFormServicesComponent, PerfilBarbershopFormBarberComponent],
=======
  imports: [CommonModule, ReactiveFormsModule, PerfilBarbeshopFormAddressComponent, PerfilBarbershopFormServicesComponent, PerfilBarbershopFormPerfilComponent],
>>>>>>> 1603834 (modificações na page de barber perfil)
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
      imagem: this.fb.control<File | null>(null),
    });
  }

  nextStep() {
    if (this.start < 3) {
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