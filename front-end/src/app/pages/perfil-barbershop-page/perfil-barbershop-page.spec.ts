import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilBarbershopPage } from './perfil-barbershop-page';

describe('PerfilBarbershopPage', () => {
  let component: PerfilBarbershopPage;
  let fixture: ComponentFixture<PerfilBarbershopPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PerfilBarbershopPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PerfilBarbershopPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
