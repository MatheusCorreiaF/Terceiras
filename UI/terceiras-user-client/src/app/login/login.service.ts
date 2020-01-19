import { Injectable, EventEmitter, Output } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cliente } from '../shared/cliente';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiUrl = "http://localhost:8765/main-company-service/api/cliente";
  //apiUrl = "http://localhost:8080/api/cliente";
  clientes: Cliente[];
  mostrarMenuEmitter = new EventEmitter<boolean>(sessionStorage.estaAutenticado);
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
    //assim que o método obtiver resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.getClientes().subscribe(
      resposta => this.clientes = <Cliente[]>resposta)
  }

  autenticaCliente(cliente: Cliente){
    this.clientes.forEach(element => {
      if (element.cpf == cliente.cpf && element.uc == cliente.uc) {
        cliente = element;
        sessionStorage.estaAutenticado = true;
        this.mostrarMenuEmitter.emit(sessionStorage.estaAutenticado);
        sessionStorage.logado = (JSON.stringify(cliente));
      }
    });
  }
}
