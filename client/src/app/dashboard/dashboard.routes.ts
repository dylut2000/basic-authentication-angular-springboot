import {Route} from '@angular/router';
import {authGuard} from '../auth/service/auth.guard';

// LAZY LOAD COMPONENTS

export const DASHBOARD_ROUTES: Route[] = [
  {
    path: 'dashboard',
    loadComponent: () => import('./components/dashboard.component').then(m => m.DashboardComponent),
    canActivate: [authGuard],
  }
];
