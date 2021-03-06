import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrdemServico } from '../shared/ordem-servico';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SolicitaServicoService {

  apiUrl = "http://localhost:8765/registro-os-service/registro-os";
  //apiUrl = "http://zuul-api-gateway-server:8765/registro-os-service/registro-os";
         
  constructor(private httpClient: HttpClient) { }
  
  //envia a requisição para salvar a OS
  sendOS(os:OrdemServico)
  {
    return this.httpClient.post(this.apiUrl,os).pipe(take(1));
  }

}
