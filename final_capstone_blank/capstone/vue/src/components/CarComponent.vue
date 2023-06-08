<template>
  <div>

  </div>
</template>

<script>
import repairService from '../services/RepairService';
export default {
    name: 'car-component',
    data(){
        return{
            cars:[]
        }
    },
    created(){
        repairService.getAllRepairs().then
    }
}
</script>

<style>

</style>