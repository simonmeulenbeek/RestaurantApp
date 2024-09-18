<script lang="ts">
import { defineComponent } from 'vue'
import { useStorage } from '@vueuse/core'

import { v4 as uuidv4 } from 'uuid'

import { initialize } from './services/tablets/TabletService';
import { tabletStore } from './services/tablets/TabletStore';

export default defineComponent({
	data() {
		return {
			viewSwitcherReference: null as HTMLElement | null,
            tabletId: useStorage('tablet_id', uuidv4(), localStorage),
            tabletStore
		}
	},
	mounted() {
		this.viewSwitcherReference = this.$refs.viewSwitcher as HTMLElement;
        initialize(this.tabletId);
	},
})
</script>
<template>
	<main id="app">
		<Header :tableNumber="tabletStore.registration?.tableData?.tableNumber"/>
		<div class="app__content">
			<ViewSwitcher :reactiveBoolean="!!(tabletStore.session)">
				<template #default>
					<StappenPlan />
				</template>
				<template #alternative>
					<Menu />
				</template>
			</ViewSwitcher>
		</div>
		<DebugPanel>
            <DebugContentItem label="Tablet ID" :value="tabletId" />
            <DebugContentItem label="Table  ID" :value="tabletStore.table?.id" />                       
            <DebugContentItem label="Registration" :value="tabletStore.registration" />
            <DebugContentItem label="Session ID" :value="tabletStore.session?.id" />
        </DebugPanel>
		<SocketMessager />
	</main>
</template>
