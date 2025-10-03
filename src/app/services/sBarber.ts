import { BehaviorSubject } from "rxjs";
import { BarberModel } from "../models/barber-model";
import { Injectable } from "@angular/core";
import { HttpResponse } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class sBarber {
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

