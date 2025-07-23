
import {HttpHandlerFn, HttpRequest} from '@angular/common/http';
import {inject} from '@angular/core';
import {Store} from '@ngrx/store';
import {selectToken} from '../../auth/store/auth.selectors';
import {map, take} from 'rxjs/operators';

export function authInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) {

  const store = inject(Store);

  let authToken: string = "";

  store.select(selectToken).pipe(
    take(1),
    map(token => {
      if (token) {
        authToken = "Bearer" + " " + token;
      }
    })
  )

  // SET DEFAULT HEADER
  const headers = req.headers.set('Content-Type', 'application/json');

  if (authToken) headers.set('Authorization', authToken);

  // Clone the request to add the authentication header.
  const newReq = req.clone({ headers });

  return next(newReq);
}
