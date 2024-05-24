

const User = () => import('@/views/components/User.vue')
const UserInfoEdit = () => import('@/views/components/UserInfoEdit.vue')
const MyInfoEdit = () => import('@/views/components/MyInfoEdit.vue')
export const components = [
  {
    path: '/user/:id/:name/:department/:position/:session/:major/:phone/:email/:qq/:weChat/:userId/:school/:gender/:signature/:introduction',
    name: 'user',
    component: User,
    meta: {
      title: '成员信息展示页面',
      requiresAuth: true,
    },
  },
  {
    path: '/userInfoEdit/:id/:name/:department/:position/:session/:major/:phone/:email/:qq/:weChat/:userId/:school/:gender/:isAdmin/:reviews/:signature/:introduction',
    name: 'userInfoEdit',
    component: UserInfoEdit,
    meta: {
      title: '成员信息编辑页面',
      requiresAuth: true,
    },
  },
  {
    path: '/myInfoEdit/:id/:name/:department/:position/:session/:major/:phone/:email/:qq/:weChat/:userId/:school/:gender/:isAdmin/:reviews/:signature/:introduction',
    name: 'myInfoEdit',
    component: MyInfoEdit,
    meta: {
      title: '成员信息编辑页面',
      requiresAuth: true,
    },
  },
]
