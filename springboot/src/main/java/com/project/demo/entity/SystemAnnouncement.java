package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 系统公告：(SystemAnnouncement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SystemAnnouncement")
public class SystemAnnouncement implements Serializable {

    // SystemAnnouncement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_announcement_id")
    private Integer system_announcement_id;

    // 公告标题
    @Basic
    private String announcement_title;
    // 公告标签
    @Basic
    private String announcement_label;
    // 公告日期
    @Basic
    private Timestamp date_of_announcement;
    // 公告描述
    @Basic
    private String announcement_description;
    // 公告内容
    @Basic
    private String announcement_content;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
