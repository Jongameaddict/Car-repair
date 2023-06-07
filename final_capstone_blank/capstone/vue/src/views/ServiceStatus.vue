<template>
    <div>
        <h2>Service Status</h2>
        <ul>
            <li v-for="request in requests" :key="request.id">
                <div>{{ request.title }}</div>
                <div>Status: {{ request.status }}</div>
                <button v-if="request.status !== 'completed'" @click="markCompleted(request.id)">Mark Completed</button>
            </li>
        </ul>
    </div>
</template>

<script>