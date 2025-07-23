import {inject, Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {ResultType} from '../../share/model/share.model';
import {RegisterRequestType, UserType} from '../model/auth.model';
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

  // ERROR HANDLER

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';

    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Client-side error: ${error.error.message}`;
    } else {
      // Server-side error
      errorMessage = `Server error (${error.status}): ${error.message}`;
    }

    console.error(errorMessage);
    return throwError(() => new Error(errorMessage));
  }
}
