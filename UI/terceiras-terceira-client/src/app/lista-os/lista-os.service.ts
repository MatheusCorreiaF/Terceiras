import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { HttpClient } from '@angular/common/http';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  oss : OrdemServico[];
  terceira = <Terceira>JSON.parse(sessionStorage.logada);

  apiUrl = `http://localhost:8765/terceiras-service/terceiras/cnpj/${this.terceira.cnpj}`;
    
  constructor(private httpClient: HttpClient) { }

  getOss() {
    return this.httpClient.get(this.apiUrl);
  }

}
