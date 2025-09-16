import { Component, inject } from '@angular/core';
import { sBarber } from '../../services/sBarber';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-barber-list-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './barber-list-component.html',
  styleUrl: './barber-list-component.scss'
})
export class BarberListComponent {
  barberService = inject(sBarber);

  remove(index: number) {
    this.barberService.removeBarber(index);
  }
}
