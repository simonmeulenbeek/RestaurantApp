<script lang="ts">
    import { defineComponent, nextTick } from 'vue'
    
    export default defineComponent({
        props: {
            target: {
                type: String,
                required: true
            }
        },
        data() { return {
            isReady: false
        } },
        methods: {},
        computed: {},
        watch: {},
        mounted() {
            nextTick().then(() => {
                this.isReady = true;
            })
        },
    })
</script>
<template>
    <Teleport :disabled="!isReady" :to="target">
        <div class="debug__content-item">
            <div class="">bla die bla</div>
            <slot></slot>
        </div>
    </Teleport>
</template>