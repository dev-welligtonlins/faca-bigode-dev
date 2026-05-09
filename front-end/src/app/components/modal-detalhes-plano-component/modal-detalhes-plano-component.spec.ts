import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalDetalhesPlanoComponent } from './modal-detalhes-plano-component';

describe('ModalDetalhesPlanoComponent', () => {
  let component: ModalDetalhesPlanoComponent;
  let fixture: ComponentFixture<ModalDetalhesPlanoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalDetalhesPlanoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalDetalhesPlanoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
