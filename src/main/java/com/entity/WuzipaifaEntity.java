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
 * 物资派发
 *
 * @author 
 * @email
 */
@TableName("wuzipaifa")
public class WuzipaifaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzipaifaEntity() {

	}

	public WuzipaifaEntity(T t) {
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
     * 自愿者
     */
    @ColumnInfo(comment="自愿者",type="int(11)")
    @TableField(value = "zhiyaunzhe_id")

    private Integer zhiyaunzheId;


    /**
     * 物资
     */
    @ColumnInfo(comment="物资",type="int(11)")
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 派发居民
     */
    @ColumnInfo(comment="派发居民",type="varchar(200)")
    @TableField(value = "wuzipaifa_name")

    private String wuzipaifaName;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "wuzipaifa_phone")

    private String wuzipaifaPhone;


    /**
     * 派发住址
     */
    @ColumnInfo(comment="派发住址",type="varchar(200)")
    @TableField(value = "wuzipaifa_address")

    private String wuzipaifaAddress;


    /**
     * 派发数量
     */
    @ColumnInfo(comment="派发数量",type="int(11)")
    @TableField(value = "wuzipaifa_number")

    private Integer wuzipaifaNumber;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "wuzipaifa_content")

    private String wuzipaifaContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
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
	 * 获取：自愿者
	 */
    public Integer getZhiyaunzheId() {
        return zhiyaunzheId;
    }
    /**
	 * 设置：自愿者
	 */

    public void setZhiyaunzheId(Integer zhiyaunzheId) {
        this.zhiyaunzheId = zhiyaunzheId;
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
	 * 获取：派发居民
	 */
    public String getWuzipaifaName() {
        return wuzipaifaName;
    }
    /**
	 * 设置：派发居民
	 */

    public void setWuzipaifaName(String wuzipaifaName) {
        this.wuzipaifaName = wuzipaifaName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getWuzipaifaPhone() {
        return wuzipaifaPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setWuzipaifaPhone(String wuzipaifaPhone) {
        this.wuzipaifaPhone = wuzipaifaPhone;
    }
    /**
	 * 获取：派发住址
	 */
    public String getWuzipaifaAddress() {
        return wuzipaifaAddress;
    }
    /**
	 * 设置：派发住址
	 */

    public void setWuzipaifaAddress(String wuzipaifaAddress) {
        this.wuzipaifaAddress = wuzipaifaAddress;
    }
    /**
	 * 获取：派发数量
	 */
    public Integer getWuzipaifaNumber() {
        return wuzipaifaNumber;
    }
    /**
	 * 设置：派发数量
	 */

    public void setWuzipaifaNumber(Integer wuzipaifaNumber) {
        this.wuzipaifaNumber = wuzipaifaNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getWuzipaifaContent() {
        return wuzipaifaContent;
    }
    /**
	 * 设置：备注
	 */

    public void setWuzipaifaContent(String wuzipaifaContent) {
        this.wuzipaifaContent = wuzipaifaContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
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
        return "Wuzipaifa{" +
            ", id=" + id +
            ", zhiyaunzheId=" + zhiyaunzheId +
            ", wuziId=" + wuziId +
            ", wuzipaifaName=" + wuzipaifaName +
            ", wuzipaifaPhone=" + wuzipaifaPhone +
            ", wuzipaifaAddress=" + wuzipaifaAddress +
            ", wuzipaifaNumber=" + wuzipaifaNumber +
            ", wuzipaifaContent=" + wuzipaifaContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
