import { BehaviorSubject, Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment.dev";
import { NewAccommodationModel } from "../models/new-accommodation-model";
import { NewScheduleModel } from "../models/new-schedule-model";

@Injectable({
    providedIn: 'root'
})
export class ServiceSchedule {

    private baseUrl = `${environment.apiUrl}barbershop_schedules/dto/`;

    constructor(private http: HttpClient) {}

    postSchedules(schedules: NewScheduleModel[]): Observable<NewScheduleModel[]> {
        return this.http.post<NewScheduleModel[]>(
            `${this.baseUrl}new-barbershop_schedule/`,
            schedules
        );
    }
}