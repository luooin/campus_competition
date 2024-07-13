package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 成绩信息：(AchievementInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AchievementInformation")
public class AchievementInformation implements Serializable {

    // AchievementInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_information_id")
    private Integer achievement_information_id;

    // 项目名称
    @Basic
    private String entry_name;
    // 项目类别
    @Basic
    private String project_category;
    // 项目时间
    @Basic
    private String project_time;
    // 项目选手
    @Basic
    private Integer event_players;
    // 用户学号
    @Basic
    private String user_student_id;
    // 用户姓名
    @Basic
    private String user_name;
    // 成绩分数
    @Basic
    private Integer score;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
