import { TestBed } from '@angular/core/testing';

import { DetalhesOsService } from './detalhes-os.service';

describe('DetalhesOsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DetalhesOsService = TestBed.get(DetalhesOsService);
    expect(service).toBeTruthy();
  });
});
