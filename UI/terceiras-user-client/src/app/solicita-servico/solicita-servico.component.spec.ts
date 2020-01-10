import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitaServicoComponent } from './solicita-servico.component';

describe('SolicitaServicoComponent', () => {
  let component: SolicitaServicoComponent;
  let fixture: ComponentFixture<SolicitaServicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SolicitaServicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SolicitaServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
