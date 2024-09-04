import axiosInstance from '@/services/axios/axios'
import type { AxiosResponse } from 'axios'

export const createNewSession = async (tabletId: string, tableId: string) => {
    return axiosInstance
        .post("/sessions/new", {
            tabletId: tabletId,
            tableId: tableId
        })
        .then((response: AxiosResponse) => {
            return response.data
        })
};

export const GetSessionForTable = async (tableId: string) => {
    return axiosInstance
        .get(`/sessions/table/${tableId}`)
        .then((response: AxiosResponse) => {
            console.log(response);
            return response.data
        })
}