package com.changgou.goods.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:Admin构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Admin",value = "Admin")
@Table(name="tb_admin")
public class Admin implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "login_name")
	private String loginName;//用户名

	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "password")
	private String password;//密码

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "status")
	private String status;//状态



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getLoginName() {
		return loginName;
	}

	//set方法
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}


}
