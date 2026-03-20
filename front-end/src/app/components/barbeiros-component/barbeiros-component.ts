import { Component, OnInit } from '@angular/core';
import { BarberPageModel } from '../../models/page-barber-model';
import { ActivatedRoute } from '@angular/router';
import { sBarber } from '../../services/sBarber';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-barbeiros-component',
  imports: [CommonModule],
  templateUrl: './barbeiros-component.html',
  styleUrl: './barbeiros-component.scss',
})
export class BarbeirosComponent implements OnInit {

    perfil = {
    fotoUrl: 'front-end/src/assets/img/perfil.png', 
  };

  barbershopId!: number;
  barberPage!: BarberPageModel;

  constructor(private sBarber: sBarber, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.barbershopId = Number(this.route.snapshot.paramMap.get('id'));
    this.sBarber.getPage(this.barbershopId).subscribe({
      next: (data) => {
        this.barberPage = data;
      },
      error: (err) => {
        console.error('Erro ao carregar pagina de barbeiros:', err);

      }
    });
  }
}
