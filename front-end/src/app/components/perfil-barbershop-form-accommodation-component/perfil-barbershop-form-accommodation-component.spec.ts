import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbershopFormAccommodationComponent } from './perfil-barbershop-form-accommodation-component';

describe('PerfilBarbershopFormAccommodationComponent', () => {
  let component: PerfilBarbershopFormAccommodationComponent;
  let fixture: ComponentFixture<PerfilBarbershopFormAccommodationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbershopFormAccommodationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbershopFormAccommodationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
