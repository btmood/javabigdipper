package com.lark.web.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 手机号码
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 用户名
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 用户状态 0：禁用 1：启用
     */
    @TableField("ENABLE_STATE")
    private String enableState;

    /**
     * 用户经验，通过经验获得等级
     */
    @TableField("LEVEL")
    private Integer level;

    /**
     * 用户头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("IS_DELETED")
    private String isDeleted;

    /**
     * 是否是VIP 1：是, 0：不是
     */
    @TableField("IS_VIP")
    private String isVip;

    /**
     * 用户签名
     */
    @TableField("SIGN")
    private String sign;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;


}
