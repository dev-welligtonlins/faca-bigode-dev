import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ServicesComponent } from '../../components/services-component/services-component';
import { BarbeirosComponent } from '../../components/barbeiros-component/barbeiros-component';
import { Router } from '@angular/router'; // Importe o Router

@Component({
  selector: 'app-dashboard-page',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule, RouterOutlet,],
  templateUrl: './dashboard-page.html',
  styleUrl: './dashboard-page.scss'

})
export class DashboardPage {

  perfil = {
    nome: 'Faca & Bigode',
    user: 'Nome do Usuário',
    fotoUrl: 'caminho/para/sua/imagem.jpg' // URL real da imagem
  };

  searchQuery: string = '';

  // exemplo de dados do dashboard que serão filtrados
  items = [
    { id: 1, title: 'Corte Masculino', desc: 'Corte tradicional' },
    { id: 2, title: 'Barba', desc: 'Aparar e modelar' },
    { id: 3, title: 'Coloração', desc: 'Tintura e retoque' },
    { id: 4, title: 'Sobrancelha', desc: 'Design' }
  ];

  get filteredItems() {
    const q = this.searchQuery.trim().toLowerCase();
    if (!q) return this.items;
    return this.items.filter(i =>
      (i.title + ' ' + i.desc).toLowerCase().includes(q)
    );
  }

  trackById(index: number, item: any) {
    return item.id;
  }

  // 1. O construtor é usado apenas para INJEÇÃO de dependências
  constructor(private router: Router) {
    // Nada mais deve ser definido aqui
  }
  // 2. O método logout() deve ser definido DIRETAMENTE na classe
  logout(): void {

    // 2. Limpar a Sessão
    localStorage.removeItem('auth_token');

    // 3. Redirecionar para a tela de login
    this.router.navigate(['/login']);
  }
}
