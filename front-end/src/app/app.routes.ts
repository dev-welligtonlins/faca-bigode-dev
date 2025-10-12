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
  }

];
