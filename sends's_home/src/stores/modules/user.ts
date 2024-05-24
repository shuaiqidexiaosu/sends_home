import { Announcement } from './../../types/entity'
import type { Log, User } from '@/types/entity'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore(
  'user',
  () => {
    // 是否登陆
    const isLogin = ref<boolean>(false)
    const Login = (): void => {
      isLogin.value = true
    }

    const Logout = (): void => {
      isLogin.value = false
    }

    // token值
    const token = ref<string>('')
    const setToken = (resToken: string) => {
      token.value = resToken
    }


    // 用户信息
    const userInfo = ref<User>({})
    const setUserInfo = (resUserInfo: User) => {
      userInfo.value = resUserInfo
    }

    // 日志列表
    const logList = ref<Log[]>([])

    const addLog = (log: Log) => {
      logList.value.push(log)
    }
    const addLogs = (logs: Log[]) => {
      logList.value = [...logs]
    }

    const deleteLog = (id: number) => {
      logList.value = logList.value.filter(log => log.id !== id)
    }

    // 公告列表
    const announcementList = ref<Announcement[]>([])

    const addAnnouncement = (announcement: Announcement) => {
      announcementList.value.push(announcement)
    }
    const addAnnouncements = (announcements: Announcement[]) => {
      announcementList.value = [...announcements]
      console.log(announcementList.value)
    }

    const deleteAnnouncement = (id: number) => {
      announcementList.value = announcementList.value.filter(announcement => announcement.id !== id)
    }

    // 记得 return
    return {
      isLogin,
      token,
      userInfo,
      logList,
      announcementList,
      Login,
      Logout,
      setToken,
      setUserInfo,
      addLog,
      addLogs,
      deleteLog,
      addAnnouncement,
      addAnnouncements,
      deleteAnnouncement,
    }
  },
  {
    // 网页端配置
    persist: true,
  }
)
