import type { UUID } from "crypto"

export type Dish = {
    id: UUID,
    name: string,
    price: number
}