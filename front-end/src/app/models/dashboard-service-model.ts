import { ServiceModel } from "./service.model";

export interface DashboardServiceModel {
    servicesDTO: ServiceModel[],
    total: number,
    averageValueServices: number,
    averageTimeServices: number,
}