<template>
  <div id="about">
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

    <div class="content">
      <h1>About Us</h1>
      <div class="paragraphs">
        <p>Welcome to Jeremy's Car Repair, your trusted automotive service provider. Established in 2023, we are proud to offer our expertise and exceptional services to car owners in need.</p>
        <p>At Jeremy's Car Repair, we specialize in catering to the needs of both conventional and electric vehicles. Our skilled technicians are well-versed in the latest automotive technologies, ensuring top-notch repairs and maintenance for all types of vehicles. With a focus on quality workmanship, we strive to exceed customer expectations and deliver reliable solutions.</p>
        <p>Trust Jeremy's Car Repair to keep your vehicle running smoothly and to provide the care it deserves.</p>
      </div>
    </div>
    <div class="menu" :class="{ open: isMenuOpen }">
      <router-link v-if="!isLoginPage" to="/">Home</router-link>
    <router-link to="/requestrepair">Request Repair</router-link>
      <router-link to="/service-status">Service Status</router-link>
      <router-link to="/contact">Contact</router-link>
      <a v-if="isLoggedIn" href="/logout">Logout</a>
    </div>

    <footer class="footer">
      <p class="footer-text">2023 Jeremy's Car Repair. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "about",
  data() {
    return {
      isMenuOpen: false,
      isLoggedIn: true
    };
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
  },
};
</script>

<style>
#about {
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
  padding-top: 30px;
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

 .content {
    max-width: 500px;
    width: 80%;
    margin: 180px auto;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    background-color: rgba(255, 255, 255, 0.8);
  }

  .paragraphs {
    margin-top: 20px;
  }

  .paragraphs p {
    margin-bottom: 15px;
    line-height: 1.5;
    text-align: justify;
    text-indent: 1.5em; 
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

.router-link {
  display: block;
  text-align: center;
  margin-top: 10px;
  color: #000;
  text-decoration: underline;
}
</style>