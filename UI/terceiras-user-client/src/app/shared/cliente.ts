import { Endereco } from './endereco';

export class Cliente
{
    cpf: String ='';
    email: String='';
    endereco: Endereco = new Endereco();
    nome: String='';
    telefone: String='';
    uc: Number=null
}