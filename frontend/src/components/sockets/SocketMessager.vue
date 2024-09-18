<script lang="ts">
import { defineComponent, ref} from 'vue'
import type {Ref} from 'vue'
import { useWebSocket } from '@vueuse/core'

export default defineComponent({
	components: {},
	data() : {
		status:  Ref<any, any> | null,
		data:  Ref<any, any> | null,
		send:  Ref<any, any> | null,
		open:  Ref<any, any> | null,
		close:  Ref<any, any> | null
	} { return {
		status: null,
		data: null,
		send: null,
		open: null,
		close: null
	}},
	methods: {
		sendMessage: function() {
			if(this.send) {
				this.send("hi!");
			}
		}
	},
	computed: {},
	watch: {
		data(newData, oldData) {
			console.log("------Watch--------");
			console.log("	new:", newData);
			console.log("	old:", oldData);
		}
	},
	mounted() {
		let url = import.meta.env.VITE_API_URL

		let {status, data, send, open, close} = useWebSocket(`ws://localhost:8080/socket`, {heartbeat: true});
		this.status = status;
		this.data = data;
		this.send = send;
		this.open = open;
		this.close = close;
	},
})
</script>
<template>
	<button @click="sendMessage()">send</button>
</template>