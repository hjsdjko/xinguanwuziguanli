package com.entity.model;

import com.entity.XiaoquguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 小区管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoquguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 小区管理员姓名
     */
    private String xiaoquguanliName;


    /**
     * 头像
     */
    private String xiaoquguanliPhoto;


    /**
     * 联系方式
     */
    private String xiaoquguanliPhone;


    /**
     * 身份证号
     */
    private String xiaoquguanliIdNumber;


    /**
     * 邮箱
     */
    private String xiaoquguanliEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer xiaoquguanliDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：小区管理员姓名
	 */
    public String getXiaoquguanliName() {
        return xiaoquguanliName;
    }


    /**
	 * 设置：小区管理员姓名
	 */
    public void setXiaoquguanliName(String xiaoquguanliName) {
        this.xiaoquguanliName = xiaoquguanliName;
    }
    /**
	 * 获取：头像
	 */
    public String getXiaoquguanliPhoto() {
        return xiaoquguanliPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setXiaoquguanliPhoto(String xiaoquguanliPhoto) {
        this.xiaoquguanliPhoto = xiaoquguanliPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getXiaoquguanliPhone() {
        return xiaoquguanliPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setXiaoquguanliPhone(String xiaoquguanliPhone) {
        this.xiaoquguanliPhone = xiaoquguanliPhone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getXiaoquguanliIdNumber() {
        return xiaoquguanliIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setXiaoquguanliIdNumber(String xiaoquguanliIdNumber) {
        this.xiaoquguanliIdNumber = xiaoquguanliIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getXiaoquguanliEmail() {
        return xiaoquguanliEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setXiaoquguanliEmail(String xiaoquguanliEmail) {
        this.xiaoquguanliEmail = xiaoquguanliEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getXiaoquguanliDelete() {
        return xiaoquguanliDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setXiaoquguanliDelete(Integer xiaoquguanliDelete) {
        this.xiaoquguanliDelete = xiaoquguanliDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
