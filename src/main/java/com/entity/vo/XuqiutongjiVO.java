package com.entity.vo;

import com.entity.XuqiutongjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 需求收集
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuqiutongji")
public class XuqiutongjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 自愿者
     */

    @TableField(value = "zhiyaunzhe_id")
    private Integer zhiyaunzheId;


    /**
     * 居民
     */

    @TableField(value = "xuqiutongji_name")
    private String xuqiutongjiName;


    /**
     * 联系方式
     */

    @TableField(value = "xuqiutongji_phone")
    private String xuqiutongjiPhone;


    /**
     * 住址
     */

    @TableField(value = "xuqiutongji_address")
    private String xuqiutongjiAddress;


    /**
     * 需求详情
     */

    @TableField(value = "xuqiutongji_content")
    private String xuqiutongjiContent;


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
	 * 设置：居民
	 */
    public String getXuqiutongjiName() {
        return xuqiutongjiName;
    }


    /**
	 * 获取：居民
	 */

    public void setXuqiutongjiName(String xuqiutongjiName) {
        this.xuqiutongjiName = xuqiutongjiName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getXuqiutongjiPhone() {
        return xuqiutongjiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setXuqiutongjiPhone(String xuqiutongjiPhone) {
        this.xuqiutongjiPhone = xuqiutongjiPhone;
    }
    /**
	 * 设置：住址
	 */
    public String getXuqiutongjiAddress() {
        return xuqiutongjiAddress;
    }


    /**
	 * 获取：住址
	 */

    public void setXuqiutongjiAddress(String xuqiutongjiAddress) {
        this.xuqiutongjiAddress = xuqiutongjiAddress;
    }
    /**
	 * 设置：需求详情
	 */
    public String getXuqiutongjiContent() {
        return xuqiutongjiContent;
    }


    /**
	 * 获取：需求详情
	 */

    public void setXuqiutongjiContent(String xuqiutongjiContent) {
        this.xuqiutongjiContent = xuqiutongjiContent;
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
