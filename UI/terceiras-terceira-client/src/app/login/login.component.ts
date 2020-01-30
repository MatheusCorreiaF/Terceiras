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
  authValid: boolean = true;
  
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.consultar();
  }

  fazerLogin()
  {
    this.authValid = this.loginService.autenticaTerceira(this.terceira)    
    this.router.navigate(["/lista-os"]);
  }
}
