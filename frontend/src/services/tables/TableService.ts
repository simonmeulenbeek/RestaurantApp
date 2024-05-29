import axiosInstance from '@/services/axios/axios'

export const getAllTables = () => {
    console.log("get all tables!")
    return axiosInstance
        .get("/tables")
        .then((result) => {
            console.log(result)
            return result.data;
        })
        .catch((err) => {
            return err;
        })
}