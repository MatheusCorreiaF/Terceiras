import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListaOsComponent } from './lista-os/lista-os.component';
import { AuthService } from './guards/auth.service';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'lista-os', component: ListaOsComponent, canActivate: [AuthService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
