<template>
  <div>

    <!-- 公告 -->
    <div class="card w-2/3 bg-base-100 shadow-xl p-4 my-4">
      <h2 class=" font-bold text-lg mb-4">公告</h2>
      <button class="btn w-[100px]  bg-slate-300" @click.prevent="announcementAdmit()">提交公告</button>
      <div class="card-body  font-bold font-serif text-gray-500">
        <h2 class="card-title">填写公告</h2>
        <textarea v-model="announcement" class="block text-x min-h-40 w-full max-h-60 textarea textarea-bordered" placeholder="公告..."></textarea>
      </div>
    </div>

    <!-- 新增日志 -->
    <div class="card w-2/3 bg-base-100 shadow-xl p-4 my-4">
      <h2 class=" font-bold text-lg mb-4">日志</h2>
      <button class="btn w-[100px]  bg-slate-300" @click="logAdmit">日志提交</button>
      <div class="card-body  font-bold font-serif text-gray-500">
        <h2 class="card-title">填写日志</h2>
        <textarea v-model="log" class="block text-x min-h-40 w-full max-h-60 textarea textarea-bordered" placeholder="日志..."></textarea>
      </div>

    </div>

    <!-- 添加成员 -->
    <div class="card w-2/3 bg-base-100 shadow-xl p-4 my-4">
      <h2 class=" font-bold text-lg mb-4">添加成员</h2>

      <el-form ref="ruleFormRef" :model="form" label-width="auto" style="max-width: 600px" class="m-auto w-full">
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full ">
            <input v-model="form.name" type="text" class="grow" placeholder="姓名" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full ">
            <input v-model="form.userId" type="text" class="grow" placeholder="学号 or 教师号:" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full ">
            <input v-model="form.session" type="text" class="grow" placeholder="年级,如: 2022" />
          </label>
        </el-form-item>
        <el-form-item>
          <label class="input input-bordered flex items-center gap-2 w-full ">
            <input v-model="form.major" type="text" class="grow" placeholder="专业,如: 软件工程" />
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
              <option value="厦门">厦门</option>
              <option value="泉州">泉州</option>
            </select>
          </label>

        </el-form-item>
        <el-form-item>
          <label class="form-control w-full max-w-xs">

            <select class="select select-bordered w-full max-w-xs " v-model="form.department">
              <option value="" disabled selected>所在部门</option>
              <option value="策划部">策划部</option>
              <option value="研发部">研发部</option>
              <option value="新媒体部">新媒体部</option>
              <option value="设计部">设计部</option>
            </select>
          </label>

        </el-form-item>
        <el-form-item>
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

        <el-form-item>
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.isIn">
              <option value="0">已离位</option>
              <option value="1" disabled selected>在位</option>
            </select>
          </label>
        </el-form-item>

        <el-form-item>
          <label class="form-control w-full max-w-xs">
            <select class="select select-bordered w-full max-w-xs " v-model="form.isAdmin">
              <option value="0">用户</option>
              <option value="1">管理员</option>
            </select>
          </label>
        </el-form-item>
        <el-form-item>
          <textarea v-model="form.reviews" class="block text-x min-h-40 w-full max-h-60 textarea textarea-bordered " placeholder="成员评价"></textarea>
        </el-form-item>
        <el-form-item>
          <button class="btn w-[100px]  bg-slate-300" @click.prevent="userAdmit()">提交</button>
        </el-form-item>
      </el-form>

    </div>

  </div>
  <Footer></Footer>
</template>

<script lang="ts" setup>
import { ElMessage, ElMessageBox } from "element-plus";
import { reactive, ref } from "vue";

import { announcementService, logService, userService } from "@/services";
import { Announcement, Log, User } from "@/types/entity";
import { useUserStore } from "@/stores";
import { stringify } from "querystring";
const userStore = useUserStore();

// interface FormState {
//   name: string;
//   session: number;
//   major: string;
//   gender: number;
//   department: string;
//   position: string;
//   isIn: 0 | 1;
//   isAdmin: 0 | 1;
//   reviews: string;
// }

// 表单
const form = reactive({
  name: "",
  userId: "",
  session: new Date().getFullYear(),
  major: "",
  gender: 1,
  department: "",
  position: "部员",
  isIn: 1,
  isAdmin: 0,
  password: "sends",
  reviews: "",
  school: "厦门",
});

// 公告字段
const announcement = ref("");

// 公告信息提交
const announcementAdmit = () => {
  ElMessageBox.confirm("确定要提交吗", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(async () => {
      const res = await announcementService.addAnnouncementApi({
        content: announcement.value,
      } as Announcement);
      console.log(res);
      if (res.status === 200) {
        const res = await announcementService.getDefaultAnnouncementApi();
        if (res.status === 200) {
          console.log(res.status);
          userStore.addAnnouncements(res.data as Announcement[]);
          console.log(userStore.announcementList);
        }
        announcement.value = "";
        // userStore.addAnnouncement(res.data);
        console.log(res.data);
        ElMessage({
          type: "success",
          message: "提交成功了哟",
        });
      } else {
        ElMessage({
          type: "error",
          message: "哎呀,好像出错了,再试一次吧!",
        });
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "取消了哟",
      });
    });
};

// 日志字段
const log = ref("");
//日志信息提交
const logAdmit = () => {
  ElMessageBox.confirm("确定要提交吗", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(async () => {
      const res = await logService.addLogApi({
        content: log.value,
      } as Log);
      console.log(res);
      if (res.status === 200) {
        console.log("苏健尧的公告");
        const res = await logService.getLogsApi();
        if (res.status === 200) {
          userStore.addLogs(res.data as Log[]);
          console.log(userStore.logList);
        }
        log.value = "";
        // 这个不要
        // userStore.addLog(res.data);
        ElMessage({
          type: "success",
          message: "提交成功了哟",
        });
      } else {
        ElMessage({
          type: "error",
          message: "哎呀,好像出错了",
        });
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "取消了哟",
      });
    });
};

// 清除表单
function clearForm() {
  form.name = "";
  form.session = new Date().getFullYear();
  form.major = "";
  form.gender = 1;
  form.department = "";
  form.position = "部员";
  form.isIn = 1;
  form.isAdmin = 0;
  form.reviews = "";
  form.userId = "";
}
function formatForm() {
  form.name = form.name.trim();
  form.userId = form.userId.trim();
  form.major = form.major.trim();
  form.department = form.department.trim();
  form.position = form.position.trim();
  form.reviews = form.reviews.trim();
  form.password = form.password.trim();
  form.school = form.school.trim();
}

//成员信息提交
const userAdmit = () => {
  ElMessageBox.confirm("确定要提交吗", {
    cancelButtonText: "不要",
    confirmButtonText: "是滴",
    type: "info",
  })
    .then(async () => {
      formatForm()
      const res = await userService.addUserApi({
        ...form,
      } as User);
      if (res.status === 200) {
        log.value = "";
        clearForm();
        // 这个不要
        // userStore.addLog(res.data);
        ElMessage({
          type: "success",
          message: "提交成功了哟",
        });
      } else {
        ElMessage({
          type: "error",
          message: "哎呀,好像出错了",
        });
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "取消了哟",
      });
    });
};
</script>