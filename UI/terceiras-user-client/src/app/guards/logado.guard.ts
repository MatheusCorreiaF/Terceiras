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
      
      if (<boolean>JSON.parse(sessionStorage.estaAutenticado))
      this.router.navigate(["/lista-os"]);

    return !<boolean>JSON.parse(sessionStorage.estaAutenticado)
  }  
}
