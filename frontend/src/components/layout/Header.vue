<script lang="ts">
import { defineComponent } from 'vue'
import type { PropType } from 'vue'

import { TaAdjustments } from '@kalimahapps/vue-icons'

import ToggleSwitch from 'icons/ToggleSwitch.vue'
import KeyPad from '../common/KeyPad.vue';

export default defineComponent({
	components: {
		ToggleSwitch,
        TaAdjustments
	},
	props: {
		tableNumber: {
			type: null as unknown as PropType<number | null>,
			required: false,
			default: null
		},
		viewSwitcherReference: {
			type: Object as PropType<ViewSwitcher> | HTMLElement,
			required: true,
		},
	},
	methods: {
		updateTableNumber: function(tableNumber: Number) {
			console.log(tableNumber)
		}
	},
	computed: {},
	watch: {},
	mounted() {},
})
</script>
<template>
	<header>
		<img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="96" height="96" />
		<h2>Restaurant app</h2>
		<div class="header_tafel_aanduiding" @click="$refs.tafelSettings?.toggleModal()">
            <div class="top">
                <p class="header_tafel_aanduiding__tekst">tafel</p>
                <TaAdjustments />
            </div>
			<p class="header_tafel_aanduiding__nummer">{{ tableNumber }}</p>
		</div>
		<Modal ref="tafelSettings" :showCloseButton="true" >
            <div class="modal_form form">
                <div class="form__item form__item--single-line">
                    <div class="label">Assign table number</div>
                    <button @click="$refs.tableSelector?.toggleModal()">assign</button>
                    <Modal ref="tableSelector">
						<TableSelector />
                    </Modal>
                </div>
                <div class="form__item form__item--single-line">
                    <div class="label">Enable Tablet</div>
                    <button>enable</button>
                </div>
            </div>
		</Modal>
	</header>
</template>
