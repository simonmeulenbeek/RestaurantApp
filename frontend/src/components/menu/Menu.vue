<script lang="ts">
import { defineComponent } from 'vue'
import axiosInstance from '@/services/axios/axios'

import { useStorage } from '@vueuse/core'

import type { Dish } from '@/types/dish'
import type { CurrentOrderItem } from '@/types/order_item'

export default defineComponent({
	data() {
		return {
			dishes: [] as Dish[],
			currentOrder: useStorage('current-order', new Map() as Map<string, CurrentOrderItem>, sessionStorage),
		}
	},
	methods: {
		orderItems: function () {
			let dishItem = this.dishes[(Math.floor(Math.random() * this.dishes.length))];
			console.log(dishItem);
			
			axiosInstance.post('/orders', {
				dishId: dishItem.id,
				amount: 3,
				pricePerUnit: dishItem.price
			})
		},
		onMenuItemChange: function(dish: Dish, amount: number) {
			if (amount <= 0) {
				this.currentOrder.delete(dish.id)
			} else {
				if(this.currentOrder.has(dish.id)) {
					let orderItem = this.currentOrder.get(dish.id)!
					orderItem.amount = amount
					this.currentOrder.set(dish.id, orderItem)
				} else {
					this.currentOrder.set(dish.id, {
						dishId: dish.id,
						dishName: dish.name,
						amount: amount,
						pricePerUnit: dish.price
					})
				}
			}
		}
	},
	computed: {},
	watch: {},
	mounted() {
		axiosInstance.get('/dishes').then((response) => {
			this.dishes = response.data
		})
	},
})
</script>
<template>
	<div class="menu">
		<div class="menu__left-side"></div>
		<div class="menu__center">
			<h3 class="menu__title">Menu</h3>
			<ol>
				<li v-for="dish in dishes" :key="dish.id">
					<MenuItem class="menu__menu-item" :dish="dish" @orderChange="onMenuItemChange" />
				</li>
			</ol>
		</div>
		<div class="menu__right-side">
			<CurrentOrder/>
			<button class="menu__order_button" @click="orderItems">Order</button>
		</div>
	</div>
</template>
