import { Component, inject } from '@angular/core';
import { ServiceModel } from '../../models/service.model';
import { sService } from '../../services/sService';
import { NgForm } from '@angular/forms';
import { CommonModule, CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-service-list-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './service-list-component.html',
  styleUrl: './service-list-component.scss'
})
export class ServiceListComponent {
  servicesService = inject(sService);

  remove(index: number) {
    this.servicesService.removeService(index);
  }
}
