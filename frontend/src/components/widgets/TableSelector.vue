<script lang="ts">
    import { defineComponent } from 'vue'
    import type { PropType } from 'vue'

    import { useStorage } from '@vueuse/core'
    import { v4 as uuidv4 } from 'uuid'

    import { getAllTables, registerTabletToTable } from '@/services'
    import type { TableData } from '@/types/table_data'

    export default defineComponent({
        props: {},
        data() { return {
            tables: [] as TableData[],
            selectedTable: null,
            tabletId: useStorage('tablet_id', uuidv4(), localStorage),
            registration: useStorage('tablet_registration', null, sessionStorage)
        } },
        methods: {
            registerFunction: function () {
                console.log("tabletId: ", this.tabletId);
                console.log("selectedTable: ", this.selectedTable);
                
                registerTabletToTable(this.tabletId, this.selectedTable)
            },
            registerTabletToTable: function (tabletId: string, tableId: string) {
                registerTabletToTable(tabletId, tableId).then((result) => this.registration = result);
            }
        },
        computed: {},
        watch: {},
        mounted() {
            getAllTables().then((result) => this.tables = result);
        },
    })
</script>
<template>
    <div class="table_selector">
        <select class="table_selector__selectbox" name="table_selector" v-model="selectedTable" size="8">
            <option class="table_selector__option table_option" v-for="table in tables" :key="table.id" :value="table.id">
                <div class="table_option__id">
                    {{ table.id }}
                </div>
                 <div class="table_option__table_number">
                    {{ table.tableNumber ? table.tableNumber : "No tablenumber assigned" }}
                 </div>
            </option>
        </select>
        <button class="table_selector__btn_choose" @click="registerFunction">
            Assign table
        </button>
    </div>
</template>