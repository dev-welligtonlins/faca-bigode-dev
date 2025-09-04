import { Component } from '@angular/core';
import { utilsSearchCEP } from '../../utils/utilsSearchCEP';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AddressModel } from '../../models/address-model';

import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
  selector: 'app-perfil-barbeshop-form-address-component',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './perfil-barbeshop-form-address-component.html',
  styleUrl: './perfil-barbeshop-form-address-component.scss'
})
export class PerfilBarbeshopFormAddressComponent {

  form = new FormGroup({
    cep: new FormControl<string>(''),
    logradouro: new FormControl(''),
    bairro: new FormControl(''),
    cidade: new FormControl(''),
    uf: new FormControl('')
  })

  constructor(private utilsSearchCep: utilsSearchCEP) {
    // Observa mudanças no campo de CEP
    this.form.get('cep')?.valueChanges.pipe(
      debounceTime(500),
      distinctUntilChanged()
    ).subscribe((cep) => this.buscarCep(cep as string));

  }

  buscarCep(cep: string) {
    this.utilsSearchCep.consultarCep(cep).subscribe({
      next: (dados: AddressModel) => {
        if (!dados.erro) {
          this.form.patchValue({
            logradouro: dados.logradouro,
            bairro: dados.bairro,
            cidade: dados.localidade,
            uf: dados.uf
          });
        } else {
          this.form.patchValue({
            logradouro: '',
            bairro: '',
            cidade: '',
            uf: ''
          });
        }
      },
      error: () => {
        console.error('Erro ao consultar CEP');
      }
    });
  }
}

