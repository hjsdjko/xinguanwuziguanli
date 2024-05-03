package com.entity.model;

import com.entity.WuzidiaopeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资调配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzidiaopeiModel implements Serializable {
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
     * 小区管理员
     */
    private Integer xiaoquguanliId;


    /**
     * 调用数量
     */
    private Integer wuzidiaopeiNumber;


    /**
     * 备注
     */
    private String wuzidiaopeiContent;


    /**
     * 调配时间
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

    }
