import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbershopFormPerfilComponent } from './perfil-barbershop-form-perfil-component';

describe('PerfilBarbershopFormPerfilComponent', () => {
  let component: PerfilBarbershopFormPerfilComponent;
  let fixture: ComponentFixture<PerfilBarbershopFormPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbershopFormPerfilComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbershopFormPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
