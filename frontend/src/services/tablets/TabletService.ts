import axiosInstance from '@/services/axios/axios'

export const registerTabletToTable = (tabletId: string, tableId: string) => {
    return axiosInstance
        .post("/tablets/register", {
            tabletId: tabletId,
            tableId: tableId
        })
        .then((result) => {
            console.log(result)
            return result.data;
        })
        .catch((err) => {
            return err;
        })
}