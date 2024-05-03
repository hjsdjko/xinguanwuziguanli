package com.entity.vo;

import com.entity.XiaoquguanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 小区管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoquguanli")
public class XiaoquguanliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 小区管理员姓名
     */

    @TableField(value = "xiaoquguanli_name")
    private String xiaoquguanliName;


    /**
     * 头像
     */

    @TableField(value = "xiaoquguanli_photo")
    private String xiaoquguanliPhoto;


    /**
     * 联系方式
     */

    @TableField(value = "xiaoquguanli_phone")
    private String xiaoquguanliPhone;


    /**
     * 身份证号
     */

    @TableField(value = "xiaoquguanli_id_number")
    private String xiaoquguanliIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "xiaoquguanli_email")
    private String xiaoquguanliEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "xiaoquguanli_delete")
    private Integer xiaoquguanliDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：小区管理员姓名
	 */
    public String getXiaoquguanliName() {
        return xiaoquguanliName;
    }


    /**
	 * 获取：小区管理员姓名
	 */

    public void setXiaoquguanliName(String xiaoquguanliName) {
        this.xiaoquguanliName = xiaoquguanliName;
    }
    /**
	 * 设置：头像
	 */
    public String getXiaoquguanliPhoto() {
        return xiaoquguanliPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setXiaoquguanliPhoto(String xiaoquguanliPhoto) {
        this.xiaoquguanliPhoto = xiaoquguanliPhoto;
    }
    /**
	 * 设置：联系方式
	 */
    public String getXiaoquguanliPhone() {
        return xiaoquguanliPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setXiaoquguanliPhone(String xiaoquguanliPhone) {
        this.xiaoquguanliPhone = xiaoquguanliPhone;
    }
    /**
	 * 设置：身份证号
	 */
    public String getXiaoquguanliIdNumber() {
        return xiaoquguanliIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setXiaoquguanliIdNumber(String xiaoquguanliIdNumber) {
        this.xiaoquguanliIdNumber = xiaoquguanliIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getXiaoquguanliEmail() {
        return xiaoquguanliEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setXiaoquguanliEmail(String xiaoquguanliEmail) {
        this.xiaoquguanliEmail = xiaoquguanliEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getXiaoquguanliDelete() {
        return xiaoquguanliDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setXiaoquguanliDelete(Integer xiaoquguanliDelete) {
        this.xiaoquguanliDelete = xiaoquguanliDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
