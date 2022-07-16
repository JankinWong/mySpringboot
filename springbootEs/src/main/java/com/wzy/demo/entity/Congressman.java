package com.wzy.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Congressman implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @TableField("CongressId")
    private String CongressId;

    @TableField("En_name")
    private String enName;

    @TableField("Cn_name")
    private String cnName;

    @TableField("Avatar_img_src")
    private String avatarImgSrc;

    @TableField("Origin_url")
    private String originUrl;

    @TableField("Country")
    private String Country;

    @TableField("Edu")
    private String Edu;

    @TableField("Birth_place")
    private String birthPlace;

    @TableField("Birth_date")
    private LocalDate birthDate;

    @TableField("Graduated_school")
    private String graduatedSchool;

    @TableField("Location")
    private String Location;

    @TableField("Sign")
    private String Sign;

    @TableField("Introduction")
    private String Introduction;

    @TableField("Resume")
    private String Resume;

    @TableField("Political_party")
    private String politicalParty;

    @TableField("OrganId")
    private String OrganId;

    private String gender;

    @TableField("Nick_name")
    private String nickName;

    @TableField("Language")
    private String Language;

    @TableField("Nationality")
    private String Nationality;

    private String post;

    @TableField("Religion")
    private String Religion;

    @TableField("Achievement")
    private String Achievement;

    @TableField("Works")
    private String Works;

    @TableField("Relation")
    private String Relation;

    @TableField("Create_time")
    private LocalDateTime createTime;

    @TableField("Update_time")
    private LocalDateTime updateTime;

    /**
     * wiki词条（英文）
     */
    private String wiki;

    /**
     * wikidata编码
     */
    private String qcode;

    private String infobox;

    /**
     * 人员类别
     */
    private String personClass;

    /**
     * 所属州
     */
    private String state;

    /**
     * 官网
     */
    private String website;

    private String twitter;

    private String facebook;

    private String instagram;

    private String linkedin;

    private String alias;


}
