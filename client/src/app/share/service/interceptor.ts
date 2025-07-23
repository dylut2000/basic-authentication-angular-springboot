
import {HttpHandlerFn, HttpRequest} from '@angular/common/http';
import {inject} from '@angular/core';

export function authInterceptor(req: HttpRequest<unknown>, next: HttpHandlerFn) {
  // Inject the current `AuthService` and use it to get an authentication token:
  // const authToken = inject(AuthService).getAuthToken();
  const authToken = "Bearer" + " " + "<KEY>";
  // Clone the request to add the authentication header.
  const newReq = req.clone({
    headers: req.headers.append('Authentication', authToken).set('Content-Type', 'application/json')
  });
  return next(newReq);
}
