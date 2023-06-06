<template>
  <div>
    <!-- display repair requests and allow marked as completed -->
    <h2>Repair Requests</h2>
    <ul>
      <li v-for="request in requests" :key="request.id">
        <div>{{ request.title }}</div>
        <div>Status: {{ request.status}}</div>
        <button v-if="request.status !== 'completed'" @click="markCompleted(request.id)">Mark Completed</button>
      </li>
    </ul>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
export default {
  computed: {
    ...mapState(['requests']),
  },
  methods: {
    ...mapMutations(['markRequestCompleted']),
    markCompleted(requestId) {
      this.markRequestCompleted(requestId);
    }
  }
};
</script>

<style>
</style>