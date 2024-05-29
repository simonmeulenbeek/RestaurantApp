<script>
export default {
	expose: ['toggleView'],
	props: {
		switch: {
			type: Boolean,
			required: false,
			default: false,
		},
		buttonElement: {
			type: HTMLElement | null,
			required: false,
			default: null,
		},
	},
	data() {
		return {
			showDefault: !this.switch,
			showAlternative: this.switch,
		}
	},
	methods: {
		toggleView() {
			this.showDefault = !this.showDefault
			this.showAlternative = !this.showAlternative
		},
	},
}
</script>
<template>
	<div class="view_switcher">
		<slot name="default" v-if="showDefault" />
		<slot name="alternative" v-if="showAlternative" />
	</div>
</template>
