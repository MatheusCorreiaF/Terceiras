import { Component } from '@angular/core';
import { Cliente } from './shared/cliente';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  
  clienteLogado = new Cliente();

  constructor() { }

  ngOnInit() {
    if(sessionStorage.estaAutenticado == undefined)
       sessionStorage.estaAutenticado = false;
  }

  estaAutenticado(){
    if(sessionStorage.logado==undefined)
      sessionStorage.logado=JSON.stringify(this.clienteLogado)
    
    this.clienteLogado = <Cliente>JSON.parse(sessionStorage.logado)
    return <boolean>JSON.parse(sessionStorage.estaAutenticado);
  }
}
