<template>
    <div>
        <input type="text" v-model="id">
<button @click="search">Search</button>
                                                            
    </div>
</template>


<script>
// import serviceStatus from "../services/ServiceStatus.vue";

export default {
  data() {
    return {
      requests: [],
      id: ''
    };
  },
  created() {

  },
  methods: {
      search() {
          this.$router.push('/service-status/'+ this.id)
      }
  }
};
</script>