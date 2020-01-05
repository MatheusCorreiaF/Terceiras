import { Injectable } from '@angular/core';
import { OrdemServico } from '../shared/ordemServico';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListaOsService {

  apiUrl = "http://localhost:8765/main-company-service/api/os/uc/";
  oss : OrdemServico[];
  usuarioAutenticado: boolean = false;
    
  constructor(private httpClient: HttpClient) { }

  getOss(uc: String) {
    return this.httpClient.get(this.apiUrl+uc);
  }

  consultar(uc: String) {
    //assim que o método obtiver resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.getOss(uc).subscribe(
      resposta => this.oss = <OrdemServico[]>resposta)
  }

  getAsOs()
  {
    return this.oss;
  }
}
