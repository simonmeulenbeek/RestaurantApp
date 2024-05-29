<script lang="ts">
    import { defineComponent } from 'vue'
    
    export default defineComponent({
        emits: ['change'],
        props: {
            initial: {
                type: Number,
                required: false,
                default: 1
            }
        },
        data() { return {
            amount: this.initial
        } },
        methods: {
            increase: function () {
                this.amount++;
                this.$emit('change', this.amount);
            },
            decrease: function () {
                this.amount--;
                this.$emit('change', this.amount);
                if(this.amount <= 0) {
                    this.amount = 1                    
                }
            },
            stopPropagation: function(event: Event) {
                event.stopPropagation();
            }
        }
    })
</script>
<template>
    <div class="amount_widget" @click="stopPropagation">
        <div class="amount_widget__amount">{{ amount }}</div>
        <div class="amount_widget__button_minus" @click="decrease">-</div>
        <div class="amount_widget__button_plus" @click="increase">+</div>
    </div>
</template>