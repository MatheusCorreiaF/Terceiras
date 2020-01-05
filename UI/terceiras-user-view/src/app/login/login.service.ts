import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiUrl = "http://localhost:8765/main-company-service/api/cliente";

  constructor(private httpClient: HttpClient) { }

  getClientes()
  {
    return this.httpClient.get(this.apiUrl);
  }
}
