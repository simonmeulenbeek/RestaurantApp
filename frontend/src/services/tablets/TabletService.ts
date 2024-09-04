
import axiosInstance from '@/services/axios/axios'
import type { AxiosResponse } from 'axios'

import { tabletStore } from './TabletStore'
import { getTabletRegistrationForTablet } from '../tablet_registrations/TabletRegistrationService'

export const initialize = async (tabletId: string) => {
    tabletStore.tabletId = tabletId;
    
    await getTablet(tabletStore.tabletId)
        .then((response: AxiosResponse["data"]) => {
            tabletStore.tablet = response;
        })

    await getTabletRegistrationForTablet(tabletStore.tabletId)
        .then((response: AxiosResponse["data"]) => {
            tabletStore.tablet = response.tablet;
            tabletStore.table = response.tableData;
            tabletStore.registration = response;
        })
    
    tabletStore.loaded = true;
}

export const getTablet = async (tabletId: string) => {
    return axiosInstance
        .get(`/tablets/${tabletId}`)
        .then((response: AxiosResponse) => {
            return response.data;
        })
}

export const registerNewTablet = async () => {
    return axiosInstance
        .post("/tablets/new", {
            tabletId: tabletStore.tabletId
        })
        .then((response) => {
            console.log(response)
            return response.data;            
        })
}