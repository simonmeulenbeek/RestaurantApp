<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType } from 'vue';

export default defineComponent({
	expose: ['toggleModal'],
	provide() {
		return {
			modalClose: this.close,
			modalOpen: this.open,
			modalToggle: this.toggle,
			modalComplete: this.complete,
			modalAbort: this.abort
		}
	},
	props: {
        showCloseButton: {
            type: Boolean,
            required: false,
            default: true
        },
		targetProp: {
			type: Object as PropType<HTMLElement>,
			required: false
		},
		onOpen: {
			type: Function,
			required: false
		},
		onClose: {
			type: Function,
			required: false
		},
		onAbort: {
			type: Function,
			required: false
		},
		onComplete: {
			type: Function,
			required: false
		}
	},
	data() {
		return {
			target: this.targetProp ? this.targetProp : "body",
			isOpened: false
		}
	},
	methods: {
		toggle: function () {
			this.setModal(!this.isOpened);
		},
		open: function () {
			this.isOpened = true;
			document.body.classList.toggle("state--modal", true);
			this.onOpen?.();
		},
		close: function () {
			this.isOpened = false;
			document.body.classList.toggle("state--modal", false);
			this.onClose?.();
		},
		abort: function () {
			this.onAbort?.();
			this.close();
		},
		complete: function () {
			this.onComplete?.();
			this.close();
		},
		setModal: function(open: boolean) {
			if(open) {
				this.open();
			} else {
				this.close();
			}
		},
		toggleModal: function () {
			this.toggle();
		}
	},
	computed: {},
	watch: {},
	mounted() {
		console.log("open: ", this.isOpened, ", parent: ", this.$parent);
	},
})
</script>
<template>
	<Teleport :to="target">
		<div class="modal" v-if="isOpened">
			<div class="modal__content">
				<slot></slot>
				<button v-if="showCloseButton" @click="toggle">Close</button>
			</div>
		</div>
	</Teleport>
</template>