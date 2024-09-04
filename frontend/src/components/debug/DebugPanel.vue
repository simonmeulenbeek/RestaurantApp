<script lang="ts">
import { defineComponent } from 'vue'

import Modal from '../common/Modal.vue'
import {tabletStore} from '@/services/tablets/TabletStore'

export default defineComponent({
	components: { Modal },
    data() {
        return {
            tabletStore
        }
    }
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