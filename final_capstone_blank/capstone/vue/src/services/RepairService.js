import axios from "axios";

export default {
    getAllRepairs(id){
    return axios.get('/requests/' + id)
},
updateRepairStatus(repair, id) {
    console.log('request?')
return axios.put('/update-repair/' + id, repair)
}
}