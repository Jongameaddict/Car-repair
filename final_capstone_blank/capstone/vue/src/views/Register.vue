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
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
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
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
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
