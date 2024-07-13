package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 比赛项目：(Event)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Event")
public class Event implements Serializable {

    // Event编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer event_id;

    // 项目名称
    @Basic
    private String entry_name;
    // 项目类别
    @Basic
    private String project_category;
    // 项目时间
    @Basic
    private String project_time;
    // 项目地点
    @Basic
    private String project_location;
    // 项目描述
    @Basic
    private String project_description;
    // 项目图片
    @Basic
    private String project_picture;
    // 项目简介
    @Basic
    private String project_introduction;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
