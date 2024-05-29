import type { UUID } from "crypto"
import type { Dish } from "./dish"

export type OrderItem = {
    id?: UUID,
    dishId: UUID,
    amount: number,
    pricePerUnit: number
}

export type CurrentOrderItem = {
    id?: UUID,
    dishId: UUID,
    dishName: string,
    amount: number,
    pricePerUnit: number
}

export function createCurrentOrderItem(dish: Dish, amount: number): CurrentOrderItem {
    return {
        dishId: dish.id,
        dishName: dish.name,
        amount: amount,
        pricePerUnit: dish.price
    }
}