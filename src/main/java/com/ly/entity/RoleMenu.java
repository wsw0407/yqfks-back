package com.ly.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_role_menu")
@ApiModel(value = "RoleMenu对象",description = "角色菜单对象")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID=1L;
    @TableId
    private Integer roleid;

    private Integer menuid;

    @Override
    protected Serializable pkVal() {
        return this.roleid;
    }

}
