<template>
  <div v-if="isLoading === true">
    <div class="dropdown  dropdown-hover">
      <div tabindex="0" role="button" class="btn m-1">年份</div>
      <ul tabindex="0" class="dropdown-content z-[1] menu p-2 shadow bg-base-100 rounded-box w-52 max-h-64 overflow-auto">
        <li>
          <div @click="() => { display_all = true;  console.log(display_all)}">
            所有成员
          </div>
        </li>
        <li v-for="(item,index) in yearOptions" :key="index">
          <div @click="changeYear(item)">{{ item }}</div>
        </li>
      </ul>
    </div>

    <div v-for="(items,index) in processed_res" :key="index">

      <!-- 卡片 -->
      <div class=" bg-base-100 shadow-xl  p-4 my-3" v-if="items[0].session === selectedYear || display_all">

        <h2 class=" font-bold text-lg mb-4">{{ items[0].session }}</h2>
        <div class="flex flex-wrap">
          <div v-for="(item ,index) in items" :key="index">
            <!-- 部员 -->
            <div class=" w-[100px] h-auto block text-center  shadow-xl m-2 py-2 rounded-md  brightness-95 hover:-translate-y-1.5 transition-all	duration-400	cursor-pointer " @click="pushToUser(item)" :class=" { 'bg-sky-300':  item.gender === 1,  'bg-pink-200': item.gender === 0 }">
              <div class="avatar">
                <div class="w-20 rounded-full">
                  <img src="@/assets/images/默认头像.svg" />
                </div>
              </div>
              <div class="">
                <div class=" block badge badge-primary my-1 mx-auto">{{ item.department  }}</div>
                <div class="block badge badge-accent my-1 mx-auto">{{ item.name }} </div>
                <div class="block badge badge-ghost my-1 mx-auto">{{ item.session }}</div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>

  </div>
  <div v-else class="flex justify-center items-center h-full">
    <span class="loading loading-spinner loading-lg"></span>
  </div>
  <Footer></Footer>
</template>

<script setup lang="ts">
import { userService } from "@/services";
import { User } from "@/types/entity";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
onMounted(() => {});

// 学生假数据
const display_all = ref<Boolean>(true);
const selectedYear = ref<Number>();
const yearOptions = ref([]);
function changeYear(year: Number) {
  display_all.value = false;
  selectedYear.value = year;
}
// 学生假数据
onMounted(() => {
  const currentYear = new Date().getFullYear();
  selectedYear.value = currentYear;
  for (let i = currentYear; i >= 2020; i--) {
    yearOptions.value.push(i);
  }
});

const processed_res = ref<User[]>([]);

// 对不同的年份进行分组
const sortData = (sortData: User) => {
  const groupBy = (array, f) => {
    let groups = {};
    array.forEach((o) => {
      let group = JSON.stringify(f(o));
      groups[group] = groups[group] || [];
      groups[group].push(o);
    });
    return Object.keys(groups).map((group) => {
      return groups[group];
    });
  };
  const sorted = groupBy(sortData, (item) => {
    return item.session; // 返回需要分组的对象
  });
  return sorted;
};

const isLoading = ref<Boolean>(false);
onMounted(async () => {
  const res = await userService.getDepartmentUserDataApi("研发部");
  if (res.status === 200) {
    console.log(res.data);
    processed_res.value = sortData(res.data);
    isLoading.value = true;
    console.log(processed_res.value);
  }
});

// 跳转到用户详细界面
function pushToUser(user: User) {
  router.push({
    name: "user",
    // 传递参数,不在路径中显示
    params: {
      id: user.id,
      gender: user.gender,
      name: user.name || "保密哦",
      department: user.department || "保密哦",
      position: user.position || "保密哦",
      session: user.session || 0,
      major: user.major || "保密哦",
      phone: user.phone || "保密哦",
      email: user.email || "保密哦",
      qq: user.qq || "保密哦",
      weChat: user.weChat || "保密哦",
      userId: user.userId || "保密哦",
      school: user.school || "保密哦",
      signature: user.signature || "保密哟",
      introduction: user.introduction || "保密哟",
    },
  });
}
</script>