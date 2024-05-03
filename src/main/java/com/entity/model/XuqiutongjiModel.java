package com.entity.model;

import com.entity.XuqiutongjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 需求收集
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuqiutongjiModel implements Serializable {
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
     * 居民
     */
    private String xuqiutongjiName;


    /**
     * 联系方式
     */
    private String xuqiutongjiPhone;


    /**
     * 住址
     */
    private String xuqiutongjiAddress;


    /**
     * 需求详情
     */
    private String xuqiutongjiContent;


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

    }
