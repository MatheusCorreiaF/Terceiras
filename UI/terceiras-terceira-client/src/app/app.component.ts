import { Component } from '@angular/core';
import { Terceira } from './shared/terceira';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  terceiraLogada = new Terceira();

  constructor() { }

  ngOnInit() {
    if (sessionStorage.estaAutenticada == undefined)
      sessionStorage.estaAutenticada = false;
  }

  estaAutenticada() {
    if (sessionStorage.logada == undefined)
      sessionStorage.logada = JSON.stringify(this.terceiraLogada);

    this.terceiraLogada = <Terceira>JSON.parse(sessionStorage.logada)
    return <boolean>JSON.parse(sessionStorage.estaAutenticada);
  }
}
