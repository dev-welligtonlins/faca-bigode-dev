import { BehaviorSubject, Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { NewBarbershopModel } from "../models/new-barbershop-model";
import { NewAddressModel } from "../models/new-address-model";

@Injectable({
    providedIn: 'root'
})
export class ServiceAddress {

    private baseUrl = `${environment.apiUrl}address/dto/`;

    constructor(private http: HttpClient) {}

    postAddress(address: NewAddressModel): Observable<NewAddressModel> {
        return this.http.post<NewAddressModel>(
            `${this.baseUrl}new-address/`,
            address
        );
    }
}