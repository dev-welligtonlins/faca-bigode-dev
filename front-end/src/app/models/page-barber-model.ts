import { ServiceModel } from "./service.model";

export interface BarberPageModel {
    dashboard: {
        barbershopId: number,
        totalBarbers: number,
        totalValueDay: number,
        totalAppointmentsDay: number
    },
    barbers:   [{
      barbershopId: number,
      barberName: boolean,
      urlSocial: string,
      isHair: boolean,
      isBeard: boolean
    }]
}