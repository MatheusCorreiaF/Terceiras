import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaOSComponent } from './lista-os.component';

describe('ListaOSComponent', () => {
  let component: ListaOSComponent;
  let fixture: ComponentFixture<ListaOSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaOSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaOSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
