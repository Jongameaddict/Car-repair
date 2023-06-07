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
        <a href="#">Request Repair</a>
        <a href="#">Service Status</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
      </div>
    </div>
    <div class="form-register">
      <h1>Create a Repair Request</h1>
      <div class="row">
        <div class="form-group">
          <label for="make">Car Make:</label>
          <input type="text" id="make" v-model="car.make" />
        </div>
        <div class="form-group">
          <label for="model">Model:</label>
          <input type="text" id="model" v-model="car.model" />
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label for="year">Year:</label>
          <input type="text" id="year" v-model="car.year" />
        </div>
        <div class="form-group">
          <label for="color">Color:</label>
          <input type="email" id="color" v-model="car.color" />
        </div>
      </div>
      <div>
        <div class="form-group">
          <label for="description">Description of Problem(s):</label>
          <input type="password" id="description" v-model="car.description" />
        </div>
      </div>
      <button class="btn" @click="register">Submit</button>
      <div v-if="registrationErrors" class="alert">
        {{ registrationErrorMsg }}
      </div>
    </div>
    <button class="hamburger" @click="toggleMenu">
      <span class="line"></span>
      <span class="line"></span>
      <span class="line"></span>
    </button>
    <footer class="footer">
      <p class="footer-text">All Rights Reserved @ Tech Elevator 2023</p>
    </footer>
  </div>
</template>
<script>
import authService from "../services/AuthService";
import router from "../router";
export default {
  name: "request-repair",
  data() {
    return {
      car: {
        make: "",
        model: "",
        year: "",
        color: "",
        description: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "",
      isMenuOpen: false,
    };
  },
  methods: {
    register() {
      authService
        .register(this.user)
        .then(() => {
          router.push("/login");
        })
        .catch((error) => {
          this.registrationErrors = true;
          this.registrationErrorMsg = error.response.data.message;
        });
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
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
.form-register .btn:hover {
  background-color: #45A049;
}
.form-register .alert {
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 3px;
  background-color: #F44336;
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