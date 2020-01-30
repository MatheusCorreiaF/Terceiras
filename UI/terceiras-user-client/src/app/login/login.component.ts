import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Cliente } from '../shared/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  cliente = new Cliente();
  authValid: boolean = true;
  
  constructor(private loginService: LoginService,private router: Router) { }

  ngOnInit() {
    this.loginService.consultar();
  } 

  fazerLogin()
  {
    this.authValid = this.loginService.autenticaCliente(this.cliente)
    this.router.navigate(["/lista-os"]);
  }
}
