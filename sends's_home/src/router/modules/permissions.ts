const Login = () => import('@/views/permissions/Login.vue')

export const permissions = [

  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {
      title: '登录界面',
    },
  },
]
