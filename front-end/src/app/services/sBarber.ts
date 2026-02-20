import { BehaviorSubject } from "rxjs";
import { BarberModel } from "../models/barber-model";
import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { BarberPageModel } from "../models/page-barber-model";

@Injectable({
    providedIn: 'root'
})
export class sBarber {

    private baseUrl = `${environment.apiUrl}barbers/`;

    constructor(private http: HttpClient) {}

    getPage(id: number) {
        return this.http.get<BarberPageModel>(`${this.baseUrl}page/${id}`);
    }

    private barbersSubject = new BehaviorSubject<BarberModel[]>([]);
    barbers$ = this.barbersSubject.asObservable();

    get barbers(): BarberModel[] {
        return this.barbersSubject.value;
    }

    addBarber(barber: BarberModel): void {
        this.barbersSubject.next([...this.barbers, barber]);
    }

    removeBarber(index: number): void {
        const updated = this.barbers.filter((_, i) => i !== index);
        this.barbersSubject.next(updated);
    }

    clearBarber(): void {
        this.barbersSubject.next([]);
    }
}

