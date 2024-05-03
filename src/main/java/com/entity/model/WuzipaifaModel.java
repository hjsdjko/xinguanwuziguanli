package com.entity.model;

import com.entity.WuzipaifaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资派发
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzipaifaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 自愿者
     */
    private Integer zhiyaunzheId;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 派发居民
     */
    private String wuzipaifaName;


    /**
     * 联系方式
     */
    private String wuzipaifaPhone;


    /**
     * 派发住址
     */
    private String wuzipaifaAddress;


    /**
     * 派发数量
     */
    private Integer wuzipaifaNumber;


    /**
     * 备注
     */
    private String wuzipaifaContent;


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

    }
