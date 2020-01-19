import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../login/login.service';
import { Cliente } from '../shared/cliente';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      console.log("Autenticado : " + <boolean>JSON.parse(sessionStorage.estaAutenticado));
      
    if (!<boolean>JSON.parse(sessionStorage.estaAutenticado))
      this.router.navigate(["/login"]);

    return <boolean>JSON.parse(sessionStorage.estaAutenticado)
  }
}