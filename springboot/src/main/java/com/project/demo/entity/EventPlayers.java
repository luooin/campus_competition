package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 项目选手：(EventPlayers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EventPlayers")
public class EventPlayers implements Serializable {

    // EventPlayers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_players_id")
    private Integer event_players_id;

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
    // 项目选手
    @Basic
    private Integer event_players;
    // 用户学号
    @Basic
    private String user_student_id;
    // 用户姓名
    @Basic
    private String user_name;
    // 项目组别
    @Basic
    private String project_group;
    // 比赛日期
    @Basic
    private Timestamp match_date;
    // 备注信息
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
