<template>
	<div>
		<div v-for="price in prices" v-bind:key="price.repairId">
            <div>${{price.price}}</div>
            <div>{{price.repairId}}</div>
            <div>{{price.repairType}}</div>
            <label for="chooseService"></label>
            <input name="chooseService" type="button" placeholder="Choose a service" />
            
        </div>
	</div>
</template>

<script>
import priceService from "../services/PriceService.js";

export default {
	data() {
		return {
			prices: [],
		};
	},

	created() {
		priceService.getAllPrices().then((response) => {
			if (response.status == 200) {
				this.prices = response.data;
			}
		});
	},
};
</script>

<style>
</style>