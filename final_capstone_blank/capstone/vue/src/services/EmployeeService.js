import axios from "axios";
// creating employee to the system
export default {
    createEmployee(employee){ 
    return axios.post('/employees', employee)
}, 
}