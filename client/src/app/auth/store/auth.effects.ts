import { Injectable, inject } from '@angular/core';
import { Actions, ofType, createEffect } from '@ngrx/effects';
import { of } from 'rxjs';
import { catchError, exhaustMap, map } from 'rxjs/operators';
import * as AuthActions from './auth.actions';
import { AuthService } from '../service/auth.service';
import {Router} from '@angular/router';

@Injectable()
export class AuthEffects {
  private actions$ = inject(Actions);
  private authService = inject(AuthService);
  private router:Router = inject(Router);

  register$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.REGISTER),
      exhaustMap(action =>
        this.authService.register(action.credentials).pipe(
          map(result => {
            setTimeout(() => { this.router.navigate(['/login']);}, 3000)
            return AuthActions.REGISTER_SUCCESS({ data: result.data })
          }),
          catchError(error => of(AuthActions.REGISTER_FAILURE({ error })))
        )
      )
    );
  });
}
