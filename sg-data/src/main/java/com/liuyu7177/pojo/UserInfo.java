package com.liuyu7177.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by libiyan on 2019/10/27.
 * @author liuyu
 */

@Entity
@Data
@Table(name="user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
}
