<template>
  <div id="register">
    <div class="header">
      <router-link to="/">
        <img
          class="logo"
          src="../components/Jeremy's Car Repair.png"
          alt="Logo"
        />
      </router-link>
      <div class="menu" :class="{ open: isMenuOpen }">
        <router-link to="/">Home</router-link>
        <a href="#">Create a Request</a>
        <a href="#">Request Status</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
      </div>
    </div>

    <div class="form-register">
      <h1>Register</h1>

      <div class="row">
        <div class="form-group">
          <label for="firstName">First Name:</label>
          <input type="text" id="firstName" v-model="user.firstName" />
        </div>

        <div class="form-group">
          <label for="lastName">Last Name:</label>
          <input type="text" id="lastName" v-model="user.lastName" />
        </div>
      </div>

      <div class="row">
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" id="username" v-model="user.username" />
        </div>

        <div class="form-group">
          <label for="email">Email Address:</label>
          <input type="email" id="email" v-model="user.email" />
        </div>
      </div>

      <div class="row">
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="user.password" />
        </div>

        <div class="form-group">
          <label for="confirmPassword">Confirm Password:</label>
          <input
            type="password"
            id="confirmPassword"
            v-model="user.confirmPassword"
          />
        </div>
      </div>

      <div class="row">
        <div class="form-group">
          <label for="phoneNumber">Phone Number:</label>
          <input type="tel" id="phoneNumber" v-model="user.phoneNumber" />
        </div>

        <div class="form-group">
          <label for="role">Role:</label>
          <select id="role" v-model="user.role">
            <option value="customer">Customer</option>
            <option value="employee">Employee</option>
            <option value="admin">Admin</option>
          </select>
        </div>
      </div>

      <button class="btn" @click="register">Register</button>

      <div v-if="registrationErrors" class="alert">
        {{ registrationErrorMsg }}
      </div>
<<<<<<< HEAD

      <a class="router-link" href="/login"
        >Already have an account? Login here.</a
      >
    </div>

    <button class="hamburger" @click="toggleMenu">
      <span class="line"></span>
      <span class="line"></span>
      <span class="line"></span>
    </button>

    <footer class="footer">
      <p class="footer-text">All Rights Reserved @ Tech Elevator 2023</p>
    </footer>
=======
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
>>>>>>> main
  </div>
</template>

<script>
<<<<<<< HEAD
import authService from "../services/AuthService";
import router from "../router";
=======

// import CustomerService from '../services/CustomerService'
// import EmployeeService from '../services/EmployeeService'
// import AdminService from '../services/AdminService'
import AuthService from '../services/AuthService';
>>>>>>> main

export default {
  name: "register",
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
        firstName: "",
        lastName: "",
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
        phoneNumber: "",
        role: "customer",
      },
      registrationErrors: false,
      registrationErrorMsg: "",
      isMenuOpen: false,
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
<<<<<<< HEAD
      authService
        .register(this.user)
        .then(() => {
          router.push("/login");
        })
        .catch((error) => {
          this.registrationErrors = true;
          this.registrationErrorMsg = error.response.data.message;
        });
=======
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
>>>>>>> main
    },
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
  },
};
</script>

<style>
#register {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-size: cover;
  background-position: center;
  background-image: url("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/e2111426-4597-4519-b144-4851724f4403/d2uxtyn-23974429-2335-454b-a0e9-250fafb69057.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwic3ViIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsImF1ZCI6WyJ1cm46c2VydmljZTpmaWxlLmRvd25sb2FkIl0sIm9iaiI6W1t7InBhdGgiOiIvZi9lMjExMTQyNi00NTk3LTQ1MTktYjE0NC00ODUxNzI0ZjQ0MDMvZDJ1eHR5bi0yMzk3NDQyOS0yMzM1LTQ1NGItYTBlOS0yNTBmYWZiNjkwNTcuanBnIn1dXX0.XCfnELCE9DOlszOrK8KzbJw9D1nndzp_NiLu2jcSCq8");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center top;
  padding-top: 90px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 5px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: rgba(255, 255, 255, 1);
  z-index: 9999;
}

.form-register {
  max-width: 500px;
  width: 80%;
  margin: 80px auto;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: rgba(255, 255, 255, 0.8);
}

.form-register h1 {
  margin-bottom: 20px;
  text-align: center;
}

.form-register .form-group {
  margin-bottom: 20px;
}

.form-register label {
  display: block;
  margin-bottom: 5px;
}

.form-register input[type="text"],
.form-register input[type="email"],
.form-register input[type="password"],
.form-register input[type="tel"],
.form-register select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  box-sizing: border-box;
}

.form-register .btn {
  display: block;
  width: 100%;
  font-size: 16px;
  margin-top: 20px;
  padding: 10px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

.form-register .btn:hover {
  background-color: #45a049;
}

.form-register .alert {
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 3px;
  background-color: #f44336;
  color: #fff;
}

.footer {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 15px;
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
}

.hamburger {
  position: fixed;
  top: 30px;
  right: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 40px;
  height: 30px;
  cursor: pointer;
  z-index: 9999;
  background-color: transparent;
  border: none;
  padding: 0;
}

.hamburger .line {
  width: 100%;
  height: 4px;
  background-color: #333;
  transition: all 0.3s ease;
}

.hamburger.open .line:nth-child(1) {
  transform: translateY(8px) rotate(45deg);
}

.hamburger.open .line:nth-child(2) {
  opacity: 0;
}

.hamburger.open .line:nth-child(3) {
  transform: translateY(-8px) rotate(-45deg);
}

.menu {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  background-color: #fff;
  width: 200px;
  transform: translateX(200px);
  transition: transform 0.3s ease;
  z-index: 9998;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 130px;
}

.menu.open {
  transform: translateX(0);
}

.menu a {
  margin-bottom: 20px;
  color: #000;
  text-decoration: none;
  font-size: 16px;
}

.router-link {
  display: block;
  text-align: center;
  margin-top: 10px;
  color: #000;
  text-decoration: underline;
}
.row {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 20px;
}

.row .form-group {
  flex-basis: calc(50% - 10px);
}
</style>
