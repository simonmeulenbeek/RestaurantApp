<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType } from 'vue';

export default defineComponent({
	expose: ['toggleModal'],
	props: {
        showCloseButton: {
            type: Boolean,
            required: false,
            default: true
        },
		targetProp: {
			type: Object as PropType<HTMLElement>,
			required: false
		}
	},
	data() {
		return {
			target: this.targetProp ? this.targetProp : "body",
			open: false
		}
	},
	methods: {
		toggleModal: function () {
			this.open = !this.open
			document.body.classList.toggle("state--modal", this.open)
		}
	},
	computed: {},
	watch: {},
	mounted() { },
})
</script>
<template>
	<Teleport to="body">
		<div class="modal" v-if="open">
			<div class="modal__content">
				<slot></slot>
				<button v-if="showCloseButton" @click="toggleModal">Close</button>
			</div>
		</div>
	</Teleport>
</template>