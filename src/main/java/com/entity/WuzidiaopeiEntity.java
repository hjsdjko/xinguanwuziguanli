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
 * 物资调配
 *
 * @author 
 * @email
 */
@TableName("wuzidiaopei")
public class WuzidiaopeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuzidiaopeiEntity() {

	}

	public WuzidiaopeiEntity(T t) {
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
     * 调用数量
     */
    @ColumnInfo(comment="调用数量",type="int(11)")
    @TableField(value = "wuzidiaopei_number")

    private Integer wuzidiaopeiNumber;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "wuzidiaopei_content")

    private String wuzidiaopeiContent;


    /**
     * 调配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="调配时间",type="timestamp")
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
	 * 获取：调用数量
	 */
    public Integer getWuzidiaopeiNumber() {
        return wuzidiaopeiNumber;
    }
    /**
	 * 设置：调用数量
	 */

    public void setWuzidiaopeiNumber(Integer wuzidiaopeiNumber) {
        this.wuzidiaopeiNumber = wuzidiaopeiNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getWuzidiaopeiContent() {
        return wuzidiaopeiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setWuzidiaopeiContent(String wuzidiaopeiContent) {
        this.wuzidiaopeiContent = wuzidiaopeiContent;
    }
    /**
	 * 获取：调配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：调配时间
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
        return "Wuzidiaopei{" +
            ", id=" + id +
            ", wuziId=" + wuziId +
            ", xiaoquguanliId=" + xiaoquguanliId +
            ", wuzidiaopeiNumber=" + wuzidiaopeiNumber +
            ", wuzidiaopeiContent=" + wuzidiaopeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
