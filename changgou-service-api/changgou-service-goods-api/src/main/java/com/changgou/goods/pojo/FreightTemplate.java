package com.changgou.goods.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:FreightTemplate构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "FreightTemplate",value = "FreightTemplate")
@Table(name="tb_freight_template")
public class FreightTemplate implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

	@ApiModelProperty(value = "模板名称",required = false)
    @Column(name = "name")
	private String name;//模板名称

	@ApiModelProperty(value = "计费方式",required = false)
    @Column(name = "type")
	private String type;//计费方式



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
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
	public String getType() {
		return type;
	}

	//set方法
	public void setType(String type) {
		this.type = type;
	}


}
