import axiosInstance from '@/services/axios/axios'
import type { AxiosResponse } from 'axios'
import type { NewOrderItemDTO, Order } from '@/types/order'
import { NewOrderItemDTOFromCurrentOrderItem } from '@/types/order'
import type { CurrentOrderItem } from '@/types/order_item';

export const createNewOrder = async (customerSessionId: string, orderItems: CurrentOrderItem[]): Promise<Order> => {
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

export const GetCurrentOrdersForSession = async (sessionId: string): Promise<Order[]> => {
	return axiosInstance
		.get(`/orders/session/${sessionId}`)
		.then((response: AxiosResponse) => {
			return response.data
		})
}