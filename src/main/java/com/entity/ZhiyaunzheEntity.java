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
 * 自愿者
 *
 * @author 
 * @email
 */
@TableName("zhiyaunzhe")
public class ZhiyaunzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiyaunzheEntity() {

	}

	public ZhiyaunzheEntity(T t) {
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
     * 自愿者姓名
     */
    @ColumnInfo(comment="自愿者姓名",type="varchar(200)")
    @TableField(value = "zhiyaunzhe_name")

    private String zhiyaunzheName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "zhiyaunzhe_photo")

    private String zhiyaunzhePhoto;


    /**
     * 自愿者联系方式
     */
    @ColumnInfo(comment="自愿者联系方式",type="varchar(200)")
    @TableField(value = "zhiyaunzhe_phone")

    private String zhiyaunzhePhone;


    /**
     * 自愿者身份证号
     */
    @ColumnInfo(comment="自愿者身份证号",type="varchar(200)")
    @TableField(value = "zhiyaunzhe_id_number")

    private String zhiyaunzheIdNumber;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "zhiyaunzhe_email")

    private String zhiyaunzheEmail;


    /**
     * 住址
     */
    @ColumnInfo(comment="住址",type="varchar(200)")
    @TableField(value = "zhiyaunzhe_address")

    private String zhiyaunzheAddress;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 自愿者服务记录
     */
    @ColumnInfo(comment="自愿者服务记录",type="text")
    @TableField(value = "zhiyaunzhe_content")

    private String zhiyaunzheContent;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "zhiyaunzhe_delete")

    private Integer zhiyaunzheDelete;


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
	 * 获取：自愿者姓名
	 */
    public String getZhiyaunzheName() {
        return zhiyaunzheName;
    }
    /**
	 * 设置：自愿者姓名
	 */

    public void setZhiyaunzheName(String zhiyaunzheName) {
        this.zhiyaunzheName = zhiyaunzheName;
    }
    /**
	 * 获取：头像
	 */
    public String getZhiyaunzhePhoto() {
        return zhiyaunzhePhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setZhiyaunzhePhoto(String zhiyaunzhePhoto) {
        this.zhiyaunzhePhoto = zhiyaunzhePhoto;
    }
    /**
	 * 获取：自愿者联系方式
	 */
    public String getZhiyaunzhePhone() {
        return zhiyaunzhePhone;
    }
    /**
	 * 设置：自愿者联系方式
	 */

    public void setZhiyaunzhePhone(String zhiyaunzhePhone) {
        this.zhiyaunzhePhone = zhiyaunzhePhone;
    }
    /**
	 * 获取：自愿者身份证号
	 */
    public String getZhiyaunzheIdNumber() {
        return zhiyaunzheIdNumber;
    }
    /**
	 * 设置：自愿者身份证号
	 */

    public void setZhiyaunzheIdNumber(String zhiyaunzheIdNumber) {
        this.zhiyaunzheIdNumber = zhiyaunzheIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getZhiyaunzheEmail() {
        return zhiyaunzheEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setZhiyaunzheEmail(String zhiyaunzheEmail) {
        this.zhiyaunzheEmail = zhiyaunzheEmail;
    }
    /**
	 * 获取：住址
	 */
    public String getZhiyaunzheAddress() {
        return zhiyaunzheAddress;
    }
    /**
	 * 设置：住址
	 */

    public void setZhiyaunzheAddress(String zhiyaunzheAddress) {
        this.zhiyaunzheAddress = zhiyaunzheAddress;
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
	 * 获取：自愿者服务记录
	 */
    public String getZhiyaunzheContent() {
        return zhiyaunzheContent;
    }
    /**
	 * 设置：自愿者服务记录
	 */

    public void setZhiyaunzheContent(String zhiyaunzheContent) {
        this.zhiyaunzheContent = zhiyaunzheContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getZhiyaunzheDelete() {
        return zhiyaunzheDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setZhiyaunzheDelete(Integer zhiyaunzheDelete) {
        this.zhiyaunzheDelete = zhiyaunzheDelete;
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
        return "Zhiyaunzhe{" +
            ", id=" + id +
            ", zhiyaunzheName=" + zhiyaunzheName +
            ", zhiyaunzhePhoto=" + zhiyaunzhePhoto +
            ", zhiyaunzhePhone=" + zhiyaunzhePhone +
            ", zhiyaunzheIdNumber=" + zhiyaunzheIdNumber +
            ", zhiyaunzheEmail=" + zhiyaunzheEmail +
            ", zhiyaunzheAddress=" + zhiyaunzheAddress +
            ", sexTypes=" + sexTypes +
            ", zhiyaunzheContent=" + zhiyaunzheContent +
            ", zhiyaunzheDelete=" + zhiyaunzheDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
