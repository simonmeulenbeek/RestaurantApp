import { createApp } from 'vue'
import App from './App.vue'
import { registerComponents } from './components'
import './scss/main.scss'

const app = createApp(App)
registerComponents(app);

app.mount('#app')
