

const Home = () => import('@/views/home/Home.vue')
const Log = () => import('@/views/home/Log.vue')
const Announcement = () => import('@/views/home/Announcement.vue')

export const home = [
  {
    path: '/',
    name: 'home',
    component: Home,
    meta: {
      title: '主页',
    },
  },
  {
    path: '/announcement',
    name: 'announcement',
    component: Announcement,
    meta: {
      title: '历史公告',
    },
  },
  {
    path: '/log',
    name: 'log',
    component: Log,
    meta: {
      title: '更新日志',
    },
  },
]
