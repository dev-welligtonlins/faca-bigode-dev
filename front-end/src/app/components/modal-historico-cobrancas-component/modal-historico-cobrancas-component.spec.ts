import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalHistoricoCobrancasComponent } from './modal-historico-cobrancas-component';

describe('ModalHistoricoCobrancasComponent', () => {
  let component: ModalHistoricoCobrancasComponent;
  let fixture: ComponentFixture<ModalHistoricoCobrancasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalHistoricoCobrancasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalHistoricoCobrancasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
