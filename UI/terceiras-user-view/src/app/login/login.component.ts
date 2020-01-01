import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  clientes = [];
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    //assim que o método obtivewr resposta, eu atribuo a 'resposta', e então utilizo essa 'resposta como necessario'
    this.loginService.getClientes().subscribe(
      resposta => this.clientes = <any>resposta)
  }

  fazerLogin()
  {}
}
