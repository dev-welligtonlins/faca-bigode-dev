import { CommonModule } from '@angular/common';
import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { sService } from '../../services/ServiceService';
import { ServiceModel } from '../../models/service.model';

@Component({
  selector: 'app-perfil-barbershop-form-services-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-services-component.html',
  styleUrl: './perfil-barbershop-form-services-component.scss'
})
export class PerfilBarbershopFormServicesComponent {
  private fb = inject(FormBuilder);
  private service = inject(sService);

  @Output() serviceAddEvent = new EventEmitter<ServiceModel>();
  
  form: FormGroup = this.fb.group({
    descricao: ['', Validators.required],
    duracao: [30, [Validators.required, Validators.min(5)]],
    valor: [0, [Validators.required, Validators.min(1)]],
    categoria: ['', Validators.required],
  });

  // função para adicionar o form na lista de serviços
  addService(): void {
    if(this.form.valid) {
      const newService = this.form.value as ServiceModel;
      this.service.addService(newService);
      this.serviceAddEvent.emit(newService);
      this.form.reset({duracao: 30, valor:0 });
    }
  }
}
