import axios from "axios";

export default {
    getAllRepairs(ServiceStatus){
    return axios.post('/serviceStatus', ServiceStatus)
},
}