<template>
  <div id="contact">
    <div class="header">
      <router-link to="/">
        <img class="logo" src="../components/Jeremy's Car Repair.png" alt="Logo" />
      </router-link>
      <button class="hamburger" :class="{ open: isMenuOpen }" @click="toggleMenu">
        <span class="line"></span>
        <span class="line"></span>
        <span class="line"></span>
      </button>
    </div>
    <div class="menu" :class="{ open: isMenuOpen }">
      <router-link v-if="!isLoginPage" to="/">Home</router-link>
      <router-link to="/request-service">Request Repair</router-link>
      <router-link to="/request-status">Service Status</router-link>
      <router-link to="/about">About</router-link>
      <a v-if="isLoggedIn" href="/logout">Logout</a>
    </div>

    <div class="form-contact">
      <h1 class="h3 mb-3 font-weight-normal">Contact Us</h1> 
      <form @submit.prevent="submitForm" class="form-signin">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" id="name" v-model="form.name" required />
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" v-model="form.email" required />
        </div>
        <div class="form-group">
          <label for="message">Message:</label>
          <textarea id="message" v-model="form.message" required></textarea>
        </div>
        <button type="submit" class="btn">Submit</button>
      </form>
    </div>

    <footer class="footer">
      <p class="footer-text">2023 Jeremy's Car Repair. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "contact",
  components: {},
  data() {
    return {
      isLoggedIn: true,
      isMenuOpen: false,
      isLoginPage: false,
      form: {
        name: "",
        email: "",
        message: "",
      },
    };
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
    submitForm() {
      //TODO: We Need to Handle form submission logic here
      console.log(this.form);
      //TODO: We Need to Reset the form after submission
      this.form = {
        name: "",
        email: "",
        message: "",
      };
    },
  },
};
</script>

<style>
#contact {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-size: cover;
  background-position: center;
  background-image: url('https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/e2111426-4597-4519-b144-4851724f4403/d2uxtyn-23974429-2335-454b-a0e9-250fafb69057.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwic3ViIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsImF1ZCI6WyJ1cm46c2VydmljZTpmaWxlLmRvd25sb2FkIl0sIm9iaiI6W1t7InBhdGgiOiIvZi9lMjExMTQyNi00NTk3LTQ1MTktYjE0NC00ODUxNzI0ZjQ0MDMvZDJ1eHR5bi0yMzk3NDQyOS0yMzM1LTQ1NGItYTBlOS0yNTBmYWZiNjkwNTcuanBnIn1dXX0.XCfnELCE9DOlszOrK8KzbJw9D1nndzp_NiLu2jcSCq8');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center top;
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
  z-index: 2;
}
.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 100px; 
  z-index: 1; 
}
.form-signin {
  max-width: 500px;
  width: 80%;
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
.form-signin input[type="email"],
.form-signin textarea {
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
.footer {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 15px;
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
}
.footer-text {
  font-size: 14px;
  color: black;
  margin: 0;
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
    width: 250px;
    transform: translateX(250px);
    visibility: hidden;
    opacity: 0;
    pointer-events: none;
    transition: transform 0.3s ease, visibility 0s linear 0.3s, opacity 0.3s;
    z-index: 9998;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 130px;
  }

  .menu.open {
    transform: translateX(0);
    visibility: visible;
    opacity: 1;
    pointer-events: auto;
    transition: transform 0.3s ease, visibility 0s linear, opacity 0.3s;
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
