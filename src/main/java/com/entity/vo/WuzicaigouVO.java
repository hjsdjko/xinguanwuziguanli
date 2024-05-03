package com.entity.vo;

import com.entity.WuzicaigouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资采购
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzicaigou")
public class WuzicaigouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 采购员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 采购数量
     */

    @TableField(value = "wuzicaigou_number")
    private Integer wuzicaigouNumber;


    /**
     * 登记时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wuzicaigou_time")
    private Date wuzicaigouTime;


    /**
     * 备注
     */

    @TableField(value = "wuzicaigou_text")
    private String wuzicaigouText;


    /**
     * 采购审核
     */

    @TableField(value = "wuzicaigou_yesno_types")
    private Integer wuzicaigouYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "wuzicaigou_yesno_text")
    private String wuzicaigouYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 设置：采购员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：采购员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：采购数量
	 */
    public Integer getWuzicaigouNumber() {
        return wuzicaigouNumber;
    }


    /**
	 * 获取：采购数量
	 */

    public void setWuzicaigouNumber(Integer wuzicaigouNumber) {
        this.wuzicaigouNumber = wuzicaigouNumber;
    }
    /**
	 * 设置：登记时间
	 */
    public Date getWuzicaigouTime() {
        return wuzicaigouTime;
    }


    /**
	 * 获取：登记时间
	 */

    public void setWuzicaigouTime(Date wuzicaigouTime) {
        this.wuzicaigouTime = wuzicaigouTime;
    }
    /**
	 * 设置：备注
	 */
    public String getWuzicaigouText() {
        return wuzicaigouText;
    }


    /**
	 * 获取：备注
	 */

    public void setWuzicaigouText(String wuzicaigouText) {
        this.wuzicaigouText = wuzicaigouText;
    }
    /**
	 * 设置：采购审核
	 */
    public Integer getWuzicaigouYesnoTypes() {
        return wuzicaigouYesnoTypes;
    }


    /**
	 * 获取：采购审核
	 */

    public void setWuzicaigouYesnoTypes(Integer wuzicaigouYesnoTypes) {
        this.wuzicaigouYesnoTypes = wuzicaigouYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getWuzicaigouYesnoText() {
        return wuzicaigouYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setWuzicaigouYesnoText(String wuzicaigouYesnoText) {
        this.wuzicaigouYesnoText = wuzicaigouYesnoText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
