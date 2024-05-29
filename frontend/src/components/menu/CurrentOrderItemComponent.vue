<script lang="ts">
    import { defineComponent } from 'vue'
    import type { PropType } from 'vue'
    import type { CurrentOrderItem } from '@/types/order_item';
    
    export default defineComponent({
        props: {
            item: {
                type: Object as PropType<CurrentOrderItem>,
                required: true
            }
        },
        data() { return {} },
        methods: {},
        computed: {},
        watch: {},
        mounted() {},
    })
</script>
<template>
    <div class="order-item">
        <div class="order-item__value order-item__name">
            {{ item.dishName }}
        </div>
        <div class="order-item__value order-item__amount">
            {{ item.amount }}
        </div>
        <div class="order-item__value order-item__ppu">
            {{ item.pricePerUnit.toFixed(2) }}
        </div>
        <div class="order-item__value order-item__total">
            {{ (item.pricePerUnit * item.amount).toFixed(2) }}
        </div>
    </div>
</template>