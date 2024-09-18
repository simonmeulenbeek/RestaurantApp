import type { UUID } from "crypto"
import type { CurrentOrderItem, OrderItem } from "./order_item"
import type { CustomerSession } from "./customer_session"

export type Order = {
    id: UUID,
    session: CustomerSession,
    orderItems: OrderItem[],
    createdAt: Date,
    updatedAt: Date
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
