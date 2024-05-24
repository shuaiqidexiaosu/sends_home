import axios, {
  type AxiosResponse,
  type InternalAxiosRequestConfig,
} from 'axios'
import { useUserStore } from '@/stores/index'

export const http = axios.create({
  baseURL: import.meta.env.VITE_SERVICE_URL,
  timeout: 6000,
  responseType: 'json',
  headers: { 'Content-Type': 'application/json; charset=utf-8' },
})

// 请求拦截器
http.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {
    const userStore = useUserStore()
    if (userStore.token) {
      config.headers!.token = userStore.token // 设置token
    }
    return config
  },
  (error: Error) => {}
)

// 后置拦截器（获取到响应时的拦截）
http.interceptors.response.use(
  (res: AxiosResponse) => {
    return res.data
  },
  (error) => {
    return Promise.reject(new Error(error))
  }
)
