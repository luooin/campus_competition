package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 项目类别：(ProjectCategory)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ProjectCategory")
public class ProjectCategory implements Serializable {

    // ProjectCategory编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_category_id")
    private Integer project_category_id;

    // 项目类别
    @Basic
    private String project_category;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
