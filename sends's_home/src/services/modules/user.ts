import { http } from '../http'
import { type User } from '@/types/entity'

export const userService = {
  /**
   * 获取天气信息
   * @param city 城市,如:福建省
   * @returns
   */
  updateUserApi: (user: User) => {
    return http<User>({
      method: 'PUT',
      url: `/user/updateUser`,
      data: {
        ...user,
      },
    })
  },
  /**
   *
   * @param size 一次请求返回的数据量
   * @returns
   */
  loginApi: (user: User) => {
    return http<User>({
      method: 'POST',
      url: `/user/login`,
      data: {
        userId: user.userId,
        password: user.password,
      },
    })
  },
  addUserApi: (user: User) => {
    return http<User>({
      method: 'POST',
      url: `/user/addUser`,
      data: {
        ...user,
      },
    })
  },
  getUserDataByYearApi: (year: number) => {
    return http<User>({
      method: 'GET',
      url: `/user/getUserDataByYear/${year}`,
    })
  },
  getMyDataApi: (id: number) => {
    return http<User>({
      method: 'GET',
      url: `/user/getMyData/${id}`,
    })
  },
  getDepartmentUserDataByYearApi: (department: string, year: number) => {
    return http<User>({
      method: 'GET',
      url: `/user/getDepartmentUserDataByYear/${department}/${year}`,
    })
  },
  getDepartmentUserDataApi: (department: string) => {
    return http<User>({
      method: 'GET',
      url: `/user/getDepartmentUserData/${department}`,
    })
  },
  getDefaultUserDataApi: () => {
    return http<User>({
      method: 'GET',
      url: `/user/getDefaultUserData`,
      data: {},
    })
  },

  deleteUserApi: (id: number) => {
    return http<User>({
      method: 'DELETE',
      url: `/user/deleteUser/${id}`,
    })
  },
}
