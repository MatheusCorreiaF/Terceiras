import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../login/login.service';
import { Cliente } from '../shared/cliente';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private route: ActivatedRoute, private loginService: LoginService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      console.log("Autenticado : " + this.loginService.getAutenticado());

      /* this.loginService.logado.subscribe(
        logado =>{
          console.log(logado);
        }) */

    if (!this.loginService.getAutenticado())
      this.router.navigate(["/login"]);

    return this.loginService.getAutenticado()
  }

}
