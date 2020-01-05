import { TestBed } from '@angular/core/testing';

import { ListaOsService } from './lista-os.service';

describe('ListaOsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListaOsService = TestBed.get(ListaOsService);
    expect(service).toBeTruthy();
  });
});
