<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    
      <!-- gives option for customer to enter info to register -->
      <div class="form"> 
        <label for="fistName">First Name</label>
        <input type="text" v-model="newCustomer.firstName">
      </div>
        <div class="form"> 
        <label for="lastName">Last Name</label>
        <input type="text" v-model="newCustomer.firstName">
      </div>
        <div class="form"> 
        <label for="phoneNumber">Phone Number</label>
        <input type="text" v-model="newCustomer.phoneNumber">
      </div>
        <div class="form"> 
        <label for="emailAddress">Email Address</label>
        <input type="text" v-model="newCustomer.emailAddress">
      </div>
        <div class="form"> 
        <label for="address">Address</label>
        <input type="text" v-model="newCustomer.address">
      </div>
        <div class="form"> 
        <label for="city">City</label>
        <input type="text" v-model="newCustomer.city">
      </div>
        <div class="form"> 
        <label for="state">State</label>
        <input type="text" v-model="newCustomer.state">
      </div>
        <div class="form"> 
        <label for="zipCode">Zip Code</label>
        <input type="text" v-model="newCustomer.zipCode">
      </div>
      <!-- gives option for employee to enter info to register -->
      <div class="form"> 
        <label for="fistName">First Name</label>
        <input type="text" v-model="newEmployee.firstName">
      </div>
        <div class="form"> 
        <label for="lastName">Last Name</label>
        <input type="text" v-model="newEmployee.firstName">
      </div>
        <div class="form"> 
        <label for="phoneNumber">Phone Number</label>
        <input type="text" v-model="newEmployee.phoneNumber">
      </div>
        <div class="form"> 
        <label for="emailAddress">Email Address</label>
        <input type="text" v-model="newEmployee.emailAddress">
      </div>
        <div class="form"> 
        <label for="address">Address</label>
        <input type="text" v-model="newEmployee.address">
      </div>
        <div class="form"> 
        <label for="city">City</label>
        <input type="text" v-model="newEmployee.city">
      </div>
        <div class="form"> 
        <label for="state">State</label>
        <input type="text" v-model="newEmployee.state">
      </div>
        <div class="form"> 
        <label for="zipCode">Zip Code</label>
        <input type="text" v-model="newEmployee.zipCode">
      </div>
        <!-- gives option for ADMIN to enter info to register -->
          <div class="form"> 
        <label for="fistName">First Name</label>
        <input type="text" v-model="newAdmin.firstName">
      </div>
        <div class="form"> 
        <label for="lastName">Last Name</label>
        <input type="text" v-model="newAdmin.firstName">
      </div>
       <!-- to add new customer checkbox option -->
      <div class="form"> 
        <label for="viewCustomer">New Customer</label>
        <input type="checkbox" v-model="viewCustomer" @change="toggleCheckbox('customer')">
      </div>
      <div class="form"> 
        <label for="viewEmployee">New Employee</label>
        <input type="checkbox" v-model="viewEmployee" @change="toggleCheckbox('employee')">
      </div>
          <div class="form"> 
        <label for="viewAdmin">New Admin</label>
        <input type="checkbox" v-model="viewAdmin" @change="toggleCheckbox('admin')">
      </div>
      <form class="customerForm" v-if="viewCustomer"></form>
       <form class="employeeForm" v-if="viewEmployee"></form>
        <form class="adminForm" v-if="viewAdmin"></form>

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>

// import CustomerService from '../services/CustomerService'
// import EmployeeService from '../services/EmployeeService'
// import AdminService from '../services/AdminService'
import AuthService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      // only allows one of these to be true to appear
      viewCustomer: false, 
      viewEmployee: false,
      viewAdmin: false,
      newEmployee:{
        
      },
      newAdmin:{

      },
      newCustomer:{

      },
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    toggleCheckbox(role){
      if(role === 'employee') {
        this.newCustomer = false;
      } if (role === 'customer') {
        this.newEmployee = false;
      } else if (role === 'admin') {
        this.newCustomer = false;

      }
      AuthService.register(this.newCustomer),
      AuthService.register(this.newEmployee),
      AuthService.register(this.newAdmin)
    },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        AuthService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
#register {
  /*Background image for the register componenet */
  background-size: cover;
  background-position: center;
  background-image: url('https://ak5.picdn.net/shutterstock/videos/18444895/thumb/11.jpg');
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}
  /*registration form heading */
.form-register h1 {
  margin-bottom: 20px;
}
  /*registration form itself */
.form-register{
    margin: 0 auto;
  max-width: 400px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0,0,0, 0.1);
  background-color: rgba(255, 255, 255, 0.8);
}
  /*registration form submit button */
.form-register .btn {
  display: block;
  width: 100%;
  font-size: 16px;
  margin-top: 20px;
    padding: 10px;
}
  /*text input fields */
.form-register input[type="text"],
.form-register input[type="password"] {
    width: 95%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 10px;
}
  /*registration form error alert messages */
.form-register .alert {
  margin-bottom: 10px;
}
  /*router link */
.form-register a.router-link {
  display: block;
  text-decoration: none;
  color: #777;
    margin-top: 10px
}
;</style>
