import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { NewAccommodationModel } from '../../models/new-accommodation-model';
import { ServiceAccommodation } from '../../services/ServiceAccommodation';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-perfil-barbershop-form-accommodation-component',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './perfil-barbershop-form-accommodation-component.html',
  styleUrl: './perfil-barbershop-form-accommodation-component.scss'
})
export class PerfilBarbershopFormAccommodationComponent implements OnInit{
  accommodationForm!: FormGroup;

  constructor(private service: ServiceAccommodation, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.accommodationForm = this.fb.group({
      wifi: [false, Validators.required],
      parking: [false, Validators.required],
      bath: [false, Validators.required],
      airConditioner: [false, Validators.required],
      barbershopId: [0, Validators.required]
   });
  }

  postAccommodation() : void {
    if (this.accommodationForm.invalid) {
      this.accommodationForm.markAllAsTouched();
      return;
    }

    const accommodation = this.getAccomodationForm();

    this.service.postAccommodation(accommodation).subscribe({
      next: () => console.log('Salvo com sucesso!'),
      error: err => console.error(err)
    })
  }

  getAccomodationForm() : NewAccommodationModel {
    return this.accommodationForm.value as NewAccommodationModel;
  }


  // Lista de acomodações
  amenities = [
    { name: 'Wi-Fi', icon: 'bi-wifi', selected: false },
    { name: 'Estacionamento', icon: 'bi-car-front', selected: false },
    { name: 'Climatizado', icon: 'bi-wind', selected: false },
    { name: 'Banheiro', icon: 'bi-water', selected: false },
  ];

  // Seleção de acomodações
  toggleAmenity(amenity: any) {
    amenity.selected = !amenity.selected;
  }
}

