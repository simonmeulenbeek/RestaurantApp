<script lang="ts">
import { defineComponent } from 'vue'

import SessionType from '@/types/session_type';

export default defineComponent({
    data() {
        return {
            currentSession: SessionType.Base
        }
    },
    methods: {
        updateCurrentSession(new_session: SessionType) {
            this.currentSession = new_session;
        }
    },
    computed: {},
    watch: {},
    mounted() {},
});
</script>

<template>
    <div class="session_manager">
        <slot name="session_indepenedent" />
        <slot name="session_dependent" />
    </div>
</template>