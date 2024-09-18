<script lang="ts">
    import { defineComponent } from 'vue'
    
    export default defineComponent({
        props: {
            label: {
                type: String,
                required: false,
                default: "label"
            },
            value: {
                required: false
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
    <div class="debug__content-item">
        <div class="label">{{ label }}</div>
        <div class="value">{{ value }}</div>
    </div>
</template>