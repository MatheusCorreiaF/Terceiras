import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { ListaOsService } from './lista-os.service';
import { OrdemServico } from '../shared/ordem-servico';
import { Cliente } from '../shared/cliente';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-lista-os',
  templateUrl: './lista-os.component.html',
  styleUrls: ['./lista-os.component.css']
})
export class ListaOSComponent implements OnInit {
  
  oss: OrdemServico[] = [];
  clienteLogado: Cliente = JSON.parse(sessionStorage.logado);
  
  constructor(private listaOsService: ListaOsService) { }
              
  ngOnInit() {
    this.reloadTable();
  }    
  
  ngAfterViewInit() {
    this.reloadTable();
  }

  reloadTable(){
    this.listaOsService.getOss(this.clienteLogado.uc).subscribe(
      response => {
        this.oss = <OrdemServico[]>response;
      });
  }
}