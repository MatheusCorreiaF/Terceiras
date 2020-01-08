import { Terceira } from './terceira';

export class OrdemServico {
    id: Number = 0;
    servico: String = "";
    uc: Number = null;
    terceira: Terceira = new Terceira();
    status: String = "";
    obs: String = "";
}
