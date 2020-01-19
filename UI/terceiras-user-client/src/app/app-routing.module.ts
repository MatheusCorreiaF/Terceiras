import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { ListaOSComponent } from './lista-os/lista-os.component';
import { SolicitaServicoComponent } from './solicita-servico/solicita-servico.component';
import { LogadoGuard } from './guards/logado.guard';
import { LogoutComponent } from './logout/logout.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate:[LogadoGuard]},
  { path: 'lista-os', component: ListaOSComponent, canActivate:[AuthGuard]},
  { path: 'logout', component: LogoutComponent, canActivate:[AuthGuard]},
  { path: 'os', component: SolicitaServicoComponent, canActivate:[AuthGuard]},
  { path: '', pathMatch: 'full', redirectTo: 'lista-os' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
