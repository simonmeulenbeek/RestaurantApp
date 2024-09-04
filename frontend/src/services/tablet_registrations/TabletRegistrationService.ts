import axiosInstance from '@/services/axios/axios'
import type { AxiosResponse } from 'axios'

export const getTabletRegistrationForTablet = (tabletId: string) => {
    return axiosInstance
        .get(`/tablet_registrations/tablet/${tabletId}`)
        .then((response) => {
            return response.data;
        })
}

export const getTabletRegistrationForTable = (tableId: string) => {
    return axiosInstance
        .get(`/tablet_registrations/table/${tableId}`)
        .then((response) => {
            return response.data;
        })
}

export const registerTabletToTable = (tabletId: string, tableId: string) => {
    return axiosInstance
        .post("/tablet_registrations/new", {
            tabletId: tabletId,
            tableId: tableId
        })
        .then((response) => {
            return response.data;
        })
}