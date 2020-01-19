import { Component } from '@angular/core';
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  mostrarMenu: boolean;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    if(sessionStorage.estaAutenticado === undefined)
       sessionStorage.estaAutenticado = false;
    
    this.loginService.mostrarMenuEmitter.subscribe(
      mostrar => {
        this.mostrarMenu = mostrar;
        console.log(">>>>>>>>" + mostrar);
      });

    this.mostrarMenu = <boolean>JSON.parse(sessionStorage.estaAutenticado);
  }

  estaAutenticado()
  {
    console.log(<boolean>JSON.parse(sessionStorage.estaAutenticado));
    return <boolean>JSON.parse(sessionStorage.estaAutenticado);
  }

  logout()
  {
    sessionStorage.estaAutenticado = false;
    this.mostrarMenu = <boolean>JSON.parse(sessionStorage.estaAutenticado);
  }
}
