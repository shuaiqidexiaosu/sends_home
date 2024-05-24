const My = () => import('@/views/my/My.vue')
const Admin = () => import('@/views/my/Admin.vue')


export const my = [
  {
    path: '/my',
    name: 'my',
    component: My,
    meta: {
      title: '个人中心',
    },
  },

  {
    path: '/admin',
    name: 'admin',
    component: Admin,
    meta: {
      title: '管理中心',
    },
  },
]
