export interface ResData<T> {
  status: number
  message: string
  data: T
  token: string
  timestamp: string
}

// 用户
export interface User {
  id?: number
  userId?: string
  name?: string
  password?: string
  major?: string
  //  性别(0?:  女, 1?:  男)
  gender?: string
  // 部门(0?:  策划, 1?:  研发, 2?:  新媒体, 3?:  美工部)
  department?: '策划部' | '研发部' | '研发部' | '设计部'
  // 岗位(0?:  待加入, 1?:  部员, 2?:  部长, 3?:  总负责人, 4?:  老师)
  position?: '待加入' | '部员' | '部长' | '总负责人' | '老师'
  session?: number
  //   是否在职位(0?:  在, 1?:  不在)
  isIn?: 0 | 1
  //   是否为管理员(0?:  否, 1?:  是)
  isAdmin?: 0 | 1
  phone?: string
  qq?: string
  weChat?: string
  signature?: string
  introduction?: string
  reviews?: string
  email?: string
  school?: '厦门' | '泉州'
  avatar?: string
}
// 日志
export interface Log {
  id?: number
  content?: string
  time?: string
  year?: string
}

// 公告
export interface Announcement {
  id?: number
  content?: string
  time?: string
  year?: string
}
