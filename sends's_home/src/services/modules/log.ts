import { http } from '../http'
import { type Log } from '@/types/entity'

export const logService = {
  /**
   * 获取天气信息
   * @param city 城市,如:福建省
   * @returns
   */
  addLogApi: (log:Log) => {
    return http<Log>({
      method: 'POST',
      url: `/log/addLog`,
      data: {
        ...log,
      },
    })
  },

  getLogsApi: () => {
    return http<Log>({
      method: 'GET',
      url: `/log/getLogs`,
    })
  },

  deleteLogApi: (id: number) => {
    return http<Log>({
      method: 'DELETE',
      url: `/log/deleteLog/${id}`,
      data: {},
    })
  },
}
