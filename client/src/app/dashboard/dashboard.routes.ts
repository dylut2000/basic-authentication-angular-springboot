import {Route} from '@angular/router';

// LAZY LOAD COMPONENTS

export const DASHBOARD_ROUTES: Route[] = [
  {path: 'dashboard', loadComponent: () => import('./components/dashboard.component').then(m => m.DashboardComponent)}
];
