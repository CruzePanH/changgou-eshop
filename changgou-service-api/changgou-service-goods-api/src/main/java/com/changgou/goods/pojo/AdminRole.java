package com.changgou.goods.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:AdminRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "AdminRole",value = "AdminRole")
@Table(name="tb_admin_role")
public class AdminRole implements Serializable{

	@ApiModelProperty(value = "管理员ID",required = false)
    @Column(name = "admin_id")
	private Integer adminId;//管理员ID

	@ApiModelProperty(value = "角色ID",required = false)
	@Id
    @Column(name = "role_id")
	private Integer roleId;//角色ID



	//get方法
	public Integer getAdminId() {
		return adminId;
	}

	//set方法
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


}
