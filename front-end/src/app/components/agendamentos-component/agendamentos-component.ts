import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms'; 
import { Router } from '@angular/router'; 

// ------------------------------------------------
// 1. Definições de Tipos (Interfaces)
// ------------------------------------------------

interface Barbeiro {
  id: number;
  nome: string;
}

interface Agendamento {
  id: number;
  data: string; 
  hora: string; 
  nomeCliente: string;
  nomeServico: string;
  barbeiroId: number;
  telefone: string;
  duracao: number; // Em minutos
  valor: number;  // Em Reais
  status: 'confirmado' | 'pendente' | 'cancelado';
}

interface Filtro {
  data: string | null;
  busca: string; 
  barbeiroId: number | null;
}

// ------------------------------------------------
// 2. Componente e Lógica
// ------------------------------------------------

@Component({
  selector: 'app-agendamentos-component',
  imports: [CommonModule, FormsModule], 
  standalone: true, 
  templateUrl: './agendamentos-component.html',
  styleUrl: './agendamentos-component.scss'
})
export class AgendamentosComponent implements OnInit {

  // NOVA PROPRIEDADE: Controla se o widget de agendamentos está expandido ou recolhido
  isExpandido: boolean = false; 

  filtro: Filtro = {
    data: null,
    busca: '',
    barbeiroId: null,
  };
  
  barbeiros: Barbeiro[] = [
    { id: 1, nome: 'João Barbeiro' },
    { id: 2, nome: 'Pedro Navalha' },
    { id: 3, nome: 'Ana Tesoura' },
  ];

  agendamentosOriginais: Agendamento[] = [
    { id: 1, data: '2025-11-25', hora: '16:20', nomeCliente: 'Pena Tudo 3', nomeServico: 'Corte + Barba', barbeiroId: 1,
      telefone: '(11) 99999-9999', duracao: 45, valor: 50.00, status: 'confirmado' },
    { id: 2, data: '2025-11-25', hora: '11:00', nomeCliente: 'Maria Cliente', nomeServico: 'Barba Terapia', barbeiroId: 2,
      telefone: '(11) 98765-4321', duracao: 60, valor: 65.00, status: 'pendente' },
    { id: 3, data: '2025-11-26', hora: '12:00', nomeCliente: 'Carlos Silva', nomeServico: 'Corte Undercut', barbeiroId: 1,
      telefone: '(11) 91234-5678', duracao: 30, valor: 35.00, status: 'confirmado' },
    { id: 4, data: '2025-11-27', hora: '14:00', nomeCliente: 'Cliente D', nomeServico: 'Corte e Barba', barbeiroId: 3,
      telefone: '(11) 90000-0000', duracao: 90, valor: 80.00, status: 'pendente' },
  ];

  agendamentosFiltrados: Agendamento[] = [];

  constructor(private router: Router) { } 

  ngOnInit(): void {
    // Carrega o dia atual ou todos os agendamentos ao iniciar
    this.agendamentosFiltrados = [...this.agendamentosOriginais];
  }

  // NOVO MÉTODO: Alterna o estado do widget (expandir/recolher)
  toggleExpandir(): void {
      this.isExpandido = !this.isExpandido;
      // Opcional: Se estiver expandindo, aplica os filtros para garantir que a lista esteja atualizada
      if (this.isExpandido) {
          this.aplicarFiltros();
      }
  }

  // --- MÉTODOS DE FILTRO ---
  aplicarFiltros(): void {
    let tempAgendamentos = this.agendamentosOriginais;

    if (this.filtro.data) {
      tempAgendamentos = tempAgendamentos.filter(ag => ag.data === this.filtro.data);
    }

    if (this.filtro.barbeiroId) {
      tempAgendamentos = tempAgendamentos.filter(ag => ag.barbeiroId === this.filtro.barbeiroId);
    }
    
    if (this.filtro.busca) {
      const termo = this.filtro.busca.toLowerCase();
      tempAgendamentos = tempAgendamentos.filter(ag => {
        return ag.nomeCliente.toLowerCase().includes(termo) || 
               ag.nomeServico.toLowerCase().includes(termo);
      });
    }

    this.agendamentosFiltrados = tempAgendamentos;
  }
  
  // --- MÉTODOS AUXILIARES ---
  getBarbeiroNome(id: number): string {
    const barbeiro = this.barbeiros.find(b => b.id === id);
    // Retorna apenas o primeiro nome do barbeiro
    return barbeiro ? barbeiro.nome.split(' ')[0] : 'N/A';
  }

  // --- NOVOS MÉTODOS DE AÇÃO ---
  
  editarAgendamento(agendamentoId: number): void {
    console.log(`Abrindo edição do agendamento ID: ${agendamentoId}`);
    // Simula a navegação
    // this.router.navigate(['/agendamento', agendamentoId, 'editar']); 
  }

  cancelarAgendamento(agendamentoId: number): void {
    // ATENÇÃO: `window.confirm()` foi substituído por uma mensagem no console. 
    // Em um ambiente de produção, você usaria um Modal customizado.
    
    // Simulação: Se o usuário clicasse no Modal de confirmação
    const isConfirmed = true; 
    
    if (isConfirmed) {
      const agendamento = this.agendamentosOriginais.find(ag => ag.id === agendamentoId);
      if (agendamento) {
          agendamento.status = 'cancelado';
      } else {
          console.error(`Agendamento com ID ${agendamentoId} não encontrado.`);
          return;
      }
      
      this.aplicarFiltros(); 
      console.log(`Agendamento ID: ${agendamentoId} CANCELADO.`);
    } else {
      console.log('Cancelamento abortado.');
    }
  }
}