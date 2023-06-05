<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
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
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
#login {
  /* Backgroung image for the sign in componenet  */
  background-size: cover;
  background-position: top;
   background-image: url('https://ak5.picdn.net/shutterstock/videos/18444895/thumb/11.jpg');
   height: 100vh;
   display: flex;
  align-items: center;
  justify-content: center;

}
/* login form heading */
.form-signin h1 {
  text-align: center;
  margin-bottom: 20px;
}
/* login form itself */
.form-signin{
  margin: 0 auto;
  max-width: 400px;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: rgba(255, 255, 255, 0.8);
}
/* login form submit button */
.form-signin .btn  {
  display: block;
  width: 100%;
  font-size: 16px;
  margin-top: 20px;
  padding: 10px;
  cursor: pointer;
}
/* text input fields */
.form-signin input[type="text"],
.form-signin input[type="password"]{
  width: 95%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
/* sumbit button */
.form-signin input[type="submit"]:hover{
  background-color: royalblue;
}
/* error login form message */
.form-signin.error {
  color: red;
  margin-bottom: 10px;
  text-align: center;
}
/* router link */
.form-signin router-link {
  display: block;
  text-decoration: none;
  color: blueviolet;
  margin-top: 10px;
}
/* success login message */
.form-signin .success-message {
  color: green;
  margin-bottom: 10px;
  text-align: center;
}

</style>