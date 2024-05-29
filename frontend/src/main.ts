import { createApp } from 'vue'
import App from './App.vue'
import { registerComponents } from './components'
import './scss/main.scss'
import { devtools } from '@vue/devtools'

const app = createApp(App)
registerComponents(app);

if (process.env.NODE_ENV === 'development')
	devtools.connect()

app.mount('#app')
