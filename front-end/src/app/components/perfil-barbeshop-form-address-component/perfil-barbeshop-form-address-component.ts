import { Component, Input, OnInit } from '@angular/core';
import { utilsSearchCEP } from '../../utils/utilsSearchCEP';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AddressModel } from '../../models/address-model';

import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-perfil-barbeshop-form-address-component',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil-barbeshop-form-address-component.html',
  styleUrl: './perfil-barbeshop-form-address-component.scss'
})
export class PerfilBarbeshopFormAddressComponent implements OnInit {
  @Input() form!: FormGroup;

  constructor(private utilsSearchCep: utilsSearchCEP) { }

  ngOnInit(): void {
    this.form.get('cep')?.setValidators([
      Validators.required,
    ]);

    this.form.get('cep')?.valueChanges.pipe(
      debounceTime(500), distinctUntilChanged()).subscribe((cep) => {
        if(this.form.get('cep')?.valid) {
          this.buscarCep(cep as string);
        } 
      });
  }

  buscarCep(cep: string) {
    this.utilsSearchCep.consultarCep(cep).subscribe({
      next: (dados: AddressModel) => {
        if (!dados.erro) {
          this.form.patchValue({
            logradouro: dados.logradouro,
            bairro: dados.bairro,
            localidade: dados.localidade,
            uf: dados.uf,
          });
        } else {
          this.form.patchValue({
            logradouro: '',
            bairro: '',
            localidade: '',
            uf: '',
          });
        }
      },
      error: () => {
        console.error('Erro ao consultar CEP');
      }
    });
  }
}

