<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType, Ref } from 'vue'
import { useMediaQuery, useStorage } from '@vueuse/core';

import type { CurrentOrderItem } from '@/types/order_item'
import CurrentOrderItemComponent from './CurrentOrderItemComponent.vue';

export default defineComponent({
	components: { CurrentOrderItemComponent },
	props: {},
	data() { return {
		currentOrder: useStorage('current-order', new Map() as Map<string, CurrentOrderItem>, sessionStorage),
		isMobile: useMediaQuery('(max-width: 1024px)')
	} },
	methods: {},
	computed: {},
	watch: {},
	mounted() {
	},
})
</script>
<template>
	<Teleport :disabled="!isMobile" to="body">
		<div class="current_order_component">
			<div class="current_order">
				<h3>Bestelling</h3>
				<div class="current_order__content">
					<div class="current_order__table_headers">
						<div class="current_order__table_header current_order__table_header__dish">Gerecht</div>
						<div class="current_order__table_header current_order__table_header__amount">Aantal</div>
						<div class="current_order__table_header current_order__table_header__price">Prijs</div>
						<div class="current_order__table_header current_order__table_header__total">Subtotaal</div>
					</div>
					<CurrentOrderItemComponent v-for="[_, orderItem] in currentOrder" :key="orderItem.dishId" :item="orderItem" />
				</div>
			</div>
		</div>
	</Teleport>
</template>