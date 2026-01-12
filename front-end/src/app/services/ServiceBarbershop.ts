import { BehaviorSubject, Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { NewBarbershopModel } from "../models/new-barbershop-model";

@Injectable({
    providedIn: 'root'
})
export class ServiceBarbershop {

    private baseUrl = `${environment.apiUrl}barbershops/dto/`;

    constructor(private http: HttpClient) {}

    postBarbershop(barbershop: NewBarbershopModel): Observable<NewBarbershopModel> {
        return this.http.post<NewBarbershopModel>(`${this.baseUrl}new-barbershop/`, barbershop);
    }
}