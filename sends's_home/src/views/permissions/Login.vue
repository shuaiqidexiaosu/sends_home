<!-- 点击后用户跳转的页面 -->
<template>
  <div class="relative  h-full ">

    <!-- 个人信息展示 -->
    <div class="absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-3/4 card lg:w-1/2 md:w-full  bg-base-100 shadow-2xl py-4 ">
      <div class="text-center">
        <h2 class="card-title  inline">登陆</h2>
      </div>

      <div class="card-body  font-bold font-serif text-gray-500 items-center text-center">
        <el-form :model="form" label-width="auto" style="max-width: 600px" class="m-auto w-full">
          <el-form-item>
            <label class="input input-bordered flex items-center gap-1 w-full ">
              学号 or 教师号:
              <input type="text" class="grow" v-model="form.userId" />
            </label>
          </el-form-item>

          <el-form-item>
            <label class="input input-bordered flex items-center gap-1 w-full ">
              密码 :
              <input type="password" class="grow" v-model="form.password" />
            </label>
          </el-form-item>

          <el-form-item class="flex justify-center items-center">
            <button class="btn w-[100px] " @click.prevent="Login()">登陆</button>
          </el-form-item>
        </el-form>

      </div>
    </div>
  </div>

</template>

<script lang="ts" setup>
import { onMounted, reactive } from "vue";
import { userService } from "@/services";
import { ElMessage } from "element-plus";


import { useUserStore } from "@/stores/index";
import { useRouter } from "vue-router";
const router = useRouter()
const userStore = useUserStore();

const form = reactive({
  userId: "",
  password: "",
});
onMounted(() => {
  if (userStore.isLogin === true) {
    router.push({
      name:"home"
    })
  }
});
// 跳转到编辑页面
async function Login() {
  if (form.userId.trim() === "" || form.password.trim() === "") {
    ElMessage({
      message: "学号和密码不能为空哦",
      type: "error",
    });
    return;
  }
  const res = await userService.loginApi(form);
  if (res.status === 200) {
    // console.log(res);
    userStore.Login();
    userStore.setToken(res.token);
    userStore.setUserInfo(res.data);
    console.log(userStore.userInfo);
    ElMessage({
      message: `你好呀${userStore.userInfo.name},欢迎来到桑梓之家`,
      type: "success",
    });
  } else {
    ElMessage({
      message: "学号或密码不对哟",
      type: "error",
    });
    console.log("登陆失败");
    return;
  }
}
</script>