<script>
export default {
	expose: ['toggleView'],
	props: {
		reactiveBoolean: {
			type: Boolean,
			required: false
		},
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
		<template v-if="reactiveBoolean !== null">
			<slot name="default" v-if="reactiveBoolean === false" />
			<slot name="alternative" v-if="reactiveBoolean === true" />
		</template>
		<template v-else>
			<slot name="default" v-if="showDefault" />
			<slot name="alternative" v-if="showAlternative" />
		</template>
	</div>
</template>
