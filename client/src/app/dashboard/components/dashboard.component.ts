import {Component, inject} from '@angular/core';
import {Store} from '@ngrx/store';
import {LOGOUT} from '../../auth/store/auth.actions';
import {Router} from '@angular/router';

@Component({
  selector: 'dashboard',
  imports: [],
  template: `
    <h1>Dashboard</h1>
    <button (click)="logout()">Logout</button>
  `,
})
export class DashboardComponent {
  store = inject(Store)
  router = inject(Router)

  logout() {
    this.store.dispatch(LOGOUT())
    this.router.navigate(['/login'])
  }
}
