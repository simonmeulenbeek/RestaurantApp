import type { UUID } from "crypto"
import type { CurrentOrderItem } from "./order_item"

export type Order = {
    id: UUID,
    // TODO: orderId: number,
    dishId: UUID,
    amount: number,
    pricePerUnit: number
}

export type NewOrderDTO = {
    sessionId: UUID,
    orderItems: NewOrderItemDTO[]
}

export type NewOrderItemDTO = {
    dishId: UUID,
    pricePerUnit: number,
    amount: number
}

export const NewOrderItemDTOFromCurrentOrderItem = (item: CurrentOrderItem): NewOrderItemDTO => {
    return {
        dishId: item.dishId,
        pricePerUnit: item.pricePerUnit,
        amount: item.amount
    };
};
