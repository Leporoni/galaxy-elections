import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RestService {

  url = 'http://localhost:8080/api';
  constructor(private httpClient: HttpClient) {  }

  getData(endpoint: string): Observable<any[]> {
    console.log(`${this.url}${endpoint}`)
    return this.httpClient.get<any[]>(`${this.url}${endpoint}`);
  }

  postData(endpoint: string, data: any): Observable<any> {
    console.log(`${this.url}${endpoint}`, data)
    return this.httpClient
      .post<any[]>(`${this.url}${endpoint}`, data)
      .pipe(catchError(this.handleError));
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Error occurred on client side
      errorMessage = error.error.message;
    } else {
      // Error occurred on the server side
      errorMessage = `Error code: ${error.status}, ` + `message: ${error.message}`;
    }
    //console.log(errorMessage);
    return throwError(() => new Error(errorMessage));
  };
}
