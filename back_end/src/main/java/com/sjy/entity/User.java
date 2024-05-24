package com.sjy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * uuid
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号或老师的教师号
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 专业
     */
    @TableField(value = "major")
    private String major;

    /**
     * 性别(0: 女, 1: 男)
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 部门(0: 策划, 1: 研发, 2: 新媒体, 3: 美工部)
     */
    @TableField(value = "department")
    private String department;

    /**
     * 岗位(0: 待加入, 1: 部员, 2: 部长, 3: 总负责人, 4: 老师)
     */
    @TableField(value = "position")
    private String position;

    /**
     * 第几届的,如: 2022
     */
    @TableField(value = "session")
    private Integer session;

    /**
     * 是否在职位(0: 不在, 1: 在)
     */
    @TableField(value = "is_in")
    private Integer isIn;

    /**
     * 是否为管理员(0: 否, 1: 是)
     */
    @TableField(value = "is_admin")
    private Integer isAdmin;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * QQ号
     */
    @TableField(value = "qq")
    private String qq;

    /**
     * 微信号
     */
    @TableField(value = "weChat")
    private String weChat;

    /**
     * 个性签名
     */
    @TableField(value = "signature")
    private String signature;

    /**
     * 介绍
     */
    @TableField(value = "introduction")
    private String introduction;

    /**
     * 成员评价
     */
    @TableField(value = "reviews")
    private String reviews;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 校区
     */
    @TableField(value = "school")
    private String school;

    /**
     * 头像路径
     */
    @TableField(value = "avatar")
    private String avatar;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}