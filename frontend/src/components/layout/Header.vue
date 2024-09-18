<script lang="ts">
import { defineComponent } from 'vue'

import { TaAdjustments } from '@kalimahapps/vue-icons'
import ToggleSwitch from 'icons/ToggleSwitch.vue'

import { tabletStore } from '@/services/tablets/TabletStore';
import { registerNewTablet } from '@/services/tablets/TabletService';
import { createNewSession } from '@/services/sessions/SessionService';

export default defineComponent({
	components: {
		ToggleSwitch,
        TaAdjustments
	},
    data() {
        return {
            tabletStore
        }
    },
	methods: {
        registerTablet: function() {
            registerNewTablet()
                .then((data) => {
                    this.tabletStore.tablet = data;
                })
        },
		updateTableNumber: function(tableNumber: Number) {
			console.log(tableNumber)
		},
        toggleTablet: function() {
            if (this.tabletStore.tabletId && this.tabletStore.table){
                createNewSession(this.tabletStore.tabletId, this.tabletStore.table.id)
                    .then((data) => {
                        this.tabletStore.session = data;
                    })
            }
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
			<p class="header_tafel_aanduiding__nummer">{{ tabletStore.registration?.tableData?.tableNumber ? tabletStore.registration?.tableData?.tableNumber : "xx" }}</p>
		</div>
		<Modal ref="tafelSettings" :showCloseButton="true" >
            <div class="modal_form form">
                <div class="form__item form__item--single-line">
                    <div class="label">Tablet Registration</div>
                    <div class="value">{{ this.tabletStore.tablet ? '✅' : '❌' }}</div>
                    <button class="action" @click="registerTablet()">Register</button>
                </div>
                <div class="form__item form__item--single-line">
                    <div class="label">Table Registration</div>
                    <div class="value">{{ this.tabletStore.registration ? '✅' : '❌' }}</div>
                    <button class="action" @click="$refs.tableSelector?.toggleModal()">assign</button>
                    <Modal ref="tableSelector">
						<TableSelector/>
                    </Modal>
                </div>
                <div class="form__item form__item--single-line">
                    <div class="label">{{ this.tabletStore.enabled ? "Disable" : "Enable" }} Tablet</div>
                    <div class="value">{{ this.tabletStore.session ? '✅' : '❌'  }}</div>
                    <button class="action" @click="toggleTablet()">{{ this.tabletStore.enabled ? "Disable" : "Enable" }}</button>
                </div>
            </div>
		</Modal>
	</header>
</template>
