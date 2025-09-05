export interface AddressModel {
  cep: string;
  number: string;
  logradouro: string;
  bairro: string;
  complemento: string;
  localidade: string;
  uf: string;
  erro?: boolean; // usado quando CEP não existe
}