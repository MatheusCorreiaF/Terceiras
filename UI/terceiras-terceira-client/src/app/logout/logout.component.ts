import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  //encerra a sessão e encaminha para a tela de login
  ngOnInit() {
    sessionStorage.estaAutenticada = false;
    sessionStorage.logada = null;
    this.router.navigate(["/login"]);
  }

}
