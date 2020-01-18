import { Component, OnInit } from '@angular/core';
import { Terceira } from '../shared/terceira';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  terceira = new Terceira();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.consultar();
    sessionStorage.logado=null;
    this.terceira.cnpj="t123456789"
    console.log(sessionStorage.logado);
  }

  fazerLogin()
  {
    sessionStorage.logado = null;
    this.loginService.autenticaTerceira(this.terceira)    
    this.router.navigate(["/lista-os/"]);
  }
}