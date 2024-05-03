package com.entity.model;

import com.entity.ZhiyuanzhepaiqianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 志愿者调派
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiyuanzhepaiqianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 派遣标题
     */
    private String zhiyuanzhepaiqianName;


    /**
     * 派遣类型
     */
    private Integer zhiyuanzhepaiqianTypes;


    /**
     * 公告图片
     */
    private String zhiyuanzhepaiqianPhoto;


    /**
     * 派遣时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhiyuanzhepaiqianTime;


    /**
     * 自愿者
     */
    private Integer zhiyaunzheId;


    /**
     * 派遣详情
     */
    private String zhiyuanzhepaiqianContent;


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

    }
