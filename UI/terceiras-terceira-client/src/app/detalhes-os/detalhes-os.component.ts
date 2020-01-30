import { Component, OnInit } from '@angular/core';
import { OrdemServico } from '../shared/ordem-servico';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DetalhesOsService } from './detalhes-os.service';

@Component({
  selector: 'app-detalhes-os',
  templateUrl: './detalhes-os.component.html',
  styleUrls: ['./detalhes-os.component.css']
})
export class DetalhesOsComponent implements OnInit {

  os = new OrdemServico;
  formulario: FormGroup;
  
  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private detailOSService: DetalhesOsService) { }

  ngOnInit() {
    this.os = <OrdemServico>JSON.parse(sessionStorage.osDetail);
    //instancia o formulário
    this.formulario = this.formBuilder.group({
      id: [null, [Validators.required]],
      uc: [null, [Validators.required]],
      servico: [null, [Validators.required]],
      observacao: [null, [Validators.required]],
      status: [null, [Validators.required]]
    });

    this.populaDadosForm();
  }

  //inicializa valores do formulário
  populaDadosForm()
  {
    this.formulario.patchValue( 
    {
      id : this.os.id,
      uc : this.os.uc,
      servico : this.os.servico,
      observacao : this.os.obs,
      status : this.os.status
    });
  }

  //chama o método que fará requisição para atualizar a OS
  atualizarOS()
  {
    this.os.obs = this.formulario.get('observacao').value;
    this.os.status = this.formulario.get('status').value;
    this.detailOSService.atualizaOS(this.os).subscribe();
    this.router.navigate([`/lista-os`]);
  }
  //navega p/ a lista de OS
  backToList(){
    this.router.navigate([`/lista-os`]);
  }
}
