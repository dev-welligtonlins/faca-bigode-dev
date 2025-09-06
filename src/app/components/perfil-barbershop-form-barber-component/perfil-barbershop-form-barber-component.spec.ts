import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbershopFormBarberComponent } from './perfil-barbershop-form-barber-component';

describe('PerfilBarbershopFormBarberComponent', () => {
  let component: PerfilBarbershopFormBarberComponent;
  let fixture: ComponentFixture<PerfilBarbershopFormBarberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbershopFormBarberComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbershopFormBarberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
