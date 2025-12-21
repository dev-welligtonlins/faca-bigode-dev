import { Component, OnInit } from '@angular/core';
import { ServiceModel } from '../../models/service.model';
import { sService } from '../../services/sService';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { DashboardServiceModel } from '../../models/dashboard-service-model';

@Component({
  selector: 'app-test-api-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './test-api-page.html',
  styleUrl: './test-api-page.scss'
})
export class TestApiPage implements OnInit{
  dashboard!: DashboardServiceModel;
  barbershopId!: number;

  constructor(private sService: sService, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.barbershopId = Number(this.route.snapshot.paramMap.get('id'));
    this.sService.getAllServices(this.barbershopId).subscribe({
      next: (data) => {
        this.dashboard = data;
      },
      error: (err) => {
        console.error('Erro ao carregar barbeiros:', err);

      }
    });
  }
}
