import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaOSComponent } from './lista-os/lista-os.component';
import { SolicitaServicoComponent } from './solicita-servico/solicita-servico.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListaOSComponent,
    SolicitaServicoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [LoginComponent]
})
export class AppModule { }
