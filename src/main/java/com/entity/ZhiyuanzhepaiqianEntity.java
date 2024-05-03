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
 * 志愿者调派
 *
 * @author 
 * @email
 */
@TableName("zhiyuanzhepaiqian")
public class ZhiyuanzhepaiqianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiyuanzhepaiqianEntity() {

	}

	public ZhiyuanzhepaiqianEntity(T t) {
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
     * 派遣标题
     */
    @ColumnInfo(comment="派遣标题",type="varchar(200)")
    @TableField(value = "zhiyuanzhepaiqian_name")

    private String zhiyuanzhepaiqianName;


    /**
     * 派遣类型
     */
    @ColumnInfo(comment="派遣类型",type="int(11)")
    @TableField(value = "zhiyuanzhepaiqian_types")

    private Integer zhiyuanzhepaiqianTypes;


    /**
     * 公告图片
     */
    @ColumnInfo(comment="公告图片",type="varchar(200)")
    @TableField(value = "zhiyuanzhepaiqian_photo")

    private String zhiyuanzhepaiqianPhoto;


    /**
     * 派遣时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="派遣时间",type="timestamp")
    @TableField(value = "zhiyuanzhepaiqian_time")

    private Date zhiyuanzhepaiqianTime;


    /**
     * 自愿者
     */
    @ColumnInfo(comment="自愿者",type="int(11)")
    @TableField(value = "zhiyaunzhe_id")

    private Integer zhiyaunzheId;


    /**
     * 派遣详情
     */
    @ColumnInfo(comment="派遣详情",type="text")
    @TableField(value = "zhiyuanzhepaiqian_content")

    private String zhiyuanzhepaiqianContent;


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
	 * 获取：派遣标题
	 */
    public String getZhiyuanzhepaiqianName() {
        return zhiyuanzhepaiqianName;
    }
    /**
	 * 设置：派遣标题
	 */

    public void setZhiyuanzhepaiqianName(String zhiyuanzhepaiqianName) {
        this.zhiyuanzhepaiqianName = zhiyuanzhepaiqianName;
    }
    /**
	 * 获取：派遣类型
	 */
    public Integer getZhiyuanzhepaiqianTypes() {
        return zhiyuanzhepaiqianTypes;
    }
    /**
	 * 设置：派遣类型
	 */

    public void setZhiyuanzhepaiqianTypes(Integer zhiyuanzhepaiqianTypes) {
        this.zhiyuanzhepaiqianTypes = zhiyuanzhepaiqianTypes;
    }
    /**
	 * 获取：公告图片
	 */
    public String getZhiyuanzhepaiqianPhoto() {
        return zhiyuanzhepaiqianPhoto;
    }
    /**
	 * 设置：公告图片
	 */

    public void setZhiyuanzhepaiqianPhoto(String zhiyuanzhepaiqianPhoto) {
        this.zhiyuanzhepaiqianPhoto = zhiyuanzhepaiqianPhoto;
    }
    /**
	 * 获取：派遣时间
	 */
    public Date getZhiyuanzhepaiqianTime() {
        return zhiyuanzhepaiqianTime;
    }
    /**
	 * 设置：派遣时间
	 */

    public void setZhiyuanzhepaiqianTime(Date zhiyuanzhepaiqianTime) {
        this.zhiyuanzhepaiqianTime = zhiyuanzhepaiqianTime;
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
	 * 获取：派遣详情
	 */
    public String getZhiyuanzhepaiqianContent() {
        return zhiyuanzhepaiqianContent;
    }
    /**
	 * 设置：派遣详情
	 */

    public void setZhiyuanzhepaiqianContent(String zhiyuanzhepaiqianContent) {
        this.zhiyuanzhepaiqianContent = zhiyuanzhepaiqianContent;
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
        return "Zhiyuanzhepaiqian{" +
            ", id=" + id +
            ", zhiyuanzhepaiqianName=" + zhiyuanzhepaiqianName +
            ", zhiyuanzhepaiqianTypes=" + zhiyuanzhepaiqianTypes +
            ", zhiyuanzhepaiqianPhoto=" + zhiyuanzhepaiqianPhoto +
            ", zhiyuanzhepaiqianTime=" + DateUtil.convertString(zhiyuanzhepaiqianTime,"yyyy-MM-dd") +
            ", zhiyaunzheId=" + zhiyaunzheId +
            ", zhiyuanzhepaiqianContent=" + zhiyuanzhepaiqianContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
