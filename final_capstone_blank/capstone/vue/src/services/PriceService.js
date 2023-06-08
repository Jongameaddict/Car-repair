import axios from "axios";
export default {
    getPrice(repairId){
        return axios.get(`/price/${repairId}`)
    },
    
    getAllPrices() {
        return axios.get('/allPrices')
    }
    
}