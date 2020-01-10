import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { HttpClient } from '@angular/common/http';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  oss : OrdemServico[];
  usuarioAutenticado: boolean = false;
  terceira = <Terceira>JSON.parse(sessionStorage.logado);

  apiUrl = `http://localhost:8765/terceiras-service/terceiras/cnpj/${this.terceira.cnpj}`;
    
  constructor(private httpClient: HttpClient) { }

  getOss() {
    return this.httpClient.get(this.apiUrl);
  }


  getAsOs()
  {
    return this.oss;
  }
}
