import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { AppComponent } from './app.component';
import { ListaOSComponent } from './lista-os/lista-os.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'lista-os', component: ListaOSComponent, canActivate:[AuthGuard]},
  { path: '', pathMatch: 'full', redirectTo: 'lista-os' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
