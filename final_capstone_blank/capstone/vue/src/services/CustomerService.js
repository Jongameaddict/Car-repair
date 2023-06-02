import axios from "axios";
// creating customer to the system
export default {
    createCustomer(customer){ 
    return axios.post('/customers', customer)
}, 
}