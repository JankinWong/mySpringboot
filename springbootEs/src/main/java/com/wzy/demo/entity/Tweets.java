package com.wzy.demo.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author felix
 * @since 2022-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tweets implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("userName")
    private String userName;

    @TableField("screenName")
    private String screenName;

    private LocalDateTime createdAt;

    private LocalDate createdDate;

    private String text;

    @TableField("imgNum")
    private Integer imgNum;

    private String link;

    private Integer status;

    @TableField("userID")
    private String userID;

    @TableField("aboutChina")
    private Integer aboutChina;

    @TableField("locationID")
    private String locationID;

    @TableField("locationName")
    private String locationName;


}
