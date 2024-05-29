<script lang="ts">
import { defineComponent } from 'vue'
import { useStorage } from '@vueuse/core'

import { v4 as uuidv4 } from 'uuid'

import axiosInstance from './services/axios/axios'

export default defineComponent({
	data() {
		return {
			viewSwitcherReference: null as HTMLElement | null,
            tabletId: useStorage('tablet_id', uuidv4(), localStorage),
			registration: useStorage('tablet_registration', null, sessionStorage)
		}
	},
	mounted() {
		this.viewSwitcherReference = this.$refs.viewSwitcher as HTMLElement
		axiosInstance
			.get(`/tablet_registrations/tablet/${this.tabletId}`)
			.then((response) => {
				console.log(response.data)
				this.registration = response.data 
			})
			.finally(() => {console.log("bla!")})
	},
})
</script>
<template>
	<main id="app">
		<Header :tableNumber="registration?.tableData?.tableNumber" v-if="viewSwitcherReference" :viewSwitcherReference="viewSwitcherReference" :switch="true" />
		<div class="app__content">
			<ViewSwitcher ref="viewSwitcher">
				<template #default>
					<StappenPlan />
				</template>
				<template #alternative>
					<Menu />
				</template>
			</ViewSwitcher>
		</div>
		<DebugPanel>
            <div class="debug__content-item">
                <div class="label">TabletID</div>
                <div class="value">{{ tabletId }}</div>
            </div>
            <div class="debug__content-item">
                <div class="label">Registration</div>
                <div class="value">{{ registration }}</div>
            </div>
        </DebugPanel>
	</main>
</template>
