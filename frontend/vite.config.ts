import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        vueDevTools()
    ],
    server: {
        open: '',
        watch: {
            usePolling: true
        }
    },
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url)),
            'icons': fileURLToPath(new URL("./node_modules/vue-material-design-icons", import.meta.url))
        },
        extensions: [
            ".vue",
            ".ts"
        ]
    }
})
