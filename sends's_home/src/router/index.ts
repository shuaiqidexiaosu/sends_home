import {
  createRouter,
  createWebHistory,
} from 'vue-router'

import { useUserStore } from '@/stores/index'

import { departments } from './modules/department'
import { components } from './modules/components'
import { home } from './modules/home'
import { my } from './modules/my'
import { permissions } from './modules/permissions'

const Main = () => import('@/views/Main.vue')

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/main',
      name: 'main',
      component: Main,
      meta: {
        title: '总页面',
      },
      children: [
        // 主页路由
        ...home,
        // 部门路由
        ...departments,
        // 我的路由
        ...my,
        // 组件路由
        ...components,
        // 权限路由
        ...permissions,
      ],
    },

    {
      path: '/:pathMatch(.*)*',
      redirect: '/',
    },
  ],
})

router.beforeEach((to, from, next) => {
  const userStore = useUserStore()
  if (userStore.isLogin !== true) {
    if (to.path === '/login') {
      next()
    } else {
      next('/login')
    }
  } else {
    // 跳转到首页
    if (to.path === '/login') {
      next('/')
    } else {
      document.title = `桑梓之家${to.meta.title}` || '默认标题'
      next()
    }
  }
})

export default router
