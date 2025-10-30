import { Routes } from '@angular/router';
import { RegisterPage } from './pages/register-page/register-page';

export const routes: Routes = [
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

  {
    path: 'dashboard-page',
    loadComponent: () => import('./pages/dashboard-page/dashboard-page').then(m => m.DashboardPage)
  }
];
