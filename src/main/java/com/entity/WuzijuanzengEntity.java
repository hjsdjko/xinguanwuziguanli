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
 * 物资捐赠
 *
 * @author 
 * @email
 */
@TableName("wuzijuanzeng")
public class WuzijuanzengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzijuanzengEntity() {

	}

	public WuzijuanzengEntity(T t) {
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
     * 物资
     */
    @ColumnInfo(comment="物资",type="int(11)")
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 小区管理员
     */
    @ColumnInfo(comment="小区管理员",type="int(11)")
    @TableField(value = "xiaoquguanli_id")

    private Integer xiaoquguanliId;


    /**
     * 捐赠人
     */
    @ColumnInfo(comment="捐赠人",type="varchar(200)")
    @TableField(value = "wuzijuanzeng_name")

    private String wuzijuanzengName;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "wuzijuanzeng_phone")

    private String wuzijuanzengPhone;


    /**
     * 捐赠人住址
     */
    @ColumnInfo(comment="捐赠人住址",type="varchar(200)")
    @TableField(value = "wuzijuanzeng_address")

    private String wuzijuanzengAddress;


    /**
     * 捐赠数量
     */
    @ColumnInfo(comment="捐赠数量",type="int(11)")
    @TableField(value = "wuzijuanzeng_number")

    private Integer wuzijuanzengNumber;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "wuzijuanzeng_content")

    private String wuzijuanzengContent;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="操作时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }
    /**
	 * 设置：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 获取：小区管理员
	 */
    public Integer getXiaoquguanliId() {
        return xiaoquguanliId;
    }
    /**
	 * 设置：小区管理员
	 */

    public void setXiaoquguanliId(Integer xiaoquguanliId) {
        this.xiaoquguanliId = xiaoquguanliId;
    }
    /**
	 * 获取：捐赠人
	 */
    public String getWuzijuanzengName() {
        return wuzijuanzengName;
    }
    /**
	 * 设置：捐赠人
	 */

    public void setWuzijuanzengName(String wuzijuanzengName) {
        this.wuzijuanzengName = wuzijuanzengName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getWuzijuanzengPhone() {
        return wuzijuanzengPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setWuzijuanzengPhone(String wuzijuanzengPhone) {
        this.wuzijuanzengPhone = wuzijuanzengPhone;
    }
    /**
	 * 获取：捐赠人住址
	 */
    public String getWuzijuanzengAddress() {
        return wuzijuanzengAddress;
    }
    /**
	 * 设置：捐赠人住址
	 */

    public void setWuzijuanzengAddress(String wuzijuanzengAddress) {
        this.wuzijuanzengAddress = wuzijuanzengAddress;
    }
    /**
	 * 获取：捐赠数量
	 */
    public Integer getWuzijuanzengNumber() {
        return wuzijuanzengNumber;
    }
    /**
	 * 设置：捐赠数量
	 */

    public void setWuzijuanzengNumber(Integer wuzijuanzengNumber) {
        this.wuzijuanzengNumber = wuzijuanzengNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getWuzijuanzengContent() {
        return wuzijuanzengContent;
    }
    /**
	 * 设置：备注
	 */

    public void setWuzijuanzengContent(String wuzijuanzengContent) {
        this.wuzijuanzengContent = wuzijuanzengContent;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：操作时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Wuzijuanzeng{" +
            ", id=" + id +
            ", wuziId=" + wuziId +
            ", xiaoquguanliId=" + xiaoquguanliId +
            ", wuzijuanzengName=" + wuzijuanzengName +
            ", wuzijuanzengPhone=" + wuzijuanzengPhone +
            ", wuzijuanzengAddress=" + wuzijuanzengAddress +
            ", wuzijuanzengNumber=" + wuzijuanzengNumber +
            ", wuzijuanzengContent=" + wuzijuanzengContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
