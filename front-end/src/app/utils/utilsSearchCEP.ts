import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddressModel } from '../models/address-model';

@Injectable({  providedIn: 'root' })
export class utilsSearchCEP {

  private apiUrl = 'https://viacep.com.br/ws';

  constructor(private http: HttpClient) {}

  consultarCep(cep: string): Observable<AddressModel> {
    // remove caracteres não numéricos do CEP
    const cepClean = cep.replace(/\D/g, '');
    return this.http.get<AddressModel>(`${this.apiUrl}/${cepClean}/json/`);
  }
}
