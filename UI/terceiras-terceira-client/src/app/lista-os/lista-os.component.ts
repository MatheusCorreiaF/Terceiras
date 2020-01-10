import { Component, OnInit } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { ListaOsService } from './lista-os.service';

@Component({
  selector: 'app-lista-os',
  templateUrl: './lista-os.component.html',
  styleUrls: ['./lista-os.component.css']
})
export class ListaOsComponent implements OnInit {

  oss: OrdemServico[];

  constructor(private listaOsService: ListaOsService) { }

  ngOnInit()
  {
    this.consultar();
  }

  consultar() {
    //assim que o método obtivewr resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.listaOsService.getOss().subscribe(
      resposta => this.oss = <OrdemServico[]>resposta)
  }

  
}
