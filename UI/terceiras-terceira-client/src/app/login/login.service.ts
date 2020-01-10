import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  apiURL = `http://localhost:8765/central-terceiras-service/api/central-terceiras/terceira`
  terceiras: Terceira[];
  terceiraLogada = new EventEmitter<Terceira>();
  terceiraAutenticada: boolean = false;

  constructor(private httpClient: HttpClient) { }

  getTerceiras()
  {
      return this.httpClient.get(this.apiURL);
  }

  consultar()
  {
    this.getTerceiras().subscribe(
      resposta => this.terceiras = <Terceira[]>resposta)
  }

  autenticaTerceira(terceira: Terceira)
  {
    for (let i = 0; i < this.terceiras.length; i++) {
      if(terceira.cnpj == this.terceiras[i].cnpj)
      {
        terceira = this.terceiras[i];
        console.log(`${terceira.razaoSocial} cadastrado`);
        this.terceiraAutenticada = true;
        sessionStorage.logado = JSON.stringify(terceira);
        return terceira;
      }      
    }
    console.log(`Terceira não cadastrada`);
    return terceira;
  }

  estaAutenticado()
  {
    return this.terceiraAutenticada;
  }

}
