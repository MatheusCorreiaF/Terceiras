import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { HttpClient } from '@angular/common/http';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  constructor(private httpClient: HttpClient) { }
  
  //busca as OS por CNPJ
  getOss() {
    let terceira = <Terceira>JSON.parse(sessionStorage.logada);
    let apiUrl = `http://localhost:8765/terceiras-service/terceiras/cnpj/${terceira.cnpj}`;
      
    return this.httpClient.get(apiUrl);
  }

}
