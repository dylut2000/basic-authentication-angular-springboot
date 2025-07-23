import { Injectable, inject } from '@angular/core';
import { Actions, ofType, createEffect } from '@ngrx/effects';
import {of, tap} from 'rxjs';
import { catchError, exhaustMap, map } from 'rxjs/operators';
import * as AuthActions from './auth.actions';
import { AuthService } from '../service/auth.service';
import {Router} from '@angular/router';

@Injectable()
export class AuthEffects {
  private actions$ = inject(Actions);
  private authService = inject(AuthService);
  private router:Router = inject(Router);

  // REGISTER EFFECT

  register$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.REGISTER),
      exhaustMap(action =>
        this.authService.register(action.credentials).pipe(
          map(result => {
            return AuthActions.REGISTER_SUCCESS({ data: result.data })
          }),
          catchError(error => of(AuthActions.REGISTER_FAILURE({ error: error?.message })))
        )
      )
    );
  });

  // REGISTER SUCCESS EFFECT

  registerSuccess$ = createEffect(() => {
    return this.actions$.pipe(ofType(AuthActions.REGISTER_SUCCESS),
      tap(data => {
        this.router.navigate(['/login']);
      }),
    );
  }, { dispatch: false });

  // REGISTER FAIL EFFECT

  registerFail$ = createEffect(() => {
    return this.actions$.pipe(ofType(AuthActions.REGISTER_FAILURE),
      tap(data => {
        console.log(data)
      }),
    );
  }, { dispatch: false });

  // LOGIN EFFECT

  login$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.LOGIN),
      exhaustMap(action =>
        this.authService.login(action.credentials).pipe(
          map(result => {
            return AuthActions.LOGIN_SUCCESS({ data: result.data })
          }),
          catchError(error => of(AuthActions.LOGIN_FAILURE({ error: error?.message })))
        )
      )
    );
  });

  // LOGIN SUCCESS EFFECT

  loginSuccess$ = createEffect(() => {
    return this.actions$.pipe(ofType(AuthActions.LOGIN_SUCCESS),
      tap(data => {
        this.router.navigate(['/dashboard']);
      }),
    );
  }, { dispatch: false });


  // REGISTER FAIL EFFECT

  loginFail$ = createEffect(() => {
    return this.actions$.pipe(ofType(AuthActions.LOGIN_FAILURE),
      tap(data => {
        console.log(data)
      }),
    );
  }, { dispatch: false });


}
