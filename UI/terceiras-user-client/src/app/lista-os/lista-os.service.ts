import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  apiUrl = "http://localhost:8765/main-company-service/api/os/uc/";
  oss : OrdemServico[];
  usuarioAutenticado: boolean = false;
    
  constructor(private httpClient: HttpClient) { }

  getOss(uc: Number) {
    return this.httpClient.get<OrdemServico[]>(this.apiUrl+uc);
  }

  /* getOss(uc: Number) {
    return this.httpClient.get(this.apiUrl+uc);
  }

  consultar(uc: Number) {
    //assim que o método obtiver resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.getOss(uc).subscribe(
      resposta => this.oss = <OrdemServico[]>resposta)
  }
 */
}
