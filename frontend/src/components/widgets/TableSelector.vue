<script lang="ts">
    import { defineComponent } from 'vue'
    import type { AxiosResponse } from 'axios'
    
    import type { TableData } from '@/types/table_data'
    import { getAllTables, registerTabletToTable } from '@/services'
    import { tabletStore } from '@/services/tablets/TabletStore'
    
    import { ModalControlMixin } from '../common/ModalCrontolMixin'
import type { TabletRegistration } from '@/types/tablet_registration'

    export default defineComponent({
        mixins: [ModalControlMixin],
        data() { 
            return {
                tables: [] as TableData[],
                selectedTable: null,
                tabletStore,
                loading: true
            }
        },
        methods: {
            registerFunction: function () {
                if (this.tabletStore.tabletId && this.selectedTable) {
                    registerTabletToTable(this.tabletStore.tabletId, this.selectedTable)
                        .then((response: TabletRegistration) => {
                            console.log(response);
                            this.tabletStore.registration = response;
                            this.tabletStore.table = response.tableData;
                            this.closeModal();
                    });
                }
            }
        },
        mounted() {
            if (this.tabletStore.tabletId) {
                getAllTables().then((response: TableData[]) => {
                    this.tables = response;
                    this.loading = false;
                }
            );
            };
        },
    })
</script>
<template #modal-items="props">
    <div class="table_selector">
        <select class="table_selector__selectbox" name="table_selector" v-model="selectedTable" size="8">
            <template v-if="loading">
                loading...
            </template>
            <template v-else>
                <option class="table_selector__option table_option" v-for="table in tables" :key="table.id" :value="table.id">
                    <div class="container">
                        <div class="table_option__id">
                            {{ table.id }}
                        </div>
                        <div class="table_option__table_number">
                            {{ table.tableNumber ? table.tableNumber : "No tablenumber assigned" }}
                        </div>
                    </div>
                </option>
            </template>
        </select>
        <button class="table_selector__btn_choose" @click="registerFunction">
            Assign table
        </button>
    </div>
</template>