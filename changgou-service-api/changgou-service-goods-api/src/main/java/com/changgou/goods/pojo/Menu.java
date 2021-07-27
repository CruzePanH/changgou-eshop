package com.changgou.goods.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:Menu构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Menu",value = "Menu")
@Table(name="tb_menu")
public class Menu implements Serializable{

	@ApiModelProperty(value = "菜单ID",required = false)
	@Id
    @Column(name = "id")
	private String id;//菜单ID

	@ApiModelProperty(value = "菜单名称",required = false)
    @Column(name = "name")
	private String name;//菜单名称

	@ApiModelProperty(value = "图标",required = false)
    @Column(name = "icon")
	private String icon;//图标

	@ApiModelProperty(value = "URL",required = false)
    @Column(name = "url")
	private String url;//URL

	@ApiModelProperty(value = "上级菜单ID",required = false)
    @Column(name = "parent_id")
	private String parentId;//上级菜单ID



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public String getIcon() {
		return icon;
	}

	//set方法
	public void setIcon(String icon) {
		this.icon = icon;
	}
	//get方法
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public String getParentId() {
		return parentId;
	}

	//set方法
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


}
