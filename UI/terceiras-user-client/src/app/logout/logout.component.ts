import { Component, OnInit, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    console.log("uoooooow");
    sessionStorage.estaAutenticado = false;
    this.router.navigate(["/login"]);
  }

}
