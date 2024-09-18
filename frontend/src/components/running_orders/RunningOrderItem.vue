<script lang="ts">
import type { Order } from '@/types/order';
import { defineComponent, type PropType } from 'vue'

export default defineComponent({
    components: {},
    emits: [],
    props: {
        order: {
            type: Object as PropType<Order>,
            required: true
        }
    },
    data() { return {} },
    methods: {},
    computed: {},
    watch: {},
    mounted() {}
})
</script>
<template>
    <div class="running_order_item">
        <div class="running_order_item__id">{{ order.id }}</div>
        <div class="running_order_item__session">{{ order.session?.id }}</div>
        <div class="running_order_item__order_items">{{ order.orderItems?.length }}</div>
        <div class="running_order_item__status">---state---</div>
    </div>
</template>