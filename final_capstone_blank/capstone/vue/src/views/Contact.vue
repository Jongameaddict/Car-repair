<template>
  <div id="contact" class="register">
    <div class="header">
      <img src="/path/to/logo.png" alt="Logo" class="logo">
      <nav class="menu">
        <router-link to="/">Home</router-link>
        <router-link to="/register">Register</router-link>
        <router-link to="/contact">Contact</router-link>
      </nav>
    </div>

    <div class="form-register">
      <h1>Contact Us</h1>
      <div class="contact-info">
        <div class="contact-item">
          <i class="fas fa-map-marker-alt"></i>
          <p>123 Main Street, City, Country</p>
        </div>
        <div class="contact-item">
          <i class="fas fa-phone"></i>
          <p>+1 123-456-7890</p>
        </div>
        <div class="contact-item">
          <i class="fas fa-envelope"></i>
          <p>info@example.com</p>
        </div>
      </div>
      <form class="contact-form">
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" id="name" v-model="name" required>
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" v-model="email" required>
        </div>
        <div class="form-group">
          <label for="message">Message</label>
          <textarea id="message" v-model="message" required></textarea>
        </div>
        <button class="btn" @click="submitForm">Submit</button>
      </form>
    </div>

    <footer class="footer">
      <p>&copy; 2023 Your Company. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
  name: 'Contact',
  components: {
    RouterLink,
  },
  data() {
    return {
      name: '',
      email: '',
      message: '',
    };
  },
  methods: {
    submitForm() {
      // Perform form submission logic
      // use this.name, this.email, and this.message to access the form data
      // Example: Send an email using an API or store the form data in a database
      console.log('Form submitted');
      // Reset form fields after submission
      this.name = '';
      this.email = '';
      this.message = '';
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap");

body {
  font-family: "Roboto", sans-serif;
  margin: 0;
  padding: 0;
}

.register {
  background-color: #f0f0f0;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.header {
  background-color: #333;
  padding: 20px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.logo {
  width: 100px;
  height: auto;
}

.menu {
  display: flex;
}

.menu router-link {
  color: #fff;
  text-decoration: none;
  margin-right: 20px;
}

.form-register {
  background-color: #fff;
  padding: 40px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  max-width: 500px;
  width: 100%;
}

.form-register h1 {
  margin-bottom: 20px;
}

.contact-info {
  display: flex;
  justify-content: center;
  margin-bottom: 40px;
}

.contact-item {
  margin-right: 20px;
  display: flex;
  align-items: center;
}

.contact-item i {
  margin-right: 10px;
}

.contact-form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-group {
  margin-bottom: 20px;
  width: 100%;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  box-sizing: border-box;
}

button.btn {
  font-size: 16px;
  padding: 10px 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

button.btn:hover {
  background-color: #45a049;
}

.footer {
  background-color: #333;
  padding: 20px;
  color: #fff;
  text-align: center;
  margin-top: 20px;
}
</style>
