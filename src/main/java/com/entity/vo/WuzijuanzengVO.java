package com.entity.vo;

import com.entity.WuzijuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资捐赠
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzijuanzeng")
public class WuzijuanzengVO implements Serializable {
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
     * 捐赠人
     */

    @TableField(value = "wuzijuanzeng_name")
    private String wuzijuanzengName;


    /**
     * 联系方式
     */

    @TableField(value = "wuzijuanzeng_phone")
    private String wuzijuanzengPhone;


    /**
     * 捐赠人住址
     */

    @TableField(value = "wuzijuanzeng_address")
    private String wuzijuanzengAddress;


    /**
     * 捐赠数量
     */

    @TableField(value = "wuzijuanzeng_number")
    private Integer wuzijuanzengNumber;


    /**
     * 备注
     */

    @TableField(value = "wuzijuanzeng_content")
    private String wuzijuanzengContent;


    /**
     * 操作时间
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
	 * 设置：捐赠人
	 */
    public String getWuzijuanzengName() {
        return wuzijuanzengName;
    }


    /**
	 * 获取：捐赠人
	 */

    public void setWuzijuanzengName(String wuzijuanzengName) {
        this.wuzijuanzengName = wuzijuanzengName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getWuzijuanzengPhone() {
        return wuzijuanzengPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setWuzijuanzengPhone(String wuzijuanzengPhone) {
        this.wuzijuanzengPhone = wuzijuanzengPhone;
    }
    /**
	 * 设置：捐赠人住址
	 */
    public String getWuzijuanzengAddress() {
        return wuzijuanzengAddress;
    }


    /**
	 * 获取：捐赠人住址
	 */

    public void setWuzijuanzengAddress(String wuzijuanzengAddress) {
        this.wuzijuanzengAddress = wuzijuanzengAddress;
    }
    /**
	 * 设置：捐赠数量
	 */
    public Integer getWuzijuanzengNumber() {
        return wuzijuanzengNumber;
    }


    /**
	 * 获取：捐赠数量
	 */

    public void setWuzijuanzengNumber(Integer wuzijuanzengNumber) {
        this.wuzijuanzengNumber = wuzijuanzengNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getWuzijuanzengContent() {
        return wuzijuanzengContent;
    }


    /**
	 * 获取：备注
	 */

    public void setWuzijuanzengContent(String wuzijuanzengContent) {
        this.wuzijuanzengContent = wuzijuanzengContent;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：操作时间
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
