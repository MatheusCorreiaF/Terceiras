import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhesOsComponent } from './detalhes-os.component';

describe('DetalhesOsComponent', () => {
  let component: DetalhesOsComponent;
  let fixture: ComponentFixture<DetalhesOsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalhesOsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalhesOsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
