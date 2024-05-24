package com.sjy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @TableName announcement
 */
@TableName(value = "announcement")
@Data
public class Announcement implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "content")
    private String content;

    /**
     *
     */
    @TableField(value = "time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    /**
     *
     */
    @TableField(value = "year")

    private Integer year;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Announcement() {
        this.time = new Date();
        this.year = this.time.getYear() + 1900;
    }
}