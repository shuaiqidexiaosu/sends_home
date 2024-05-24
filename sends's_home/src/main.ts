import { createApp } from 'vue'

// 全局重置样式导入
import './assets/styles/global.scss'
//持久化pinia仓库导入
import pinia from './stores'

import 'element-plus/dist/index.css'

import router from './router'

import App from './App.vue'



import Footer from '@/views/components/Footer.vue'

const app = createApp(App)

app.use(pinia)
app.use(router)

app.component('Footer', Footer)

app.mount('#app')
