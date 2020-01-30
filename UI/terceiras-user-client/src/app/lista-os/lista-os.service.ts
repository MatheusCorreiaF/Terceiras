import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  apiUrl = "http://localhost:8765/main-company-service/api/os/uc/";
  //apiUrl = "http://zuul-api-gateway-server:8765/main-company-service/api/os/uc/";
  oss : OrdemServico[];
  usuarioAutenticado: boolean = false;
    
  constructor(private httpClient: HttpClient) { }

  //busca as OS por Unidade Consumidora
  getOss(uc: Number) {
    return this.httpClient.get<OrdemServico[]>(this.apiUrl+uc);
  }
}
