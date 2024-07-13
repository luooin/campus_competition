package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 操作人员：(Operator)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Operator")
public class Operator implements Serializable {

    // Operator编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operator_id")
    private Integer operator_id;

    // 人员姓名
    @Basic
    private String name_of_personnel;
    // 人员性别
    @Basic
    private String gender_of_personnel;
    // 人员年龄
    @Basic
    private String age_of_personnel;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
