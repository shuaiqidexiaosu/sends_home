<template>
  <div>
    <!-- 个人信息展示 -->
    <div class="card xl:w-4/5 lg:w-full bg-base-100 shadow-xl p-4 my-4">
      <button class="btn " @click="pushToEditPage()">信息修改</button>
      <div class=" flex flex-wrap my-">
        <div class="avatar mx-5 my-8">
          <div class="w-28 rounded-full  ">
            <img src="@/assets/images/默认头像.svg" />
          </div>
        </div>

        <div class="m-4">
          <h2 class="card-title">{{ userInfo.name || "保密哟"}} </h2>
          <div class="flex flex-wrap base-300 font-bold	gap-2 ">
            <div class="mr-3 mb-2 badge badge-primary badge-outline p-3">所在部门: {{userInfo.department || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge badge-accent  badge-outline p-3">职位: {{userInfo.position || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge badge-outline p-3">年级: {{ userInfo.session || "保密哟" }}</div>
            <div class="mr-3 mb-2 badge badge-primary badge-outline p-3">专业: {{ userInfo.major || "保密哟" }}</div>
          </div>
          <div class="flex flex-wrap base-300 font-bold	">
            <div class="mr-3 mb-2 badge badge-primary badge-outline p-3">手机号: {{ userInfo.phone || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge badge-accent  badge-outline p-3">QQ号: {{ userInfo.qq || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge badge-outline p-3">微信号: {{ userInfo.weChat || "保密哟"}}</div>

          </div>
          <div class="flex flex-wrap base-300 font-bold	">
            <div class="mr-3 mb-2 badge  badge-outline p-3">邮箱: {{ userInfo.email || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge badge-primary badge-outline p-3">学号 or 教师号: {{  userInfo.userId || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge  badge-outline p-3">校区: {{ userInfo.school || "保密哟"}}</div>
            <div class="mr-3 mb-2 badge  badge-outline p-3">性别: {{  userInfo.gender === 1 ? "男" : "女" || "保密哟"}}</div>
          </div>
        </div>

      </div>
      <div class="card-body  font-bold font-serif text-gray-500">

        <h2 class="card-title">个性签名 </h2>
        <textarea v-model="userInfo.signature " class="block  textarea-info  min-h-15 w-full max-h-20 textarea textarea-bordered" placeholder="我的介绍..." disabled>
          </textarea>
        <h2 class="card-title">介绍 </h2>
        <textarea v-model="userInfo.introduction " class="block text-x textarea-info  min-h-40 w-full max-h-60 textarea textarea-bordered" placeholder="自己的介绍..." disabled>
          </textarea>
      </div>
    </div>

    <!-- 密码修改 -->
    <div class="card  xl:w-4/5 lg:w-full bg-base-100 shadow-xl p-4 my-4">
      <h2 class="card-title ms-20">密码修改 </h2>
      <el-form action="" :model="form" class="w-4/5 flex flex-col gap-4 m-auto my-4">
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full">
            <input v-model="form.oldPwd" type="password" class="grow" placeholder="旧密码" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full">
            <input v-model="form.newPwd" type="password" class="grow" placeholder="新密码" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full">
            <input v-model="form.confirmPwd" type="password" class="grow" placeholder="再输一次" />
          </label>
        </el-form-item>

        <el-form-item>
          <button class="btn btn-neutral" @click.prevent="keep()">保存</button>
        </el-form-item>

      </el-form>
    </div>

  </div>
  <Footer></Footer>
</template>

<script lang="ts" setup>
import { ElMessage, ElMessageBox } from "element-plus";
import { useRouter } from "vue-router";

import { useUserStore } from "@/stores/index";
import { userService } from "@/services";
import { reactive } from "vue";

const userStore = useUserStore();
const userInfo = userStore.userInfo;
const router = useRouter();

const form = reactive({
  oldPwd: "",
  newPwd: "",
  confirmPwd: "",
});

// 密码校验
function verifyPwd() {
  if (
    form.oldPwd.trim() === "" ||
    form.newPwd.trim() === "" ||
    form.confirmPwd.trim() === ""
  ) {
    ElMessage({
      message: "密码不能为空哦",
      type: "error",
    });
    return false;
  } else if (form.oldPwd !== userInfo.password) {
    ElMessage({
      message: "旧密码不正确哦",
      type: "error",
    });
    return false;
  } else if (form.oldPwd.trim() === form.newPwd.trim()) {
    ElMessage({
      message: "新密码不能与旧密码相同哦",
      type: "error",
    });
    return false;
  } else if (form.newPwd !== form.confirmPwd.trim()) {
    ElMessage({
      message: "两次密码不一致哦",
      type: "error",
    });
    return false;
  }
  return true;
}

// 保存密码
async function keep() {
  if (!verifyPwd()) {
    return;
  }
  ElMessageBox.confirm("确定要保存吗,一天只能修改三次哦", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(async () => {
      const res = await userService.updateUserApi({
        id: parseInt(userInfo.id),
        password: form.newPwd.trim(),
      });
      if (res.status === 200) {
        console.log(res);
        userStore.setUserInfo({
          ...userStore.userInfo,
          password: form.newPwd.trim(),
        });
        form.oldPwd = "";
        form.newPwd = "";
        form.confirmPwd = "";
        ElMessage({
          type: "success",
          dangerouslyUseHTMLString: true,
          message: "<h3 class='text-base'>密码修改成功!<h3>",
        });
      } else {
        ElMessage({
          message: "学号或密码不对哟",
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

// 跳转编辑页面
function pushToEditPage() {
  console.log(userInfo);
  router.push({
    name: "myInfoEdit",
    params: {
      id: userInfo.id || "保密哟",
      name: userInfo.name || "保密哟",
      department: userInfo.department || "保密哟",
      position: userInfo.position || "保密哟",
      session: userInfo.session || "保密哟",
      major: userInfo.major || "保密哟",
      phone: userInfo.phone || "保密哟",
      qq: userInfo.qq || "保密哟",
      weChat: userInfo.weChat || "保密哟",
      email: userInfo.email || "保密哟",
      userId: userInfo.userId || "保密哟",
      school: userInfo.school || "保密哟",
      gender: userInfo.gender,
      isAdmin: userInfo.isAdmin || 0,
      reviews: userInfo.reviews || "保密哟",
      signature: userInfo.signature || "保密哟",
      introduction: userInfo.introduction || "保密哟",
    },
  });
}
</script>