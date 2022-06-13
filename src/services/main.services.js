import axios from "axios";

const API_URL = 'http://localhost:8080/carrefour/cep'

export const fetchProdutos = async (payload) => {

    var axiosCreate = axios.create(
        {
            validateStatus: function (status) {
                return status >= 200;
            }
        }
    )
    
    var config = {
        method: 'post',
        url: API_URL,
        headers: {
            'Content-Type': 'application/json'
        },
        data: payload
    };

    try{
        let data = await axiosCreate(config).then(({data}) => data)
        return data
    }
    catch (err) {
        console.log("erro", err)
        return false
    }
}