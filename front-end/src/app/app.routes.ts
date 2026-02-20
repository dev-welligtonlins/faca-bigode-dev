import { Routes } from '@angular/router';
import { RegisterPage } from './pages/register-page/register-page';

export const routes: Routes = [
  // 1. Redirecionamento da raiz
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },

  // 2. Rota de Layout Principal (DASHBOARD)
  {
    path: 'dashboard',
    loadComponent: () => import('./pages/dashboard-page/dashboard-page').then(m => m.DashboardPage),
    children: [
      // Rota padrão do Dashboard (Redireciona para 'servicos')
      {
        path: '',
        redirectTo: 'servicos',
        pathMatch: 'full'
      },

      // ROTAS FILHAS (Componentes de Rota Agora em 'pages/')
      {
        path: 'servicos/:id',
        loadComponent: () => import('./components/services-component/services-component').then(m => m.ServicesComponent) // Caminho presumido corrigido
      },
      { path: 'barbeiros/:id',
        loadComponent: () => import('./components/barbeiros-component/barbeiros-component').then(m => m.BarbeirosComponent) // Caminho presumido corrigido
      },
      { path: 'Clientes',
        loadComponent: () => import('./components/clientes-component/clientes-component').then(m => m.ClientesComponent) // Caminho presumido corrigido
      },
      { path: 'Agendamentos',
        loadComponent: () => import('./components/agendamentos-component/agendamentos-component').then(m => m.AgendamentosComponent) // Caminho presumido corrigido
      },
      { path: 'Financeiro',
        loadComponent: () => import('./components/financeiro-component/financeiro-component').then(m => m.FinanceiroComponent) // Caminho presumido corrigido
      },
      { path: 'Relatórios',
        loadComponent: () => import('./components/relatorios-component/relatorios-component').then(m => m.RelatoriosComponent) // Caminho presumido corrigido
      },
      { path: 'Configurações', 
        loadComponent: () => import('./components/configuracoes-component/configuracoes-component').then(m => m.ConfiguracoesComponent) // Caminho presumido corrigido
      },
      
    ]
  },
  // 3. ROTAS IRMÃS (Fora do Layout do Dashboard)
  {
    path: 'register',
    loadComponent: () => import('./pages/register-page/register-page').then(m => m.RegisterPage)
  },
  {
    path: 'perfil-barbershop',
    loadComponent: () => import('./pages/perfil-barbershop-page/perfil-barbershop-page').then(m => m.PerfilBarbershopPage)
  },
  {
    path: 'fogot-password',
    loadComponent: () => import('./pages/forgot-password-page/forgot-password-page').then(m => m.ForgotPasswordPage)
  },
  // {
  // path: 'sair', // Rota 'sair' que redireciona para a página de Login
  // loadComponent: () => import('./pages/login-page/login-page').then(m => m.LoginPage) // Caminho presumido corrigido
  // },
]; 
  // {
  //   path: 'dashboard-page',
  //   loadComponent: () => import('./pages/dashboard-page/dashboard-page').then(m => m.DashboardPage)
  // },

  // {
  //   path: 'test-api/:id',
  //   loadComponent: () => import('./pages/test-api-page/test-api-page').then(m => m.TestApiPage)
  // }

