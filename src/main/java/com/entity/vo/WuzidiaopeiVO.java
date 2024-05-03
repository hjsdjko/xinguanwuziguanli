package com.entity.vo;

import com.entity.WuzidiaopeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资调配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzidiaopei")
public class WuzidiaopeiVO implements Serializable {
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
     * 小区管理员
     */

    @TableField(value = "xiaoquguanli_id")
    private Integer xiaoquguanliId;


    /**
     * 调用数量
     */

    @TableField(value = "wuzidiaopei_number")
    private Integer wuzidiaopeiNumber;


    /**
     * 备注
     */

    @TableField(value = "wuzidiaopei_content")
    private String wuzidiaopeiContent;


    /**
     * 调配时间
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
	 * 设置：小区管理员
	 */
    public Integer getXiaoquguanliId() {
        return xiaoquguanliId;
    }


    /**
	 * 获取：小区管理员
	 */

    public void setXiaoquguanliId(Integer xiaoquguanliId) {
        this.xiaoquguanliId = xiaoquguanliId;
    }
    /**
	 * 设置：调用数量
	 */
    public Integer getWuzidiaopeiNumber() {
        return wuzidiaopeiNumber;
    }


    /**
	 * 获取：调用数量
	 */

    public void setWuzidiaopeiNumber(Integer wuzidiaopeiNumber) {
        this.wuzidiaopeiNumber = wuzidiaopeiNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getWuzidiaopeiContent() {
        return wuzidiaopeiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setWuzidiaopeiContent(String wuzidiaopeiContent) {
        this.wuzidiaopeiContent = wuzidiaopeiContent;
    }
    /**
	 * 设置：调配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：调配时间
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
