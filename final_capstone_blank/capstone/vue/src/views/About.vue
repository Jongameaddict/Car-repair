<template>
  <div id="about" class="register">
    <div class="header">
      <img src="/path/to/logo.png" alt="Logo" class="logo">
      <nav class="menu">
        <router-link to="/">Home</router-link>
        <router-link to="/register">Register</router-link>
        <router-link to="/about">About</router-link>
      </nav>
    </div>

    <div class="about-content">
      <h1>About Us</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut fringilla risus. Suspendisse convallis orci sit amet dictum aliquam. Vestibulum eleifend, mi id vestibulum efficitur, lectus enim vestibulum ex, ac lacinia dui dolor a elit. Curabitur sed dapibus nisl. Integer nec odio sed lorem gravida dapibus. Phasellus id consectetur purus.</p>
      <p>Sed et risus vitae metus pulvinar efficitur nec vitae erat. Curabitur convallis, mauris vel vestibulum bibendum, mi risus condimentum ipsum, sit amet dapibus felis neque ac mi. Proin vestibulum ullamcorper libero, sit amet hendrerit tellus vestibulum vitae. Sed non eros vestibulum, faucibus nulla in, hendrerit velit. Integer nec lacus et nulla pellentesque placerat sed a felis. Nunc tempus, justo vitae facilisis placerat, nulla elit tincidunt arcu, at finibus mauris tellus in tortor. Praesent sit amet faucibus tortor. Donec ac tellus in risus pellentesque dapibus non ac lectus. Sed feugiat tristique mauris, ac vestibulum ante efficitur sed. Fusce id dignissim urna.</p>
    </div>

    <footer class="footer">
      <p>&copy; 2023 Your Company. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
  name: 'About',
  components: {
    RouterLink,
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

.about-content {
  background-color: #fff;
  padding: 40px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  max-width: 800px;
  width: 100%;
}

.about-content h1 {
  margin-bottom: 20px;
}

.footer {
  background-color: #333;
  padding: 20px;
  color: #fff;
  text-align: center;
  margin-top: 20px;
}
</style>
