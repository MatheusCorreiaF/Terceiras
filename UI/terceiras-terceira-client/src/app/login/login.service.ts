import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiURL = `http://localhost:8765/central-terceiras-service/api/central-terceiras/terceira`
  terceiras: Terceira[];

  constructor(private httpClient: HttpClient) { }

  //consulta Terceiras cadastradas
  getTerceiras() {
    /*let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
         Authorization: basicAuthHeaderString})*/
    return this.httpClient.get(this.apiURL);
  }
  consultar() {
    this.getTerceiras().subscribe(
      resposta => this.terceiras = <Terceira[]>resposta);
  }

  //verifica se as credenciais são válidas
  autenticaTerceira(terceira: Terceira): boolean {
    sessionStorage.estaAutenticada = false;
    for (let i = 0; i < this.terceiras.length; i++) {
      if (terceira.cnpj == this.terceiras[i].cnpj) {
        terceira = this.terceiras[i];
        sessionStorage.estaAutenticada = true;
        sessionStorage.logada = JSON.stringify(terceira);
        return true;
      }
    }
    return false;
  }
}
