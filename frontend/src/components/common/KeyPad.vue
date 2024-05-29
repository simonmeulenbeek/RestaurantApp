<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType } from 'vue'

import IconBackspace from '../icons/IconBackspace.vue';
import Modal from '../common/Modal.vue';

export default defineComponent({
	props: {
		requiredCharacters: {
			type: Number,
			required: false,
			default: 5
		},
		onCompleted: {
			type: Function as PropType<(input: number) => void>
		},
		onCanceled: {
			type: Function as PropType<(input: number) => void>
		}
	},
	data() {
		return {
			current: "",
			error: ""
		}
	},
	methods: {
		addNumber: function (number: Number) {
			if (this.current.length < this.requiredCharacters) {
				this.current += number
			}
		},
		backspace: function() {
			this.current = this.current.slice(0, -1)
			if(this.current.length == 0) {
				this.error = ""
			}
		},
		confirm: function() {
			if (this.current.length == this.requiredCharacters) {
				this.onCompleted?.(Number(this.current))
				this.closeKeypad()
			} else {
				this.error = `Please enter ${this.requiredCharacters} digits`
			}
		},
		cancel: function() {
			this.onCanceled?.(Number(this.current))
			this.closeKeypad()
		},
		closeKeypad: function() {
			(this.$parent as Modal).toggleModal()
		}
	},
	computed: {},
	watch: {},
	mounted() { },
})
</script>
<template>
	<div class="keypad">
		<div class="keypad__top">
			<div class="keypad__input_display">{{ current }}</div>
			<button class="keypad__button keypad__backspace" @click="backspace()"><IconBackspace /></button>
		</div>
		<div class="keypad__errors">{{ error }}</div>
		<div class="keypad__inputs">
			<button class="keypad__button keypad__input_one" @click="addNumber(1)">1</button>
			<button class="keypad__button keypad__input_two" @click="addNumber(2)">2</button>
			<button class="keypad__button keypad__input_three" @click="addNumber(3)">3</button>
			<button class="keypad__button keypad__input_four" @click="addNumber(4)">4</button>
			<button class="keypad__button keypad__input_five" @click="addNumber(5)">5</button>
			<button class="keypad__button keypad__input_six" @click="addNumber(6)">6</button>
			<button class="keypad__button keypad__input_seven" @click="addNumber(7)">7</button>
			<button class="keypad__button keypad__input_eight" @click="addNumber(8)">8</button>
			<button class="keypad__button keypad__input_nine" @click="addNumber(9)">9</button>
			<button class="keypad__button keypad__input_zero" @click="addNumber(0)">0</button>
			<button class="keypad__button keypad__cancel" @click="cancel()">cancel</button>
			<button class="keypad__button keypad__confirm" @click="confirm()">confirm</button>
		</div>
	</div>
</template>