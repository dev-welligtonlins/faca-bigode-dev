import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-perfil-barbershop-form-services-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-services-component.html',
  styleUrl: './perfil-barbershop-form-services-component.scss'
})
export class PerfilBarbershopFormServicesComponent {
  @Input() form!: FormGroup;
  
}
