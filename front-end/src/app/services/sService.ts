import { BehaviorSubject } from "rxjs";
import { ServiceModel } from "../models/service.model";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class sService {
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