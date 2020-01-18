import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListaOsComponent } from './lista-os/lista-os.component';
import { AuthService } from './guards/auth.service';
import { DetalhesOsComponent } from './detalhes-os/detalhes-os.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'lista-os', component: ListaOsComponent, canActivate: [AuthService]},
  {path: 'lista-os/:id', component: DetalhesOsComponent, canActivate: [AuthService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
