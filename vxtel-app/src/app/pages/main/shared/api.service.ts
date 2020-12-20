import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

import { Response } from './response.model';
import { Request } from './request.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiPath: string = "http://localhost:8080/tariffs";
  protected http: HttpClient;

  constructor(  protected injector: Injector,) {
    this.http = injector.get(HttpClient);
   }

  postTariffs(request: Request) : Observable<Response> {
    return this.http.post(this.apiPath, request).pipe(
      map(this.jsonDataToResponse.bind(this)),
      catchError(this.handleError)
    )
  }


  protected jsonDataToResponse(jsonData: any): Response{
    return jsonData as Response;
  }

protected handleError(error: any): Observable<any> {
  return throwError(error);
  }
}
