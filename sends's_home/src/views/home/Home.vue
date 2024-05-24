<template>

  <div class="w-full h-full  ">

    <!-- 桑梓公告板 -->
    <dialog id="my_modal_1" class="modal modal-top">
      <div class="modal-box w-[600px] mx-auto  rounded-lg">
        <h3 class="font-bold text-lg">桑梓今日公告板</h3>
        <p class="py-4" v-if="isLoaded">{{ userStore.announcementList[userStore.announcementList.length - 1].content }}</p>
      </div>
      <form method="dialog" class="modal-backdrop border-none m-0 p-0 ">
        <button>关闭</button>
      </form>
    </dialog>
    <div class="card w-full h-auto bg-base-100 shadow-xl my-4 py-2 hover:-translate-y-1.5 transition-all	duration-400">
      <figure>
        <p class="text-xl font-bold text-[#3b82f6]">桑梓之家介绍</p>
      </figure>
      <div class="card-body text-md">
        <p>桑梓之家是一个...</p>
      </div>
    </div>

    <!-- 网址导航 -->
    <div class="card w-full h-auto bg-base-100 shadow-xl my-4 py-2 hover:-translate-y-1.5 transition-all	duration-400">
      <figure>
        <p class="text-xl font-bold text-[#3b82f6]">网址导航</p>
      </figure>
      <div class="card-body">
        <div class="mockup-window border bg-base-300 text-md font-bold">
          <div class="px-4 py-2 bg-base-200 flex flex-wrap">
            <p class="m-3">gitlab地址: <a class="link link-info" target="_blank" href="https://git.sends.cc/">https://git.sends.cc/</a></p>
            <p class="m-3">桑梓门禁地址: <a class="link link-info" target="_blank" href="https://access.sends.cc">https://access.sends.cc</a></p>
            <p class="m-3">github地址: <a class="link link-info" target="_blank" href="https://github.com/SendsTeam">https://github.com/SendsTeam</a></p>
             <p class="m-3">桑梓维基库: <a class="link link-info" target="_blank" href="https://wiki.sends.cc/">https://wiki.sends.cc/</a></p>
            <p class="m-3">更多网站,期待你的反馈...</p>
          </div>
        </div>
      </div>
    </div>

    <footer class="footer p-10 bg-base-300 my-3 text-sky-600  hover:-translate-y-1.5 transition-all	duration-400 rounded">
      <nav>
        <h6 class="footer-title">有关链接</h6>
        <a class="link link-hover">
          <div class="dropdown dropdown-top">
            <div tabindex="0" role="button" class="link link-hover">桑梓微助手</div>
            <ul tabindex="0" class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box w-52">
              <img src="@\assets\images\桑梓微助手.png" alt="">
            </ul>
          </div>
        </a>
        <a class="link link-hover" href="https://qm.qq.com/q/tbvSfJhoGe" target="_blank">
          QQ总群(2024)
        </a>
      </nav>
      <nav>
        <h6 class="footer-title">部门群</h6>
        <a class="link link-hover" href="https://qm.qq.com/q/PQ9esYZX6a" target="_blank">研发群(23-24)</a>
      </nav>
      <nav>
        <h6 class="footer-title">更多...</h6>
        <a class="link link-hover">欢迎大家反馈补充</a>
      </nav>
    </footer>

    <Footer></Footer>
  </div>
</template>

<script setup lang="ts">
import { computed, onMounted, ref, watch } from "vue";
import { useUserStore } from "@/stores/index";
import { Announcement } from "@/types/entity";
import { announcementService } from "@/services";
const userStore = useUserStore();

const isLoaded = ref(false);

onMounted(async () => {
  const res = await announcementService.getDefaultAnnouncementApi();
  console.log(res.data);
  if (res.status === 200) {
    userStore.addAnnouncements(res.data as Announcement[]);
    console.log(userStore.announcementList);
    console.log("苏健尧的日志");
    isLoaded.value = true;
  }
});

watch(isLoaded, (newVal) => {
  if (newVal) {
    my_modal_1.showModal();
  }
});
</script>
