<script lang="ts">
import { defineComponent } from 'vue'

import Modal from '../common/Modal.vue'

export default defineComponent({
	components: { Modal }
})
</script>
<template>
	<Teleport to="body">
		<div id="debug" class="debug" @click="this.$refs.debug_modal.toggleModal()">
			Debug
			<Modal ref="debug_modal">
				<div class="debug__content" id="debug-content">
                    <slot></slot>
                </div>
			</Modal>
		</div>
	</Teleport>
</template>