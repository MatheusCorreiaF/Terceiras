import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Observable } from 'rxjs';
import { Terceira } from '../shared/terceira';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

  terceira = new Terceira();

  constructor(private loginService: LoginService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      this.terceira = <Terceira>JSON.parse(sessionStorage.logado);

      console.log(this.loginService.estaAutenticado());
    if (!this.loginService.estaAutenticado())    
      return this.router.navigate(["/login"]);

    return this.loginService.estaAutenticado()
  }
}
