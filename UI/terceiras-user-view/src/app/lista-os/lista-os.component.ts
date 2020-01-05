import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { ListaOsService } from './lista-os.service';
import { OrdemServico } from '../shared/ordemServico';

@Component({
  selector: 'app-lista-os',
  templateUrl: './lista-os.component.html',
  styleUrls: ['./lista-os.component.css']
})
export class ListaOSComponent implements OnInit {

  oss: OrdemServico[];
  
  constructor(private route: ActivatedRoute, private listaOsService: ListaOsService) { }

  ngOnInit() {
    this.route.params.subscribe( parametros => {
        this.listaOsService.consultar(parametros['uc']);
    });    
  }

  ngDoCheck()
  {
    this.oss=this.listaOsService.getAsOs();

  }

  //reloadTable(){
  //this.oss=this.listaOsService.getAsOs();
  //}
}
