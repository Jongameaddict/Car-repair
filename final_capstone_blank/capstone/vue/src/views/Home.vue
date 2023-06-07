<template>
  <div id="home">
    <div class="header">
      <router-link to="/">
        <img class="logo" src="../components/Jeremy's Car Repair.png" alt="Logo" />
      </router-link>
      <button class="hamburger" :class="{ open: isMenuOpen }" @click="toggleMenu">
        <span class="line"></span>
        <span class="line"></span>
        <span class="line"></span>
      </button>
    <div class="menu" :class="{ open: isMenuOpen }">
      <router-link to="/request-repair">Request Repair</router-link>
      <router-link to="/service-status">Service Status</router-link>
      <router-link to="/about">About</router-link>
      <router-link to="/contact">Contact</router-link>
      <a v-if="isLoggedIn" href="/logout">Logout</a>
    </div>
    </div>

    <div class="content">
      <h1>Welcome to Jeremy's Car Repair</h1>
      <p>We provide quality car repair services for all makes and models.</p>
<button class="cta-button" @click="$router.push('/request-repair')">Book Appointment</button>
    </div>

    <footer class="footer">
      <p class="footer-text">© 2023 Jeremy's Car Repair. All rights reserved.</p>
    </footer>
  </div>
</template>
<!--calling RequestRepair to display request and provide option to choose complete -->
<script>
export default {
  name: "home",
  data() {
    return {
      isMenuOpen: false,
      isLoggedIn: true 
    };
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    }
  }
};
</script>

<style>
#home {
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
  padding-top: 90px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: rgba(255, 255, 255, 0.9);
  z-index: 9999;
}

.logo {
  max-height: 50px;
}

.hamburger {
  position: relative;
  top: 50%;
  transform: translateY(-50%);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 40px;
  height: 30px;
  cursor: pointer;
  background-color: transparent;
  border: none;
  padding: 0;
  z-index: 9999;
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

.content {
  max-width: 500px;
  width: 80%;
  margin: 200px auto 100px;
  padding: 20px;
  border-radius: 5px;
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.content h1 {
  font-size: 28px;
  margin-bottom: 20px;
}

.content p {
  font-size: 16px;
  margin-bottom: 30px;
}

.cta-button {
  padding: 10px 20px;
  font-size: 18px;
  color: #fff;
  background-color: #333;
  border: none;
  border-radius: 5px;
  cursor: pointer;
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
</style>
