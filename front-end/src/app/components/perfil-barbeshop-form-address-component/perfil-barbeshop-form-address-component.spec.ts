import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbeshopFormAddressComponent } from './perfil-barbeshop-form-address-component';

describe('PerfilBarbeshopFormAddressComponent', () => {
  let component: PerfilBarbeshopFormAddressComponent;
  let fixture: ComponentFixture<PerfilBarbeshopFormAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbeshopFormAddressComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbeshopFormAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
