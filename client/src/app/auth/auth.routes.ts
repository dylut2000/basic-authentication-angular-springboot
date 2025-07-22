import {Route} from '@angular/router';

// LAZY LOAD COMPONENTS

export const AUTH_ROUTES: Route[] = [
  {path: 'login', loadComponent: () => import('./components/login.component').then(m => m.LoginComponent)},
  {path: 'register', loadComponent: () => import('./components/register.component').then(m => m.RegisterComponent)},
];
