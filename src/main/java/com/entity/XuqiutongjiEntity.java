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
 * 需求收集
 *
 * @author 
 * @email
 */
@TableName("xuqiutongji")
public class XuqiutongjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuqiutongjiEntity() {

	}

	public XuqiutongjiEntity(T t) {
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
     * 居民
     */
    @ColumnInfo(comment="居民",type="varchar(200)")
    @TableField(value = "xuqiutongji_name")

    private String xuqiutongjiName;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "xuqiutongji_phone")

    private String xuqiutongjiPhone;


    /**
     * 住址
     */
    @ColumnInfo(comment="住址",type="varchar(200)")
    @TableField(value = "xuqiutongji_address")

    private String xuqiutongjiAddress;


    /**
     * 需求详情
     */
    @ColumnInfo(comment="需求详情",type="text")
    @TableField(value = "xuqiutongji_content")

    private String xuqiutongjiContent;


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
	 * 获取：居民
	 */
    public String getXuqiutongjiName() {
        return xuqiutongjiName;
    }
    /**
	 * 设置：居民
	 */

    public void setXuqiutongjiName(String xuqiutongjiName) {
        this.xuqiutongjiName = xuqiutongjiName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getXuqiutongjiPhone() {
        return xuqiutongjiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setXuqiutongjiPhone(String xuqiutongjiPhone) {
        this.xuqiutongjiPhone = xuqiutongjiPhone;
    }
    /**
	 * 获取：住址
	 */
    public String getXuqiutongjiAddress() {
        return xuqiutongjiAddress;
    }
    /**
	 * 设置：住址
	 */

    public void setXuqiutongjiAddress(String xuqiutongjiAddress) {
        this.xuqiutongjiAddress = xuqiutongjiAddress;
    }
    /**
	 * 获取：需求详情
	 */
    public String getXuqiutongjiContent() {
        return xuqiutongjiContent;
    }
    /**
	 * 设置：需求详情
	 */

    public void setXuqiutongjiContent(String xuqiutongjiContent) {
        this.xuqiutongjiContent = xuqiutongjiContent;
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
        return "Xuqiutongji{" +
            ", id=" + id +
            ", zhiyaunzheId=" + zhiyaunzheId +
            ", xuqiutongjiName=" + xuqiutongjiName +
            ", xuqiutongjiPhone=" + xuqiutongjiPhone +
            ", xuqiutongjiAddress=" + xuqiutongjiAddress +
            ", xuqiutongjiContent=" + xuqiutongjiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
