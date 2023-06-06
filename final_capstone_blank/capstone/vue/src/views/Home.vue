<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <RequestRepair/>
  </div>
</template>
<!--calling RequestRepair to display request and provide option to choose complete -->
<script>
import RequestRepair from './RequestRepair.vue';
export default {
  components: { RequestRepair },
  name: "home"
};
</script>
