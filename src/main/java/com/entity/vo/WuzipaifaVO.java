package com.entity.vo;

import com.entity.WuzipaifaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资派发
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzipaifa")
public class WuzipaifaVO implements Serializable {
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
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 派发居民
     */

    @TableField(value = "wuzipaifa_name")
    private String wuzipaifaName;


    /**
     * 联系方式
     */

    @TableField(value = "wuzipaifa_phone")
    private String wuzipaifaPhone;


    /**
     * 派发住址
     */

    @TableField(value = "wuzipaifa_address")
    private String wuzipaifaAddress;


    /**
     * 派发数量
     */

    @TableField(value = "wuzipaifa_number")
    private Integer wuzipaifaNumber;


    /**
     * 备注
     */

    @TableField(value = "wuzipaifa_content")
    private String wuzipaifaContent;


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
	 * 设置：派发居民
	 */
    public String getWuzipaifaName() {
        return wuzipaifaName;
    }


    /**
	 * 获取：派发居民
	 */

    public void setWuzipaifaName(String wuzipaifaName) {
        this.wuzipaifaName = wuzipaifaName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getWuzipaifaPhone() {
        return wuzipaifaPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setWuzipaifaPhone(String wuzipaifaPhone) {
        this.wuzipaifaPhone = wuzipaifaPhone;
    }
    /**
	 * 设置：派发住址
	 */
    public String getWuzipaifaAddress() {
        return wuzipaifaAddress;
    }


    /**
	 * 获取：派发住址
	 */

    public void setWuzipaifaAddress(String wuzipaifaAddress) {
        this.wuzipaifaAddress = wuzipaifaAddress;
    }
    /**
	 * 设置：派发数量
	 */
    public Integer getWuzipaifaNumber() {
        return wuzipaifaNumber;
    }


    /**
	 * 获取：派发数量
	 */

    public void setWuzipaifaNumber(Integer wuzipaifaNumber) {
        this.wuzipaifaNumber = wuzipaifaNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getWuzipaifaContent() {
        return wuzipaifaContent;
    }


    /**
	 * 获取：备注
	 */

    public void setWuzipaifaContent(String wuzipaifaContent) {
        this.wuzipaifaContent = wuzipaifaContent;
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
