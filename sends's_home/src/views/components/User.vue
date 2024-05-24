<!-- 点击后用户跳转的页面 -->
<template>
  <div>
    <!-- 个人信息展示 -->
    <div class="card xl:w-4/5 lg:w-full min:w-[1080px] bg-base-100 shadow-xl p-4 my-4">
      <div>
        <button class="btn " @click="$router.go(-1)">回到原页面</button>
        <button v-if="userStore.userInfo.isAdmin ===  1" class="btn btn-error float-right" @click="deleteUser()">删除成员</button>
        <button v-if="userStore.userInfo.isAdmin ===  1" class="btn  float-right mx-2" @click="pushToEditPage()">信息修改</button>
      </div>

      <div class=" flex flex-wrap my-4">
        <div class="avatar mx-5 py-6">
          <div class="w-28 rounded-full ">
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
            <div class="mr-3 mb-2 badge  badge-outline p-3">性别: {{ userInfo.gender === '1' ? "男" : "女" }}</div>
          </div>
        </div>

      </div>
      <div class="card-body  font-bold font-serif text-gray-500">

        <h2 class="card-title">个性签名 </h2>
        <textarea v-model="userInfo.signature" class="block  textarea-info  min-h-15 w-full max-h-20 textarea textarea-bordered" placeholder="你自己的介绍..." disabled>

          </textarea>
        <h2 class="card-title">介绍 </h2>
        <textarea v-model="userInfo.introduction" class="block text-x textarea-info  min-h-40 w-full max-h-60 textarea textarea-bordered" placeholder="自己的介绍..." disabled>
          </textarea>
      </div>
    </div>
  </div>

</template>

<script lang="ts" setup>
import { userService } from "@/services";
import { useUserStore } from "@/stores";
import { User } from "@/types/entity";
import { ElMessage, ElMessageBox } from "element-plus";
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();

const route = useRoute();
const userInfo = route.params as User;
const userStore = useUserStore();
onMounted(() => {
  console.log(userStore.userInfo);
  console.log("userInfo", userInfo);
  console.log(userInfo.gender)
});

async function deleteUser() {
  ElMessageBox.confirm("确定要删除该成员吗？", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "error",
  })
    .then(async () => {
      const res = await userService.deleteUserApi(userInfo.id);
      if (res.status === 200) {
        ElMessage({
          type: "success",
          dangerouslyUseHTMLString: true,
          message: "<h3 class='text-base'>成员已经删除!</h3>",
        });
      } else {
        ElMessage({
          message: "成员删除失败了,主人",
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
// 跳转到编辑页面
function pushToEditPage() {
  router.push({
    name: "userInfoEdit",
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
      gender: parseInt(userInfo.gender),
      isAdmin: userInfo.isAdmin || 0,
      reviews: userInfo.reviews || "保密哟",
      signature: userInfo.signature || "保密哟",
      introduction: userInfo.introduction || "保密哟",
    },
  });
}
</script>