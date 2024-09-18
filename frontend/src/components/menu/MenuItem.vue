<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType } from 'vue'

import { useStorage } from '@vueuse/core';

import type { Dish } from '@/types/dish'
import type { CurrentOrderItem } from '@/types/order_item';
import { createCurrentOrderItem } from '@/types/order_item';

export default defineComponent({
	emits: ['orderChange'],
	expose: ['resetMenuItem'],
	props: {
		dish: {
			type: Object as PropType<Dish>,
			required: true
		}
	},
	data() {
		return {
			selected: false,
			selectedAmount: 0,
			currentOrder: useStorage('current-order', new Map() as Map<String, CurrentOrderItem>, sessionStorage)
		}
	},
	methods: {
		onClick: function (event: Event) {
			if (this.currentOrder.has(this.dish.id)) {
				return
			} else {
				this.selected = true;
				this.selectedAmount = 1;
				this.currentOrder.set(this.dish.id, createCurrentOrderItem(this.dish, 1))
			}
		},
		onAmountChange: function (newAmount: number) {
			if (newAmount <= 0) {
				this.currentOrder.delete(this.dish.id)
				this.selectedAmount = 0;
				this.selected = false;
			} else {
				let current = this.currentOrder.get(this.dish.id)
				this.currentOrder.set(this.dish.id, { ...current, amount: newAmount } as CurrentOrderItem)
			}
		},
		resetMenuItem: function() {
			this.selected = false;
			this.selectedAmount = 0;
			this.$refs.amountWidget.reset();
		}
	}
})
</script>
<template>
	<div class="menu-item" :class="{ 'menu-item--selected': selected }" @click="onClick">
		<LabelValue class="menu-item__item_name" label="Gerecht" :value="dish.name" />
		<LabelValue class="menu-item__item_price" label="Prijs" :value="dish.price.toFixed(2)" />
		<AmountWidget class="menu-item__amount" @change="onAmountChange" ref="amountWidget" />
	</div>
</template>