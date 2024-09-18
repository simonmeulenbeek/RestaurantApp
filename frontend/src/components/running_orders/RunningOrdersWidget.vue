<script lang="ts">
import { defineComponent } from 'vue'
import type { AxiosResponse } from 'axios'
import { useStorage } from '@vueuse/core'

import { tabletStore } from '@/services/tablets/TabletStore';
import { GetCurrentOrdersForSession } from '@/services/orders/OrderService';
import type { Order } from '@/types/order';

export default defineComponent({
	components: {},
	data() { return {
		tabletStore,
		runningOrders: useStorage('running-orders', new Map() as Map<string, any>, sessionStorage),
	}},
	methods: {},
	computed: {},
	watch: {},
	mounted() {
		if (tabletStore.session?.id) {
			GetCurrentOrdersForSession(tabletStore.session.id)
			.then((response: Order[]) => {
				this.runningOrders.clear()
				response.forEach((item) => {
					this.runningOrders.set(item.id, item);
				})
			})
		}
	},
})
</script>
<template>
	<div class="running_orders" >
		<h3>Lopende Orders</h3>
		<div class="running_orders__items" :if="runningOrders.size >= 1">
			<RunningOrderItem v-for="[_, orderItem] in runningOrders" :key="orderItem.id" :order="orderItem" />
		</div>
	</div>
</template>