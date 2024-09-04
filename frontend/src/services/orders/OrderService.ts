import axiosInstance from '@/services/axios/axios'
import type { AxiosResponse } from 'axios'
import type { NewOrderItemDTO } from '@/types/order'
import { NewOrderItemDTOFromCurrentOrderItem } from '@/types/order'
import type { CurrentOrderItem } from '@/types/order_item';

export const createNewOrder = async (customerSessionId: string, orderItems: CurrentOrderItem[]) => {
    let orderItemDTOs: NewOrderItemDTO[] = [];
    orderItems.forEach((element) => {
        orderItemDTOs.push(NewOrderItemDTOFromCurrentOrderItem(element))
    });

    return axiosInstance
        .post("/orders/new", {
            sessionId: customerSessionId,
            orderItems: orderItemDTOs
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