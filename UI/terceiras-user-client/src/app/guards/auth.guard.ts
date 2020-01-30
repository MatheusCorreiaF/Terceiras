import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      //verifica se Cliente está logado. Caso não esteja, envia para a tela de login
    if (!<boolean>JSON.parse(sessionStorage.estaAutenticado))
      this.router.navigate(["/login"]);

    return <boolean>JSON.parse(sessionStorage.estaAutenticado)
  }
}