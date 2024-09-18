<script lang="ts">
import { defineComponent, type PropType } from 'vue'
import { useMediaQuery, useStorage } from '@vueuse/core'
import { AkChevronUp, AkCross } from '@kalimahapps/vue-icons'

import type { CurrentOrderItem } from '@/types/order_item'
import { tabletStore } from '@/services/tablets/TabletStore'
import CurrentOrderItemComponent from './CurrentOrderItemComponent.vue'

export default defineComponent({
	emits: ['orderClear'],
	components: { 
		CurrentOrderItemComponent,
		AkChevronUp,
		AkCross
	},
	props: {
		order: {
			type: Function,
			required: false
		}
	},
	data() { return {
		currentOrder: useStorage('current-order', new Map() as Map<string, CurrentOrderItem>, sessionStorage),
		isMobile: useMediaQuery('(max-width: 1024px)'),
		isExpanded: false,
		tabletStore,
		isOrdering: false
	} },
	computed: {
		totalPrice(): number {
			let total = 0.0
			this.currentOrder.forEach(orderItem => {
				total += (orderItem.amount * orderItem.pricePerUnit)
			});
			return total;
		} 
	},
	watch: {},
	mounted() {
	},
	methods: {
		clearCurrentOrder: function() {
			this.currentOrder = new Map()
			this.mobileCollapse();
			this.$emit("orderClear");
		},
		orderItems: function() {
			console.log("ordering!")
			this.isOrdering = true;
			this.order?.();
		},
		toggle: function(state: boolean) {
			this.isExpanded = state;
			document.body.classList.toggle("state--modal", state);
		},
		mobileExpand: function() {
			if(this.isMobile && this.isExpanded === false) {
				console.log("mobileExpand if-true")
				this.toggle(true);
			}
		},
		mobileCollapse: function() {
			if(this.isMobile && this.isExpanded === true) {
				console.log("mobileCollapse if-true")
				this.toggle(false);
			}
		},
	}
})
</script>
<template>
	<Teleport :disabled="!isMobile" to="body">
		<div class="modal_background" :class="{'modal_background--expanded': isExpanded && isMobile }" @click="mobileCollapse()" v-show="currentOrder.size >= 1">
			<div class="current_order_component" :class="{ 'current_order_component--expanded': isExpanded && isMobile }" @click.stop="mobileExpand()">
				<div class="current_order" :class="{ 'current_order--expanded': isExpanded && isMobile }">
					<div v-if="isMobile"  class="current_order__buttons">
						<AkChevronUp class="current_order__btn-chevron-up" />
						<AkCross class="current_order__btn-close" @click.stop="mobileCollapse()"/>
					</div>
					<h3>Bestelling</h3>
					<div class="current_order__content">
						<div class="current_order__table_headers">
							<div class="current_order__table_header current_order__table_header__dish">Gerecht</div>
							<div class="current_order__table_header current_order__table_header__amount">Aantal</div>
							<div class="current_order__table_header current_order__table_header__price">Prijs</div>
							<div class="current_order__table_header current_order__table_header__total">Subtotaal</div>
						</div>
						<div class="current_order__table_content">
							<CurrentOrderItemComponent v-for="[_, orderItem] in currentOrder" :key="orderItem.dishId" :item="orderItem" />
						</div>
						<div class="current_order__total">
							<div class="current_order__total_label">Totaal:</div>
							<div class="current_order__total_value">{{ this.totalPrice.toFixed(2) }}</div>
						</div>
						<div class="current_order__actions">
							<button v-if="order" class="current_order__btn-clear" @click.stop="clearCurrentOrder" :disabled="isOrdering">Clear</button>
							<button v-if="order" class="current_order__btn-order" @click.stop="orderItems" :disabled="isOrdering">Order</button>

						</div>
					</div>
				</div>
			</div>
		</div>
	</Teleport>
</template>