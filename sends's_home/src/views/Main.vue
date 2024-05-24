<template>
  <section class="w-[100vw] h-[100vh] bg-base-100 flex flex-wrap overflow-hidden min-w-[1080px]">
    <!-- 顶部展示栏 -->
    <section class="w-full h-[50px]  select-none  ">
      <div class="w-[250px] h-full  float-start  text-2xl font-bold text-blue-500 text-center leading-[50px] ">
        <router-link to="/" class=" flex flex-wrap px-10">
          <img class="w-[50px] h-[50px] rounded-full"  src="@/assets/images/默认头像.svg" />
          <p>桑梓之家</p>
        </router-link>

      </div>

      <h2 v-if="userStore.isLogin === true" class=" font-bold text-lg leading-[50px] float-start mx-5">你好呀,{{userStore.userInfo.name}}</h2>
      <ul class="h-full  float-end flex font text-lg hover:cursor-pointer gap-1 my-1">

        <!-- 主题切换 -->
        <li :class="{ 'mx-4': userStore.isLogin === false }" class="px-2 py-1 h-full leading-[50px] tooltip tooltip-bottom  border-r-black" data-tip="主题切换">
          <label class="swap swap-rotate">
            <input type="checkbox" @click="toggleTheme" />
            <svg class="swap-on fill-current w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
              <path d="M21.64,13a1,1,0,0,0-1.05-.14,8.05,8.05,0,0,1-3.37.73A8.15,8.15,0,0,1,9.08,5.49a8.59,8.59,0,0,1,.25-2A1,1,0,0,0,8,2.36,10.14,10.14,0,1,0,22,14.05,1,1,0,0,0,21.64,13Zm-9.5,6.69A8.14,8.14,0,0,1,7.08,5.22v.27A10.15,10.15,0,0,0,17.22,15.63a9.79,9.79,0,0,0,2.1-.22A8.11,8.11,0,0,1,12.14,19.73Z" />
            </svg>
            <svg class="swap-off fill-current w-10 h-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
              <path d="M5.64,17l-.71.71a1,1,0,0,0,0,1.41,1,1,0,0,0,1.41,0l.71-.71A1,1,0,0,0,5.64,17ZM5,12a1,1,0,0,0-1-1H3a1,1,0,0,0,0,2H4A1,1,0,0,0,5,12Zm7-7a1,1,0,0,0,1-1V3a1,1,0,0,0-2,0V4A1,1,0,0,0,12,5ZM5.64,7.05a1,1,0,0,0,.7.29,1,1,0,0,0,.71-.29,1,1,0,0,0,0-1.41l-.71-.71A1,1,0,0,0,4.93,6.34Zm12,.29a1,1,0,0,0,.7-.29l.71-.71a1,1,0,1,0-1.41-1.41L17,5.64a1,1,0,0,0,0,1.41A1,1,0,0,0,17.66,7.34ZM21,11H20a1,1,0,0,0,0,2h1a1,1,0,0,0,0-2Zm-9,8a1,1,0,0,0-1,1v1a1,1,0,0,0,2,0V20A1,1,0,0,0,12,19ZM18.36,17A1,1,0,0,0,17,18.36l.71.71a1,1,0,0,0,1.41,0,1,1,0,0,0,0-1.41ZM12,6.5A5.5,5.5,0,1,0,17.5,12,5.51,5.51,0,0,0,12,6.5Zm0,9A3.5,3.5,0,1,1,15.5,12,3.5,3.5,0,0,1,12,15.5Z" />
            </svg>

          </label>
        </li>

        <!-- 反馈 -->
        <li v-if="userStore.isLogin === true && userStore.userInfo.isAdmin === 1" class="px-2 h-full leading-[50px] tooltip tooltip-bottom " data-tip="你的反馈,是我的动力">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 48 48" class=" h-[90%] ">
            <path stroke-linejoin="round" stroke-linecap="round" stroke-width="3" stroke="#333" d="M24.707 9.565 9.858 24.415a9 9 0 0 0 0 12.727v0a9 9 0 0 0 12.728 0l17.678-17.677a6 6 0 0 0 0-8.486v0a6 6 0 0 0-8.486 0L14.101 28.657a3 3 0 0 0 0 4.243v0a3 3 0 0 0 4.242 0l14.85-14.85" data-follow-stroke="#333" />
          </svg>
        </li>
        <!-- 头像 -->

        <li v-if="userStore.isLogin === true" class="px-4 mr-8 h-full leading-[50px] tooltip ">
          <div class="dropdown  dropdown-end dropdown-hover">
            <div tabindex="0" class="avatar  ">
              <div class="w-11 m-auto  z-10 rounded-full ">
                <img src="https://access.sends.cc/sends.svg" />
              </div>
            </div>
            <ul tabindex="0" class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box w-52">
              <li><router-link to="/my">个人信息</router-link></li>
              <li @click="Logout()"><a>登出</a></li>
            </ul>
          </div>
        </li>

      </ul>
    </section>

    <!-- 侧边导航栏 -->
    <section v-if="userStore.isLogin === true" class="w-[250px] h-[calc(100vh-50px)]  relative border-e-2 border-gray-300 select-none ">
      <div class="px-4 text-gray-600 font-bold">
        <ul>
          <p class=" mt-1 text-sm text-gray-400 ">主页</p>
          <li>
            <router-link :style="route.path === '/' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200 px-2 rounded my-1 flex" to="/">
              主页
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/announcement' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200 px-2 rounded my-1 flex" to="/announcement">
              历史公告
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/log' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 rounded my-1 flex" to="/log">
              更新日志
            </router-link>
          </li>

          <p class=" mt-1 text-sm text-gray-400">部门</p>
          <li>
            <router-link :style="route.path === '/all' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 my-1 rounded flex" to="/all">
              所有成员
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/plan' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 my-1 rounded flex" to="/plan">
              策划部
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/produce' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 my-1 rounded flex" to="/produce">
              研发部
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/NewMedia' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 my-1 rounded flex" to="/NewMedia">
              新媒体部
            </router-link>
          </li>
          <li>
            <router-link :style="route.path === '/art' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 rounded my-1 flex" to="/art">
              设计部
            </router-link>
          </li>
          <p class=" mt-1 text-sm text-gray-400">我的</p>
          <li>
            <router-link :style="route.path === '/my' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 rounded my-1 flex" to="/my">
              个人中心
            </router-link>
          </li>
          <li v-if="userStore.userInfo.isAdmin === 1">
            <router-link :style="route.path === '/admin' ? 'background-color:#bfdbfe' : ''" class="h-[40px] leading-[40px] hover:bg-blue-200  px-2 rounded my-1 flex" to="/admin">
              管理中心
            </router-link>
          </li>

        </ul>
      </div>

    </section>

    <!-- 主要内容 -->
    <section v-if="userStore.isLogin === true" class=" w-[calc(100%-250px)] h-[calc(100vh-50px)] px-14 py-10 overflow-auto ">
      <router-view></router-view>
    </section>

    <section v-else class=" w-full h-[calc(100vh-50px)] px-14 py-10 overflow-auto ">
      <router-view></router-view>
    </section>

  </section>

</template>

<script setup lang="ts">
import { onMounted, ref, watch } from "vue";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores/index";
import router from "@/router";
import { ElMessage, ElMessageBox } from "element-plus";
const userStore = useUserStore();
// 当前的主题
const currentTheme = ref(localStorage.getItem("theme") || "autumn");
function toggleTheme() {
  currentTheme.value = currentTheme.value === "autumn" ? "retro" : "autumn";
  document.documentElement.setAttribute("data-theme", currentTheme.value);
  localStorage.setItem("theme", currentTheme.value);
}

onMounted(() => {
  document.documentElement.setAttribute("data-theme", currentTheme.value);
});

// 监听路由变化, 并打印当前路由
const route = useRoute();
watch(
  () => route.path,
  (newValue, oldValue) => {
    console.log(newValue);
  }
);

// 退出登录
function Logout() {
  ElMessageBox.confirm("确定要退出吗", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(() => {
      userStore.Logout();
      userStore.setToken("");
      router.push({
        name: "login",
      });
      ElMessage({
        type: "success",
        message: "退出了哟",
      });
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "取消了哟",
      });
    });
}
</script>