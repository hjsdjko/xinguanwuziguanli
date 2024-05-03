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
 * 物资采购
 *
 * @author 
 * @email
 */
@TableName("wuzicaigou")
public class WuzicaigouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzicaigouEntity() {

	}

	public WuzicaigouEntity(T t) {
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
     * 采购员
     */
    @ColumnInfo(comment="采购员",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 采购数量
     */
    @ColumnInfo(comment="采购数量",type="int(11)")
    @TableField(value = "wuzicaigou_number")

    private Integer wuzicaigouNumber;


    /**
     * 登记时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="登记时间",type="date")
    @TableField(value = "wuzicaigou_time")

    private Date wuzicaigouTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "wuzicaigou_text")

    private String wuzicaigouText;


    /**
     * 采购审核
     */
    @ColumnInfo(comment="采购审核",type="int(11)")
    @TableField(value = "wuzicaigou_yesno_types")

    private Integer wuzicaigouYesnoTypes;


    /**
     * 审核结果
     */
    @ColumnInfo(comment="审核结果",type="text")
    @TableField(value = "wuzicaigou_yesno_text")

    private String wuzicaigouYesnoText;


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
	 * 获取：采购员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：采购员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：采购数量
	 */
    public Integer getWuzicaigouNumber() {
        return wuzicaigouNumber;
    }
    /**
	 * 设置：采购数量
	 */

    public void setWuzicaigouNumber(Integer wuzicaigouNumber) {
        this.wuzicaigouNumber = wuzicaigouNumber;
    }
    /**
	 * 获取：登记时间
	 */
    public Date getWuzicaigouTime() {
        return wuzicaigouTime;
    }
    /**
	 * 设置：登记时间
	 */

    public void setWuzicaigouTime(Date wuzicaigouTime) {
        this.wuzicaigouTime = wuzicaigouTime;
    }
    /**
	 * 获取：备注
	 */
    public String getWuzicaigouText() {
        return wuzicaigouText;
    }
    /**
	 * 设置：备注
	 */

    public void setWuzicaigouText(String wuzicaigouText) {
        this.wuzicaigouText = wuzicaigouText;
    }
    /**
	 * 获取：采购审核
	 */
    public Integer getWuzicaigouYesnoTypes() {
        return wuzicaigouYesnoTypes;
    }
    /**
	 * 设置：采购审核
	 */

    public void setWuzicaigouYesnoTypes(Integer wuzicaigouYesnoTypes) {
        this.wuzicaigouYesnoTypes = wuzicaigouYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getWuzicaigouYesnoText() {
        return wuzicaigouYesnoText;
    }
    /**
	 * 设置：审核结果
	 */

    public void setWuzicaigouYesnoText(String wuzicaigouYesnoText) {
        this.wuzicaigouYesnoText = wuzicaigouYesnoText;
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
        return "Wuzicaigou{" +
            ", id=" + id +
            ", wuziId=" + wuziId +
            ", yonghuId=" + yonghuId +
            ", wuzicaigouNumber=" + wuzicaigouNumber +
            ", wuzicaigouTime=" + DateUtil.convertString(wuzicaigouTime,"yyyy-MM-dd") +
            ", wuzicaigouText=" + wuzicaigouText +
            ", wuzicaigouYesnoTypes=" + wuzicaigouYesnoTypes +
            ", wuzicaigouYesnoText=" + wuzicaigouYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
