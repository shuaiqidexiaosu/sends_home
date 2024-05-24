import { http } from '../http'
import { type Announcement } from '@/types/entity'

export const announcementService = {

  getAnnouncementByYearApi: (year : number) => {
    return http<Announcement>({
      method: 'GET',
      url: `/announcement/getAnnouncementByYear/${year}`,
      data: {},
    })
  },

  getDefaultAnnouncementApi: () => {
    return http<Announcement>({
      method: 'GET',
      url: `/announcement/getDefaultAnnouncement`,
      data: {},
    })
  },
  addAnnouncementApi: (announcement: Announcement) => {
    return http<Announcement>({
      method: 'POST',
      url: `/announcement/addAnnouncement`,
      data: {
        ...announcement,
      },
    })
  },
  deleteAnnouncementApi: (id: number) => {
    return http<Announcement>({
      method: 'DELETE',
      url: `/announcement/deleteAnnouncement/${id}`,
    })
  },
}
