<!-- 用户信息修改页面 -->
<!-- 点击后用户跳转的页面 -->
<template>
  <div class="card w-[850px] bg-base-100 shadow-xl p-4 my-4">
    <button class="btn w-[120px] my-4 mx-auto" @click="$router.go(-1)">回到个人主页</button>
    <div class="card-body  font-bold font-serif text-gray-500">

      <el-form ref="ruleFormRef" :model="form" label-width="auto" style="max-width: 600px" class="m-auto w-full">

        <el-form-item v-if="userStore.userInfo.isAdmin === 1">
          <label class="form-control w-full max-w-xs">

            <select class="select select-bordered w-full max-w-xs " v-model="form.department">
              <option value="" disabled>所在部门</option>
              <option value="策划部">策划部</option>
              <option value="研发部">研发部</option>
              <option value="新媒体部">新媒体部</option>
              <option value="设计部">设计部</option>
            </select>
          </label>
        </el-form-item>

        <el-form-item v-if="userStore.userInfo.isAdmin === 1">
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.position">
              <option value="" disabled selected>职位</option>
              <option value="部员">部员</option>
              <option value="部长">部长</option>
              <option value="总负责人">总负责人</option>
              <option value="老师">老师</option>
            </select>
          </label>
        </el-form-item>

        <el-form-item v-if="userStore.userInfo.isAdmin === 1">
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.isAdmin">
              <option value="0">用户</option>
              <option value="1">管理员</option>
            </select>
          </label>
        </el-form-item>

        <el-form-item>
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.gender">
              <option value="1">男</option>
              <option value="0">女</option>
            </select>
          </label>
        </el-form-item>

        <el-form-item>
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.school">
              <option value="厦门" selected>厦门</option>
              <option value="泉州">泉州</option>
            </select>
          </label>
        </el-form-item>


        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            年级:
            <input v-model="form.session" type="text" class="grow" placeholder="如:2022" />
          </label>
        </el-form-item>

        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            专业 :
            <input v-model="form.major" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            手机号 :
            <input v-model="form.phone" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            qq :
            <input v-model="form.qq" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            微信号 :
            <input v-model="form.weChat" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            邮箱 :
            <input v-model="form.email" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-1 w-full ">
            学号 or 教师号:
            <input v-model="form.userId" type="text" class="grow" />
          </label>
        </el-form-item>
        <el-form-item>
          <h2 class="card-title">个性签名 </h2>
          <textarea v-model="form.signature" placeholder="个性签名" class="block min-h-15 w-full max-h-20 textarea textarea-bordered">

          </textarea>
        </el-form-item>
        <el-form-item>
          <h2 class="card-title">介绍 </h2>
          <textarea v-model="form.introduction" placeholder="介绍一下自己吧,让大家认识你" class="block text-x  min-h-40 w-full max-h-60 textarea textarea-bordered">
          </textarea>
        </el-form-item>

        <el-form-item v-if="userStore.userInfo.isAdmin === 1">
          <h2 class="card-title">成员评价 </h2>
          <textarea v-model="form.reviews" placeholder="介绍一下自己吧,让大家认识你" class="block text-x  min-h-40 w-full max-h-60 textarea textarea-bordered">
          </textarea>
        </el-form-item>

        <el-form-item>
          <button class="btn w-[100px]  bg-slate-300" @click.prevent="admit()">保存</button>
        </el-form-item>
      </el-form>
    </div>
  </div>

  <div>

  </div>

</template>

<script lang="ts" setup>
import { onMounted, reactive, ref } from "vue";

import { ElMessage, ElMessageBox } from "element-plus";

import { useUserStore } from "@/stores/index";
const userStore = useUserStore();
const route = useRoute();
const userInfo = route.params as User;

onMounted(() => {
  console.log(userStore.userInfo.isAdmin);
  console.log(typeof userStore.userInfo.isAdmin);
});
// 表单
const form = reactive({
  department: userInfo.department || "保密哟",
  position: userInfo.position || "保密哟",
  session: parseInt(userInfo.session),
  major: userInfo.major || "保密哟",
  phone: userInfo.phone || "保密哟",
  qq: userInfo.qq || "保密哟",
  weChat: userInfo.weChat || "保密哟",
  gender: parseInt(userInfo.gender),
  userId: userInfo.userId || "保密哟",
  signature: userInfo.signature || "保密哟",
  introduction: userInfo.introduction || "保密哟",
  school: userInfo.school || "保密哟",
  email: userInfo.email || "保密哟",
  isAdmin: userInfo.isAdmin,
  reviews: userInfo.reviews || "保密哟",
});

import { userService } from "@/services";
import { User } from "@/types/entity";
import { useRoute } from "vue-router";

function formatForm() {
  form.userId = form.userId.trim();
  form.major = form.major.trim();
  form.department = form.department.trim();
  form.position = form.position.trim();
  form.reviews = form.reviews.trim();
  form.school = form.school.trim();
  form.phone = form.phone.trim();
  form.qq = form.qq.trim();
  form.weChat = form.weChat.trim();
  form.signature = form.signature.trim();
  form.introduction = form.introduction.trim();
  form.email = form.email.trim();
}

async function admit() {
  ElMessageBox.confirm("确定要保存吗,一天只能修改五次哦", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(async () => {
      formatForm();
      console.log("userInfo", userInfo);
      const res = await userService.updateUserApi({
        ...userInfo,
        ...form,
      } as User);
      if (res.status === 200) {
        userStore.setUserInfo({
          ...userInfo,
          ...form,
        } as User);
        console.log("userInfo", {
          ...userInfo,
          ...form,
        } as User);
        ElMessage({
          type: "success",
          dangerouslyUseHTMLString: true,
          message: "<h3 class='text-base'>信息修改成功了!</h3>",
        });
      } else {
        ElMessage({
          message: "信息修改失败了,主人",
          type: "error",
        });
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
</script>