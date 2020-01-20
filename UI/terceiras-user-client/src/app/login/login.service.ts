import { Injectable, EventEmitter, Output } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cliente } from '../shared/cliente';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiUrl = "http://localhost:8765/main-company-service/api/cliente";
  clientes: Cliente[];
  
  constructor(private httpClient: HttpClient) { }
  
  getClientes() {
  /*let username = 'redfield'
    let password = 'redfield'
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    
    let headers = new HttpHeaders({
         Authorization: basicAuthHeaderString})
    
    return this.httpClient.get(this.apiUrl,{headers});*/
    return this.httpClient.get(this.apiUrl);
  }

  consultar() {
    this.getClientes().subscribe(
      resposta => this.clientes = <Cliente[]>resposta)
  }

  autenticaCliente(cliente: Cliente) : boolean{
    this.clientes.forEach(element => {
      if (element.cpf == cliente.cpf && element.uc == cliente.uc) {
        cliente = element;
        sessionStorage.estaAutenticado = true;
        //this.mostrarMenuEmitter.emit(sessionStorage.estaAutenticado);
        sessionStorage.logado = (JSON.stringify(cliente));
        return true;
      }
    });
    return false;
  }
}
