import { BehaviorSubject } from "rxjs";
import { ServiceModel } from "../models/service.model";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { DashboardServiceModel } from "../models/dashboard-service-model";

@Injectable({
    providedIn: 'root'
})
export class sService {

    private baseUrl = `${environment.apiUrl}dashboard/dto/`;

    constructor(private http: HttpClient) {}

    getAllServices(id: number) {
        return this.http.get<DashboardServiceModel>(`${this.baseUrl}service/${id}`);
    }

    private servicesSubject = new BehaviorSubject<ServiceModel[]>([]);
    services$ = this.servicesSubject.asObservable();

    get services(): ServiceModel[] {
        return this.servicesSubject.value;
    }

    addService(service: ServiceModel): void {
        this.servicesSubject.next([...this.services, service]);
    }
    
    removeService(index: number): void {
        const updated = this.services.filter((_, i) => i !== index);
        this.servicesSubject.next(updated);
    }

    clearServices(): void {
        this.servicesSubject.next([]);
    }
}