package com.sjy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName log
 */
@TableName(value = "log")
@Data
public class Log implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日志内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 时间
     */
    @TableField(value = "time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    /**
     * 年份
     */
    @TableField(value = "year")
    private Integer year;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Log() {
        this.time = new Date();
        this.year = this.time.getYear() + 1900;
    }


}