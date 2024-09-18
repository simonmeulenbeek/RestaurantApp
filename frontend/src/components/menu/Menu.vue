<script lang="ts">
import { defineComponent } from 'vue'
import axiosInstance from '@/services/axios/axios'

import { useStorage } from '@vueuse/core'

import { tabletStore } from '@/services/tablets/TabletStore';
import type { Dish } from '@/types/dish'
import type { CurrentOrderItem } from '@/types/order_item'
import { createNewOrder } from '@/services/orders/OrderService'
import RunningOrdersWidget from './RunningOrdersWidget.vue';

export default defineComponent({
	expose: ['orderItems'],
	data() {
		return {
			dishes: [] as Dish[],
			currentOrder: useStorage('current-order', new Map() as Map<string, CurrentOrderItem>, sessionStorage),
			runningOrders: useStorage('running-orders', new Map() as Map<string, any>, sessionStorage),
			tabletStore
		}
	},
	methods: {
		orderItems: function () {			
			if (tabletStore.session) {
				createNewOrder(tabletStore.session?.id.toString(), Array.from(this.currentOrder.values()))
			}
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
		},
		onOrderClear: function() {
			console.log(this.$refs);
			this.$refs.menuItems.forEach(element => {
				(element as MenuItem).resetMenuItem();		
			});
		}
	},
	computed: {},
	watch: {},
	mounted() {
		this.currentOrder = new Map();
		axiosInstance.get('/dishes').then((response) => {
			this.dishes = response.data
		})
	},
})
</script>
<template>
	<div class="menu">
		<div class="menu__left-side">
			<RunningOrdersWidget v-show="this.runningOrders.size >= 1" />
		</div>
		<div class="menu__center">
			<h3 class="menu__title">Menu</h3>
            <MenuItem class="menu__menu-item" :dish="dish" @orderChange="onMenuItemChange" v-for="dish in dishes" :key="dish.id" ref="menuItems"/>
		</div>
		<div class="menu__right-side">
			<CurrentOrder :order="orderItems" @orderClear="onOrderClear"/>
		</div>
	</div>
</template>
