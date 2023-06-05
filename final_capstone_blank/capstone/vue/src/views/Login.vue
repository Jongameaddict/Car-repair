<template>
  <div id="login">
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

    <div class="form-login">
    
      

      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
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
        <router-link :to="{ name: 'login' }">Need an account?</router-link>
        <router-link to="/">
        </router-link>

        <div class="menu" :class="{ open: isMenuOpen }">
          <router-link to="/">Home</router-link>
          <a href="#">Create a Request</a>
          <a href="#">Request Status</a>
          <a href="#">About</a>
          <a href="#">Contact</a>
        </div>
        <button type="submit">Sign in</button>
      </form>
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

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }, 
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
  },
};
</script>


<style>
#login {
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
.form-signin {
  max-width: 500px;
  width: 80%;
  margin: 80px auto;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: rgba(255, 255, 255, 0.8);
}
.form-signin h1 {
  margin-bottom: 20px;
  text-align: center;
}
.form-signin .form-group {
  margin-bottom: 20px;
}
.form-signin label {
  display: block;
  margin-bottom: 5px;
}
.form-signin input[type="text"],
.form-signin input[type="password"] {
  width: 95%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
.form-signin .btn {
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
.form-signin .btn:hover {
  background-color: #45a049;
}
/* sumbit button */
.form-signin input[type="submit"]:hover {
  background-color: royalblue;
}
.form-signin .alert {
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
</style>

