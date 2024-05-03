package com.entity.model;

import com.entity.WuzicaigouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资采购
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzicaigouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 采购员
     */
    private Integer yonghuId;


    /**
     * 采购数量
     */
    private Integer wuzicaigouNumber;


    /**
     * 登记时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wuzicaigouTime;


    /**
     * 备注
     */
    private String wuzicaigouText;


    /**
     * 采购审核
     */
    private Integer wuzicaigouYesnoTypes;


    /**
     * 审核结果
     */
    private String wuzicaigouYesnoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
