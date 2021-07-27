package com.changgou.goods.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:OauthClientDetails构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OauthClientDetails",value = "OauthClientDetails")
@Table(name="oauth_client_details")
public class OauthClientDetails implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "client_id")
	private String clientId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "resource_ids")
	private String resourceIds;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "client_secret")
	private String clientSecret;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "scope")
	private String scope;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "authorities")
	private String authorities;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "access_token_validity")
	private Integer accessTokenValidity;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "refresh_token_validity")
	private Integer refreshTokenValidity;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "additional_information")
	private String additionalInformation;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "autoapprove")
	private String autoapprove;//



	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	//get方法
	public String getResourceIds() {
		return resourceIds;
	}

	//set方法
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	//get方法
	public String getClientSecret() {
		return clientSecret;
	}

	//set方法
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	//get方法
	public String getScope() {
		return scope;
	}

	//set方法
	public void setScope(String scope) {
		this.scope = scope;
	}
	//get方法
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	//set方法
	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}
	//get方法
	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	//set方法
	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}
	//get方法
	public String getAuthorities() {
		return authorities;
	}

	//set方法
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	//get方法
	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	//set方法
	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}
	//get方法
	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	//set方法
	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}
	//get方法
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	//set方法
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	//get方法
	public String getAutoapprove() {
		return autoapprove;
	}

	//set方法
	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}


}
