package com.entity.vo;

import com.entity.ZhiyuanzhepaiqianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 志愿者调派
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiyuanzhepaiqian")
public class ZhiyuanzhepaiqianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 派遣标题
     */

    @TableField(value = "zhiyuanzhepaiqian_name")
    private String zhiyuanzhepaiqianName;


    /**
     * 派遣类型
     */

    @TableField(value = "zhiyuanzhepaiqian_types")
    private Integer zhiyuanzhepaiqianTypes;


    /**
     * 公告图片
     */

    @TableField(value = "zhiyuanzhepaiqian_photo")
    private String zhiyuanzhepaiqianPhoto;


    /**
     * 派遣时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhiyuanzhepaiqian_time")
    private Date zhiyuanzhepaiqianTime;


    /**
     * 自愿者
     */

    @TableField(value = "zhiyaunzhe_id")
    private Integer zhiyaunzheId;


    /**
     * 派遣详情
     */

    @TableField(value = "zhiyuanzhepaiqian_content")
    private String zhiyuanzhepaiqianContent;


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
	 * 设置：派遣标题
	 */
    public String getZhiyuanzhepaiqianName() {
        return zhiyuanzhepaiqianName;
    }


    /**
	 * 获取：派遣标题
	 */

    public void setZhiyuanzhepaiqianName(String zhiyuanzhepaiqianName) {
        this.zhiyuanzhepaiqianName = zhiyuanzhepaiqianName;
    }
    /**
	 * 设置：派遣类型
	 */
    public Integer getZhiyuanzhepaiqianTypes() {
        return zhiyuanzhepaiqianTypes;
    }


    /**
	 * 获取：派遣类型
	 */

    public void setZhiyuanzhepaiqianTypes(Integer zhiyuanzhepaiqianTypes) {
        this.zhiyuanzhepaiqianTypes = zhiyuanzhepaiqianTypes;
    }
    /**
	 * 设置：公告图片
	 */
    public String getZhiyuanzhepaiqianPhoto() {
        return zhiyuanzhepaiqianPhoto;
    }


    /**
	 * 获取：公告图片
	 */

    public void setZhiyuanzhepaiqianPhoto(String zhiyuanzhepaiqianPhoto) {
        this.zhiyuanzhepaiqianPhoto = zhiyuanzhepaiqianPhoto;
    }
    /**
	 * 设置：派遣时间
	 */
    public Date getZhiyuanzhepaiqianTime() {
        return zhiyuanzhepaiqianTime;
    }


    /**
	 * 获取：派遣时间
	 */

    public void setZhiyuanzhepaiqianTime(Date zhiyuanzhepaiqianTime) {
        this.zhiyuanzhepaiqianTime = zhiyuanzhepaiqianTime;
    }
    /**
	 * 设置：自愿者
	 */
    public Integer getZhiyaunzheId() {
        return zhiyaunzheId;
    }


    /**
	 * 获取：自愿者
	 */

    public void setZhiyaunzheId(Integer zhiyaunzheId) {
        this.zhiyaunzheId = zhiyaunzheId;
    }
    /**
	 * 设置：派遣详情
	 */
    public String getZhiyuanzhepaiqianContent() {
        return zhiyuanzhepaiqianContent;
    }


    /**
	 * 获取：派遣详情
	 */

    public void setZhiyuanzhepaiqianContent(String zhiyuanzhepaiqianContent) {
        this.zhiyuanzhepaiqianContent = zhiyuanzhepaiqianContent;
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
