import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrdemServico } from '../shared/ordem-servico';

@Injectable({
  providedIn: 'root'
})
export class DetalhesOsService {

  constructor(private httpClient: HttpClient) { }

  apiUrl = `http://localhost:8765/terceiras-service/terceiras`;

  //envia a requisição com as alterações da OS
  atualizaOS(os: OrdemServico)
  {
    return this.httpClient.put(this.apiUrl,os);
  }
}
