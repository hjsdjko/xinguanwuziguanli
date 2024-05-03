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
 * 物资领用归还
 *
 * @author 
 * @email
 */
@TableName("lingyongguihuan")
public class LingyongguihuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LingyongguihuanEntity() {

	}

	public LingyongguihuanEntity(T t) {
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
     * 操作类型
     */
    @ColumnInfo(comment="操作类型",type="int(11)")
    @TableField(value = "lingyongguihuan_types")

    private Integer lingyongguihuanTypes;


    /**
     * 操作数量
     */
    @ColumnInfo(comment="操作数量",type="int(11)")
    @TableField(value = "lingyongguihuan_number")

    private Integer lingyongguihuanNumber;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "lingyongguihuan_content")

    private String lingyongguihuanContent;


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
	 * 获取：操作类型
	 */
    public Integer getLingyongguihuanTypes() {
        return lingyongguihuanTypes;
    }
    /**
	 * 设置：操作类型
	 */

    public void setLingyongguihuanTypes(Integer lingyongguihuanTypes) {
        this.lingyongguihuanTypes = lingyongguihuanTypes;
    }
    /**
	 * 获取：操作数量
	 */
    public Integer getLingyongguihuanNumber() {
        return lingyongguihuanNumber;
    }
    /**
	 * 设置：操作数量
	 */

    public void setLingyongguihuanNumber(Integer lingyongguihuanNumber) {
        this.lingyongguihuanNumber = lingyongguihuanNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getLingyongguihuanContent() {
        return lingyongguihuanContent;
    }
    /**
	 * 设置：备注
	 */

    public void setLingyongguihuanContent(String lingyongguihuanContent) {
        this.lingyongguihuanContent = lingyongguihuanContent;
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
        return "Lingyongguihuan{" +
            ", id=" + id +
            ", wuziId=" + wuziId +
            ", xiaoquguanliId=" + xiaoquguanliId +
            ", lingyongguihuanTypes=" + lingyongguihuanTypes +
            ", lingyongguihuanNumber=" + lingyongguihuanNumber +
            ", lingyongguihuanContent=" + lingyongguihuanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
