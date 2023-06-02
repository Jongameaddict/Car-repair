import axios from "axios";

// creating admin to login to the system
export default {
    createAdmin(admin){ 
    return axios.post('/admins', admin)
}, 
getAdmin(admin) {
    return axios.get('/admins', admin)
}
}