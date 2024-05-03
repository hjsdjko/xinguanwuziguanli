package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 小区管理员
 *
 * @author 
 * @email
 */
@TableName("xiaoquguanli")
public class XiaoquguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoquguanliEntity() {

	}

	public XiaoquguanliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 小区管理员姓名
     */
    @ColumnInfo(comment="小区管理员姓名",type="varchar(200)")
    @TableField(value = "xiaoquguanli_name")

    private String xiaoquguanliName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "xiaoquguanli_photo")

    private String xiaoquguanliPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "xiaoquguanli_phone")

    private String xiaoquguanliPhone;


    /**
     * 身份证号
     */
    @ColumnInfo(comment="身份证号",type="varchar(200)")
    @TableField(value = "xiaoquguanli_id_number")

    private String xiaoquguanliIdNumber;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "xiaoquguanli_email")

    private String xiaoquguanliEmail;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "xiaoquguanli_delete")

    private Integer xiaoquguanliDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Xiaoquguanli{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xiaoquguanliName=" + xiaoquguanliName +
            ", xiaoquguanliPhoto=" + xiaoquguanliPhoto +
            ", xiaoquguanliPhone=" + xiaoquguanliPhone +
            ", xiaoquguanliIdNumber=" + xiaoquguanliIdNumber +
            ", xiaoquguanliEmail=" + xiaoquguanliEmail +
            ", sexTypes=" + sexTypes +
            ", xiaoquguanliDelete=" + xiaoquguanliDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
