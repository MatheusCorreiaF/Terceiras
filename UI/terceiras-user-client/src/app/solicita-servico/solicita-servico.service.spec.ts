import { TestBed } from '@angular/core/testing';

import { SolicitaServicoService } from './solicita-servico.service';

describe('SolicitaServicoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SolicitaServicoService = TestBed.get(SolicitaServicoService);
    expect(service).toBeTruthy();
  });
});
