<template>
  <div v-if="isLoaded">
    <ul class="timeline timeline-vertical" v-for="(item,index) in userStore.announcementList.slice().reverse()" :key="item.id">
      <li v-if="index%2 === 0" class="hover:-translate-y-1.5 transition-all	duration-400	">
        <hr />
        <div class="timeline-middle">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5 text-primary">
            <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.857-9.809a.75.75 0 00-1.214-.882l-3.483 4.79-1.88-1.88a.75.75 0 10-1.06 1.061l2.5 2.5a.75.75 0 001.137-.089l4-5.5z" clip-rule="evenodd" />
          </svg>
        </div>
        <div class="timeline-end timeline-box font-bold text-gray-500  max-w-2xl my-4 flex">
          <p class="leading-6">
            {{ item.time }} <br>
            {{ item.content }}
          </p>
          <button class="btn btn-error btn-xs mx-2" @click="deleteAnnouncement(item.id)" v-if="userStore.userInfo.isAdmin === 1">删除</button>
        </div>
        <hr />
      </li>
      <li v-else class="hover:-translate-y-1.5 transition-all	duration-400 ">
        <hr />
        <div class="timeline-start timeline-box font-bold text-gray-500  max-w-2xl my-4 flex">
          <button class="btn btn-error btn-xs mx-2" @click="deleteAnnouncement(item.id)" v-if="userStore.userInfo.isAdmin === 1">删除</button>
          <p class="leading-6">
            {{ item.time }} <br>
            {{ item.content }}
          </p>
        </div>
        <div class="timeline-middle">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5">
            <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.857-9.809a.75.75 0 00-1.214-.882l-3.483 4.79-1.88-1.88a.75.75 0 10-1.06 1.061l2.5 2.5a.75.75 0 001.137-.089l4-5.5z" clip-rule="evenodd" />
          </svg>
        </div>
        <hr />
      </li>
    </ul>
  </div>
  <div v-else class="flex justify-center items-center h-full">
    <span class="loading loading-spinner loading-lg"></span>
  </div>
  <Footer></Footer>
</template>

<script setup lang="ts">
import { useUserStore } from "@/stores/index";
const userStore = useUserStore();

import { announcementService } from "@/services";
import { onMounted, ref } from "vue";
import { Announcement } from "@/types/entity";
import { ElMessage, ElMessageBox } from "element-plus";

onMounted(() => {
  getAnnouncementList();
});

const isLoaded = ref(false);

// 删除公告
async function deleteAnnouncement(id: number) {
  ElMessageBox.confirm("确定要删除该公告吗？", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "error",
  })
    .then(async () => {
      const res = await announcementService.deleteAnnouncementApi(id);
      if (res.status === 200) {
        userStore.deleteAnnouncement(id);
        ElMessage({
          type: "success",
          dangerouslyUseHTMLString: true,
          message: "<h3 class='text-base'>公告已经删除!</h3>",
        });
      } else {
        ElMessage({
          message: "公告删除失败了,主人",
          type: "error",
        });
        console.log("登陆失败");
        return;
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "取消了哟",
      });
    });
}

async function getAnnouncementList() {
  if (userStore.announcementList.length === 0) {
    const res = await announcementService.getDefaultAnnouncementApi();
    console.log(res);
    if (res.status === 200) {
      console.log(res.status);
      userStore.addAnnouncements(res.data as Announcement[]);
      isLoaded.value = true;
      console.log(userStore.announcementList);
    }
  } else {
    isLoaded.value = true;
  }

  console.log("苏健尧的公告");
}
</script>

