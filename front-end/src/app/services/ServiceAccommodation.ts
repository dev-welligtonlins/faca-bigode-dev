import { BehaviorSubject, Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { NewAccommodationModel } from "../models/new-accommodation-model";

@Injectable({
    providedIn: 'root'
})
export class ServiceAccommodation {

    private baseUrl = `${environment.apiUrl}accommodations/dto/`;

    constructor(private http: HttpClient) {}

    postAccommodation(accommodation: NewAccommodationModel): Observable<NewAccommodationModel> {
        return this.http.post<NewAccommodationModel>(
            `${this.baseUrl}new-accommodation/`,
            accommodation
        );
    }
}