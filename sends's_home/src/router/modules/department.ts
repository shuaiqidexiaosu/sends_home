const All = () => import('@/views/department/All.vue')
const Art = () => import('@/views/department/Art.vue')
const NewMedia = () => import('@/views/department/NewMedia.vue')
const Plan = () => import('@/views/department/Plan.vue')
const Produce = () => import('@/views/department/Produce.vue')

export const departments = [
  {
    path: '/all',
    name: 'all',
    component: All,
    meta: {
      title: '所有成员',
    },
  },
  {
    path: '/plan',
    name: 'plan',
    component: Plan,
    meta: {
      title: '策划部',
    },
  },
  {
    path: '/produce',
    name: 'produce',
    component: Produce,
    meta: {
      title: '研发部',
    },
  },
  {
    path: '/NewMedia',
    name: 'NewMedia',
    component: NewMedia,
    meta: {
      title: '新媒体',
    },
  },
  {
    path: '/art',
    name: 'art',
    component: Art,
    meta: {
      title: '设计部',
    },
  },
]
