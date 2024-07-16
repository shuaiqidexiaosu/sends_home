## 桑梓之家项目文档

**你的star 对我很重要, 谢谢**

#### 项目运行
##### 前端 (推荐用 pnpm 作为包管理工具)
**pnpm 的好处** : [pnpm的优势](https://juejin.cn/post/7231742100844724280)
```js
pnpm i

pnpm run dev
```
##### 后端
1. 记得将生产环境切换为开发环境 (将 appliaction. yml 里的 prod 更换为 dev )
#### 项目功能
1. 为管理桑梓成员以及往届项目成员的信息, 使得每位成员能够及时的修改自己的信息, 并且能够更加方便的通过桑梓之家认识到其他人
2. **项目展示网址**: https://sends-home.sends.cc/

#### 项目技术栈
##### 前端
vue + vite, ts,  axios, tailwind. css, vue-router, daysiui, element-plus, 等
##### 后端
java+ springboot, swagger (接口文档), mybatisplus, mysql, redis, 等

#### 项目结构介绍
1. back_end: 为 springboot 后端项目
2. sends's_home: 为前端入口
3. sends_home. sql: 为后端 mysql 数据文件, 连接数据库的时候记得导入
4. 后端项目导入 idea 前, 记得谨慎修改自己的 springboot 版本号, 因为这可能会导致 maven 版本的不同造成的依赖错误
5. 前端
#### 项目展示图
登陆界面
![Pasted image 20240604100204](https://github.com/shuaiqidexiaosu/sends_home/assets/111214331/7e4888bd-30a1-4729-9967-db48f82ab246)
主页, [注意: 这里做了一定的鉴权功能,管理中心以及其他功能非管理员不能查看]
![Pasted image 20240604101237](https://github.com/shuaiqidexiaosu/sends_home/assets/111214331/77fab958-02e4-4da0-8f1c-0afb9de476a0)
桑梓成员页面
![Pasted image 20240604101314](https://github.com/shuaiqidexiaosu/sends_home/assets/111214331/3b201e04-97b0-4bc5-b51b-50f66b2169c3)

个人中心
![Pasted image 20240604101510](https://github.com/shuaiqidexiaosu/sends_home/assets/111214331/5dd5794e-e5a3-4001-9443-e81a50b5f8e5)

管理中心
![Pasted image 20240604101414](https://github.com/shuaiqidexiaosu/sends_home/assets/111214331/a1b2cdf8-de72-4d89-b68a-44cc9b04646b)
