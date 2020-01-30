import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from '../shared/cliente';
import { OrdemServico } from '../shared/ordem-servico';
import { SolicitaServicoService } from './solicita-servico.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-solicita-servico',
  templateUrl: './solicita-servico.component.html',
  styleUrls: ['./solicita-servico.component.css']
})
export class SolicitaServicoComponent implements OnInit {
  
  formulario: FormGroup;
  cliente = <Cliente>JSON.parse(sessionStorage.logado);
  os = new OrdemServico();
  
  constructor(private formBuilder: FormBuilder, 
              private solicitaServicoS: SolicitaServicoService,
              private router: Router) { }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      servico: [null, [Validators.required, Validators.minLength(10)]]})      
  }

  enviaOs()
  {
    this.formulario.get('servico').markAsTouched();
    this.os.servico = this.formulario.get('servico').value;
    this.os.uc = this.cliente.uc;
    if(this.formulario.get('servico').valid)
    {
      this.solicitaServicoS.sendOS(this.os).subscribe(); 
      this.router.navigate(["/lista-os"])
    }
  }
  //verifica se o formulário foi preenchido corretamente antes de enviar
  formIsValid()
  {
    return this.formulario.get('servico').invalid && this.formulario.get('servico').touched
  }
}
