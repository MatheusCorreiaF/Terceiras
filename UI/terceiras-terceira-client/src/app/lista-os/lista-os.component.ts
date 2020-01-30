import { Component, OnInit } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { ListaOsService } from './lista-os.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-os',
  templateUrl: './lista-os.component.html',
  styleUrls: ['./lista-os.component.css']
})
export class ListaOsComponent implements OnInit {

  oss: OrdemServico[] = [];

  constructor(private listaOsService: ListaOsService,
    private router: Router) { }

  ngOnInit() {
    this.reloadTable()
  }

  ngAfterViewInit() {
    this.reloadTable()
  }

  reloadTable() {
    this.listaOsService.getOss().subscribe(
      response => {
        this.oss = <OrdemServico[]>response;
      });
  }

  acessaDetail(os: OrdemServico) {
    sessionStorage.osDetail = JSON.stringify(os);
    this.router.navigate(["/lista-os/", os.id]);
  }
}
