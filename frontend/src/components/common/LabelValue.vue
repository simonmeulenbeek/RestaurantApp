<script lang="ts">
    import { defineComponent } from 'vue'
    
    export default defineComponent({
        props: {
            label: {
                type: String,
                required: false,
                default: ""
            },
            value: {
                type: String,
                required: false,
                default: ""
            }
        }
    })
</script>
<template>
<div class="label_value">
    <div class="label_value__label">{{ label }}</div>
    <div class="label_value__value">{{ value }}</div>
</div>
</template>