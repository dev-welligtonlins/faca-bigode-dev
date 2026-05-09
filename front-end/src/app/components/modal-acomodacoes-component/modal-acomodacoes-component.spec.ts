import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAcomodacoesComponent } from './modal-acomodacoes-component';

describe('ModalAcomodacoesComponent', () => {
  let component: ModalAcomodacoesComponent;
  let fixture: ComponentFixture<ModalAcomodacoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalAcomodacoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalAcomodacoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
