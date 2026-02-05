import { ServiceModel } from "./service.model";

export interface ServicePageModel {
    dashboard: {
        barbershopId: number,
        totalServices: number,
        avgValue: number,
        avgDuration: number,
        serviceMostPopular: string 
    },
    services:   [{
      barbershopId: number,
      serviceDescription: string,
      value: number,
      duration: number,
      serviceCategory: string
    }]
}