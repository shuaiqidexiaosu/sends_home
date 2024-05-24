/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : sends_home

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 24/05/2024 15:42:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `time` datetime NULL DEFAULT NULL,
  `year` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (4, '你好呀,桑梓', '2024-05-23 09:32:10', 2024);
INSERT INTO `announcement` VALUES (6, '桑梓之家项目上线', '2024-05-23 21:03:25', 2024);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '日志内容',
  `time` datetime NULL DEFAULT NULL COMMENT '时间',
  `year` int NULL DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (4, '完成项目的全部内容', '2024-05-23 09:23:31', 2024);
INSERT INTO `log` VALUES (7, '项目部署成功', '2024-05-24 15:10:15', 2024);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'uuid',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '学号或老师的教师号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '专业',
  `gender` int NULL DEFAULT NULL COMMENT '性别(0: 女, 1: 男)',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '部门(0: 策划, 1: 研发, 2: 新媒体, 3: 美工部)',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '岗位(0: 待加入, 1: 部员, 2: 部长, 3: 总负责人, 4: 老师)',
  `session` int NULL DEFAULT NULL COMMENT '第几届的,如: 2022',
  `is_in` int NULL DEFAULT NULL COMMENT '是否在职位(0: 不在, 1: 在)',
  `is_admin` int NULL DEFAULT NULL COMMENT '是否为管理员(0: 否, 1: 是)',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `weChat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信号',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
  `introduction` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '自己说的话',
  `reviews` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '面试时成员备注',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '校区',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2025103008', '冯鑫', 'sends', '计算机类', 1, '策划部', '部员', 2020, 1, 0, '18959218040', '保密哦', NULL, '保密哟', '我有点迷茫', '', '1941834995@qq.cpm', '厦门', NULL);
INSERT INTO `user` VALUES (2, '2015106011', '杜采莹', 'sends', '不知道', 0, '策划部', '部员', 2020, 1, 0, '17850928069', '保密哦', NULL, '保密哟', '保密哟', '保密哟', '1766495110@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (3, '2023102033', '吴兴梅', 'sends', '旅游管理类', 0, '策划部', '部员', 2020, 1, 0, '13101040937', '保密哦', NULL, '保密哟', '保密哟', '保密哟', '2718974392@qq.cpm', '泉州', NULL);
INSERT INTO `user` VALUES (4, '2115101005', '陈宇', 'sends', '电子信息类', 1, '策划部', '部员', 2021, 1, 0, '13859928950', NULL, NULL, NULL, NULL, NULL, '969891451@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (5, '2125103033', '罗彬', 'sends', '计算机类', 1, '策划部', '部长', 2021, 1, 0, '18008303543', NULL, NULL, NULL, NULL, '23-24策划部部长', '2190781327@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (6, '2225112015', '廖德智', 'sends', '计算机科学与技术', 1, '策划部', '部员', 2022, 1, 0, '18008303543', NULL, NULL, NULL, NULL, NULL, '1605139663@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (7, '2224104052', '杨颖', 'sends', '经济学类', 0, '策划部', '部员', 2022, 1, 0, '18506927306', NULL, NULL, NULL, NULL, '香港', '2962229312@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (8, '2211233034', '张煜', 'sends', '智能制造工程', 1, '策划部', '部员', 2022, 1, 0, '18870294069', NULL, NULL, NULL, NULL, NULL, '2436477891@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (9, '2226204043', '詹媛媛', 'sends', '化学工程与工艺', 0, '策划部', '部员', 2022, 1, 0, '19859293903', NULL, NULL, NULL, '暴富暴美抱爱情', NULL, '2729039247@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (10, '2295121040', '王思成', 'sends', '光电信息科学与工程', 1, '策划部', '部员', 2022, 1, 0, '15715962838', NULL, NULL, NULL, NULL, NULL, 'm193109181026@163.com', '泉州', NULL);
INSERT INTO `user` VALUES (11, '2325181005', '陈思峰', 'sends', '信息安全', 1, '策划部', '部员', 2023, 1, 0, '13365038066', NULL, NULL, NULL, '把自己交给时间，相信现在的你已经收到满意的答案了吧。', NULL, '2096456144@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (12, '2318104015', '张渝晨', 'sends', '新闻传播学类', 0, '策划部', '部员', 2023, 1, 0, '18105585375', NULL, NULL, NULL, '希望未来的自己会一直快乐，健康，幸福，能坚持做自己！', NULL, 'zyc_16976039@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (13, '2325122011', '李玲玲', 'sends', '软件工程', 0, '策划部', '部员', 2023, 1, 0, '19860492868', NULL, NULL, NULL, '一切顺利', NULL, '3549355083@qq.com ', '厦门', NULL);
INSERT INTO `user` VALUES (14, '2326413024', '孙娟娟', 'sends', '环境工程', 0, '策划部', '部员', 2023, 1, 0, '18216811655', NULL, NULL, NULL, '没有比童年更严峻而残酷的生活， 没有比成长更艰难而宽忍的工作。 如果我是一只鸟，在风雪中，我必须独自飞过。 如果我是一个人，在人群中，我必须分辨善恶。', NULL, 'sjj_0809@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (15, '2022111008', '邓玉婷', 'sends', '土地资源管理', 0, '设计部', '部员', 2020, 1, 0, '15070548620', '保密哦', NULL, '保密哟', '保密哟', '不知道', '2215336626@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (16, '2012103044', '朱钰宁', 'sends', '土木类', 1, '设计部', '部员', 2020, 1, 0, '18835435095', NULL, NULL, NULL, NULL, NULL, '23950344@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (17, '2125102042', '燕博远', 'sends', '信息安全', 1, '设计部', '部长', 2021, 1, 0, '13718122603', NULL, NULL, NULL, NULL, '23-24设计部部长', 'yanboyuan0724@163.com', '厦门', NULL);
INSERT INTO `user` VALUES (18, '2225122004', '邓自豪', 'sends', '软工', 1, '设计部', '部员', 2022, 1, 0, '15272424669', NULL, NULL, NULL, NULL, NULL, '3214331937@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (19, '2225101024', '李静汶', 'sends', '计科', 0, '设计部', '部员', 2022, 1, 0, '19358550650', NULL, NULL, NULL, NULL, NULL, 'carmenlei890@126.com', '厦门', NULL);
INSERT INTO `user` VALUES (20, '2215312011', '古清云', 'sends', '电气', 1, '设计部', '部员', 2022, 1, 0, '15923674039', NULL, NULL, NULL, NULL, NULL, '2014909289@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (21, '2216411063', '吴陈正阳', 'sends', '信管', 0, '设计部', '部员', 2022, 1, 0, '13319925563', NULL, NULL, NULL, NULL, NULL, 'wuchenzhengyang@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (22, '2220107025', '张婧涵', 'sends', '设计', 0, '设计部', '部员', 2022, 1, 0, '13081168329', NULL, NULL, NULL, NULL, NULL, '1625743452@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (23, '2313111036', '朱楷晟', 'sends', '建筑学', 1, '设计部', '部员', 2023, 1, 0, '18405070206', NULL, NULL, NULL, '今天你成为大佬了吗？', NULL, '2260324669@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (24, '2325122034', '赵容枫', 'sends', '软件工程', 1, '设计部', '部员', 2023, 1, 0, '18615933016', NULL, NULL, NULL, '希望你找到自己真正想要什么，并记得天天开心～', NULL, '911727854@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (25, '2126203039', '余舒琪', 'sends', '化学工程与工艺', 0, '新媒体部', '部长', 2021, 1, 0, '15216024430', NULL, NULL, NULL, NULL, '23-24新媒体部部长', '2825464157@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (26, '2125103037', '田雨', 'sends', '信息安全', 0, '新媒体部', '部员', 2021, 1, 0, '18843986558', NULL, NULL, NULL, NULL, NULL, '1928144827@qq.com ', '厦门', NULL);
INSERT INTO `user` VALUES (27, '2111211004', '辜嘉益', 'sends', '测控技术与仪器', 1, '新媒体部', '部员', 2021, 1, 0, '18106986336', NULL, NULL, NULL, NULL, NULL, '1486365286@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (28, '2224106032', '余玥', 'sends', '经济学类', 0, '新媒体部', '部员', 2022, 1, 0, '13308724027', NULL, NULL, NULL, NULL, NULL, '2694027808@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (29, '2214112007', '陈万芳', 'sends', '材料科学与工程', 0, '新媒体部', '部长', 2022, 1, 0, '18285965899', NULL, NULL, NULL, NULL, '23-24新媒体部部长', '3083878971@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (30, '2295121042', '吴昌恒', 'sends', '通信工程', 1, '新媒体部', '部员', 2023, 1, 0, '18754909178', NULL, NULL, NULL, '行到水穷处 坐看云起时', NULL, '2585962881@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (31, '2323182015', '彭培森', 'sends', '会展经济与管理', 1, '新媒体部', '部员', 2023, 1, 0, '18084859121', NULL, NULL, NULL, '做自己想做的 做自己所想的', NULL, '1104459370@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (32, '2319211012', '苏锦玲', 'sends', '日语', 0, '新媒体部', '部员', 2023, 1, 0, '15280879281', NULL, NULL, NULL, '时来运转', NULL, 's15280879281@163.com', '泉州', NULL);
INSERT INTO `user` VALUES (33, '2325121025', '应承希', 'sends', '软件工程', 1, '新媒体部', '部员', 2023, 1, 0, '18144125801', NULL, NULL, NULL, '祝我大学四年里有所成长，有所收回', NULL, '2325121025@stu.hqu.edu', '厦门', NULL);
INSERT INTO `user` VALUES (34, '2326213006', '单如纯', 'sends', '化学工程与工艺', 0, '新媒体部', '部员', 2023, 1, 0, '15547308255', NULL, NULL, NULL, '希望未来自己闪闪发光', NULL, 'shan20050825@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (35, '2325191004', '陈垣好', 'sends', '人工智能', 0, '新媒体部', '部员', 2023, 1, 0, '18949766434', NULL, NULL, NULL, '好好吃饭睡觉', NULL, '2290198969@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (36, '2015104036', '王乾润', 'sends', '通信工程', 1, '研发部', '部员', 2020, 1, 0, '15259257676', NULL, NULL, NULL, NULL, NULL, '1049396729@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (37, '2025122027', '倪子轩', 'sends', '软件工程', 1, '研发部', '部员', 2020, 1, 0, '13306141779', NULL, NULL, NULL, NULL, NULL, '1609332741@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (38, '2025103026', '潘俊彦', 'sends', '计算机科学与技术', 1, '研发部', '部员', 2020, 1, 0, '18559215835', NULL, NULL, NULL, NULL, NULL, '2896192354@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (39, '2026311013', '姜力文', 'sends', '集成电路设计与集成系统', 0, '研发部', '部员', 2020, 1, 0, '18637619295', NULL, NULL, NULL, NULL, NULL, '2990117179@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (40, '2125102013', '黄诺', 'sends', '计算机类', 1, '研发部', '部长', 2021, 1, 0, '15859773268', NULL, NULL, NULL, NULL, '23-24研发部部长', '2546515103@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (41, '2125121024', '黄楊', 'sends', '软件工程', 1, '研发部', '部员', 2021, 1, 0, '18814431556', NULL, NULL, NULL, NULL, NULL, '3392406201@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (42, '2125104051', '郑创基', 'sends', '计算机科学与技术专业', 1, '研发部', '部员', 2021, 1, 0, '13534091909', '保密哟', NULL, '保密哟', '保密哟', '保密哟', '568915433@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (43, '2125103034', '罗舒华', 'sends', '计算机类', 0, '研发部', '部员', 2021, 1, 0, '15860218801', '保密哟', '123456', '我不知道', '保密哟', '保密哟', '2741752479@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (44, '2115102001', '安炳旭', 'sends', '电子信息类', 1, '研发部', '部员', 2021, 1, 0, '13475586748', NULL, NULL, NULL, NULL, NULL, '1798297759@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (45, '2295141009', '范林', 'sends', '数据科学与大数据技术', 1, '研发部', '部员', 2022, 1, 0, '13314900067', NULL, NULL, NULL, NULL, NULL, '2528447065@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (46, '2295141047', '张李行', 'sends', '数据科学与大数据技术', 1, '研发部', '部员', 2022, 1, 0, '13292466736', NULL, NULL, NULL, NULL, NULL, '2651167816@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (47, '2225122017', '马志远', 'sends', '软件工程', 1, '研发部', '部员', 2022, 1, 0, '13831799390', NULL, NULL, NULL, NULL, NULL, '2497705229@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (48, '2226204029', '王亚夫', 'sends', '人工智能', 1, '研发部', '部员', 2022, 1, 0, '', '保密哟', NULL, '好好学习,天天向上.', '', '保密哟', '2542096566@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (49, '2215104007', '范子超', 'sends', '电子信息类', 1, '研发部', '部员', 2022, 1, 0, '15698349931', NULL, NULL, NULL, NULL, NULL, '3170988204@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (50, '2216131019', '刘畅', 'sends', '工商管理类中美双学位(全英文教学)', 1, '研发部', '部员', 2022, 1, 0, '18754017233', NULL, NULL, NULL, NULL, NULL, '2743406023@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (51, '2295131008', '何苗', 'sends', '物联网工程', 0, '研发部', '部员', 2022, 1, 0, '17719357344', NULL, NULL, NULL, NULL, NULL, '3192571356@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (52, '2225121003', '陈潇', 'sends', '软件工程', 1, '研发部', '部员', 2022, 1, 0, '13135119714', NULL, NULL, NULL, NULL, NULL, '2241073857@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (53, '2225122019', '苏健尧', '123456', '软件工程', 1, '研发部', '部员', 2022, 1, 1, '18058541942', '保密哟', NULL, '保密哟', '保密哟', '保密哟', 'sjy8593457@outlook.com', '厦门', NULL);
INSERT INTO `user` VALUES (54, '2325191012', '金章骏', 'sends', '人工智能', 1, '研发部', '部员', 2023, 1, 0, '13852405596', NULL, NULL, NULL, '不枉青春，不忘初心', NULL, '2831593587@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (55, '2325122032', '张楷豪', 'sends', '软件工程', 1, '研发部', '部员', 2023, 1, 0, '13505045519', NULL, NULL, NULL, 'Keep coding', NULL, '2769713605@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (56, '2395141015', '胡天琪', 'sends', '数据科学与大数据技术', 0, '研发部', '部员', 2023, 1, 0, '18532521909', NULL, NULL, NULL, NULL, NULL, '2516825978@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (57, '2315102016', '廖冰茜', 'sends', '电子信息类', 0, '研发部', '部员', 2023, 1, 0, '18650169518', NULL, NULL, NULL, '庆祝十周年，十年来起码认真办一次吧！', NULL, '763570757@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (58, '2395141051', '詹振云', 'sends', '数据科学与大数据技术', 1, '研发部', '部员', 2023, 1, 0, '13626074750', NULL, NULL, NULL, '希望那时你已经有满意的offer了', NULL, '1450036926@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (59, '2395131016', '季芯宇', 'sends', '物联网工程', 0, '研发部', '部员', 2023, 1, 0, '15906437515', NULL, NULL, NULL, '好好学习努力努力多多尝试实现目标成为更好的自己', NULL, '2133128086@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (60, '2325112015', '刘阳', 'sends', '计算机科学与技术', 1, '研发部', '部员', 2023, 1, 0, '13207195513', NULL, NULL, NULL, '懒得写', NULL, '3200390562@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (61, '2395131013', '何牧亮', 'sends', '物联网工程', 1, '研发部', '部员', 2023, 1, 0, '18060534234', NULL, NULL, NULL, '祝四年后的你可以得到好多好多好offer，四年期间收获满满，学会好多好多新知识', NULL, 'h18060534234@163.com', '泉州', NULL);
INSERT INTO `user` VALUES (62, '2015102011', '李诗鸿', 'sends', '电子信息工程', 1, '研发部', '部员', 2020, 1, 0, '13599242681', NULL, NULL, NULL, NULL, NULL, '1353455048@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (63, '2025104030', '苏明强', 'sends', '计算机科学与技术', 1, '研发部', '部员', 2020, 1, 0, '15106036583', NULL, NULL, NULL, NULL, NULL, '1172072897@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (64, '2025122022', '林时晟', 'sends', '软件工程', 1, '研发部', '部员', 2020, 1, 0, '13400637238', NULL, NULL, NULL, NULL, NULL, '2503657999@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (65, '2125102052', '张志飞', 'sends', '计算机类 ', 1, '研发部', '总负责人', 2021, 1, 0, '18784889737 ', NULL, NULL, NULL, NULL, '23-24总负责人', '384637134@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (66, '2125101018', '赖致远', 'sends', '计算机类', 1, '研发部', '部员', 2021, 1, 0, '18902340429', NULL, NULL, NULL, NULL, NULL, '1481800557@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (67, '2115101037', '许森发', 'sends', '电子信息类', 1, '研发部', '部长', 2021, 1, 0, '18350586189', NULL, NULL, NULL, NULL, '23-24研发部部长', 'q211798501@hotmail.com', '厦门', NULL);
INSERT INTO `user` VALUES (68, '2125102056', '周鸿盛', 'sends', '信息安全', 1, '研发部', '部员', 2021, 1, 0, '17302319002', NULL, NULL, NULL, 'Head forward and don\'t look back...', NULL, '870154149@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (69, '2227111046', '覃炜梁', 'sends', '哲学', 1, '研发部', '部员', 2022, 1, 0, '19865583115', NULL, NULL, NULL, NULL, NULL, '1505477505@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (70, '2223106020', '向世俊', 'sends', '旅游管理类', 1, '研发部', '部员', 2022, 1, 0, '17706103307', NULL, NULL, NULL, NULL, NULL, 'sunflower2333@outlook.com', '厦门', NULL);
INSERT INTO `user` VALUES (71, '2223101020', '吴灿权', 'sends', '旅游管理类', 1, '研发部', '部员', 2022, 1, 0, '18159639268', NULL, NULL, NULL, NULL, NULL, 'xj87592492@163.com', '厦门', NULL);
INSERT INTO `user` VALUES (72, '2325191036', '徐苏哲', 'sends', '人工智能', 1, '研发部', '部员', 2023, 1, 0, '15959411907', NULL, NULL, NULL, '呜呜呜你好棒👍ujz', NULL, '2493906800@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (73, '2325191003', '陈一鸣', 'sends', '人工智能', 1, '研发部', '部员', 2023, 1, 0, '15093885963', NULL, NULL, NULL, '陈一鸣，你大学四年生活丰富无憾吗？', NULL, '2844114018@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (74, '2395141003', '陈俊文', 'sends', '数据科学与大数据技术', 1, '研发部', '部员', 2023, 1, 0, '19705440996', NULL, NULL, NULL, '不祝未来的Starry有多顺利\n只祝你能随心所动\n——DriftingStarry到此一游', NULL, '3103250546@qq.com', '泉州', NULL);
INSERT INTO `user` VALUES (75, '2314111005', '陈卓', 'sends', '材料科学与工程', 1, '研发部', '部员', 2023, 1, 0, '13023996181', NULL, NULL, NULL, NULL, NULL, '2261660200@qq.com', '厦门', NULL);
INSERT INTO `user` VALUES (77, 'DL0071', '黄丽萍', 'sends', '', 0, '', '老师', NULL, 1, 0, NULL, NULL, NULL, NULL, NULL, '', NULL, '厦门', NULL);
INSERT INTO `user` VALUES (78, '35471', '高若瑶', 'sends', '', 0, '', '老师', NULL, 1, 0, NULL, NULL, NULL, NULL, NULL, '', NULL, '厦门', NULL);

SET FOREIGN_KEY_CHECKS = 1;
