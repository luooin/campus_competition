package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 项目赛程：(ProjectSchedule)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ProjectSchedule")
public class ProjectSchedule implements Serializable {

    // ProjectSchedule编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_schedule_id")
    private Integer project_schedule_id;

    // 项目名称
    @Basic
    private String entry_name;
    // 项目类别
    @Basic
    private String project_category;
    // 项目地点
    @Basic
    private String project_location;
    // 比赛时间
    @Basic
    private String game_time;
    // 注意事项
    @Basic
    private String matters_needing_attention;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
