import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../shared/cliente';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  apiUrl = "http://localhost:8765/main-company-service/api/cliente";
  clientes : Cliente[];
  usuarioAutenticado: boolean = false;
    
  constructor(private httpClient: HttpClient) { }

  getClientes() {
    return this.httpClient.get(this.apiUrl);
  }

  consultar() {
    //assim que o método obtiver resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.getClientes().subscribe(
      resposta => this.clientes = <Cliente[]>resposta)
  }

  autenticaCliente(cliente: Cliente)
  {
    this.clientes.forEach(element => {
      if(element.cpf==cliente.cpf && element.uc==cliente.uc)
      {
        cliente = element;
        this.usuarioAutenticado = true;
      }
    });
  }

  estaAutenticado()
  {
    return this.usuarioAutenticado;
  }
}
