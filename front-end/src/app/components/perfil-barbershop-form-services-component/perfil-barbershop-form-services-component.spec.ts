import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbershopFormServicesComponent } from './perfil-barbershop-form-services-component';

describe('PerfilBarbershopFormServicesComponent', () => {
  let component: PerfilBarbershopFormServicesComponent;
  let fixture: ComponentFixture<PerfilBarbershopFormServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbershopFormServicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbershopFormServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
