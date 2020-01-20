import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListaOsComponent } from './lista-os/lista-os.component';
import { AuthService } from './guards/auth.service';
import { DetalhesOsComponent } from './detalhes-os/detalhes-os.component';
import { LogoutComponent } from './logout/logout.component';
import { LogadoGuard } from './guards/logado.guard';


const routes: Routes = [
  {path: 'login', component: LoginComponent,canActivate: [LogadoGuard]},
  {path: 'lista-os', component: ListaOsComponent, canActivate: [AuthService]},
  {path: 'logout', component: LogoutComponent, canActivate: [AuthService]},
  {path: 'lista-os/:id', component: DetalhesOsComponent, canActivate: [AuthService]},
  { path: '', pathMatch: 'full', redirectTo: 'lista-os' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
