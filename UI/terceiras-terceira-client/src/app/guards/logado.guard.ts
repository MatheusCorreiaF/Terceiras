import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogadoGuard implements CanActivate {
  
  constructor(private router: Router) { }
  
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      //verifica se o Cliente está logado, para evitar que ele acesse a págin de login estando logado
      if (<boolean>JSON.parse(sessionStorage.estaAutenticada))
      this.router.navigate(["/lista-os"]);

    return !<boolean>JSON.parse(sessionStorage.estaAutenticada)
  }  
}
