// src/app/components/configuracoes-component/configuracoes-component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

// Importe cada um dos seus novos componentes aqui
import { ModalGerenciarContaComponent } from '../modal-gerenciar-conta-component/modal-gerenciar-conta-component';
import { ModalDetalhesPlanoComponent } from '../modal-detalhes-plano-component/modal-detalhes-plano-component';
import { ModalHistoricoCobrancasComponent } from '../modal-historico-cobrancas-component/modal-historico-cobrancas-component';
import { ModalHorariosComponent } from '../modal-horarios-component/modal-horarios-component';
import { ModalPagamentoComponent } from '../modal-pagamento-component/modal-pagamento-component';
import { ModalAcomodacoesComponent } from '../modal-acomodacoes-component/modal-acomodacoes-component';
import { ModalEnderecoComponent } from '../modal-endereco-component/modal-endereco-component';

@Component({
  selector: 'app-configuracoes-component',
  standalone: true,
  imports: [
    CommonModule, ModalGerenciarContaComponent, ModalDetalhesPlanoComponent, ModalHistoricoCobrancasComponent, ModalHorariosComponent, ModalPagamentoComponent, ModalAcomodacoesComponent, ModalEnderecoComponent
  ],
  templateUrl: './configuracoes-component.html',
  styleUrls: ['./configuracoes-component.scss']
})
export class ConfiguracoesComponent { }