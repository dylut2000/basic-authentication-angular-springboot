import {inject, Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {ResultType} from '../../share/model/share.model';
import {LoginRequestType, RegisterRequestType, UserType} from '../model/auth.model';
import {catchError, Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  api: string = environment.server;

  http: HttpClient = inject(HttpClient);

  // REGISTER

  register(credentials: RegisterRequestType): Observable<ResultType<UserType>> {
    return this.http.post<ResultType<UserType>>(`${this.api}/api/users/register`, credentials).pipe(
      catchError(this.handleError)
    );
  }


  // LOGIN

  login(credentials: LoginRequestType): Observable<ResultType<UserType>> {
    return this.http.post<ResultType<UserType>>(`${this.api}/api/users/login`, credentials).pipe(
      catchError(this.handleError)
    );
  }

  // ERROR HANDLER

  private handleError(error: HttpErrorResponse) {

    let errorMessage = error.error ? error.error.message : 'An unknown error occurred!';

    return throwError(() => new Error(errorMessage));
  }
}
