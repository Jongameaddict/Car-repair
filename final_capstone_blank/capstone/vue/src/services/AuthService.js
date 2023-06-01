import axios from 'axios';

// function for customer, employee and admin login. Authentication specific to user type
// const authService = {
//   customerLogin(username,password) {
//     return axios.post('/api/customer/login', {username, password});
//   },
//   employeeLogin(username,password) {
//     return axios.post('/api/employee/login', {username,password});
//   },
//   adminLogin(username, password) {
//     return axios.post('/api/admin/login', {username,password});
//   },

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }

}
