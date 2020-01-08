import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { AppComponent } from './app.component';
import { ListaOSComponent } from './lista-os/lista-os.component';
import { SolicitaServicoComponent } from './solicita-servico/solicita-servico.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'lista-os/:uc', component: ListaOSComponent, canActivate:[AuthGuard]},
  { path: 'os', component: SolicitaServicoComponent, canActivate:[AuthGuard]},
  { path: '', pathMatch: 'full', redirectTo: 'lista-os/0' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
