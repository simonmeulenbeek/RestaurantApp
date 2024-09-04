import type { Order } from "./order"
import type { TableData } from "./table_data"

export type CustomerSession = {
    id: string,
    tableData: TableData,
    orders: Order[],
    createdAt: Date,
    updatedAt: Date
}