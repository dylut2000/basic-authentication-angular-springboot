import { Routes } from '@angular/router';
import {AUTH_ROUTES} from './auth/auth.routes';

export const routes: Routes = [
  ...AUTH_ROUTES,
  {path: '', redirectTo: 'login', pathMatch: 'full'},
];
