package com.entity.model;

import com.entity.WuzijuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资捐赠
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuzijuanzengModel implements Serializable {
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
     * 捐赠人
     */
    private String wuzijuanzengName;


    /**
     * 联系方式
     */
    private String wuzijuanzengPhone;


    /**
     * 捐赠人住址
     */
    private String wuzijuanzengAddress;


    /**
     * 捐赠数量
     */
    private Integer wuzijuanzengNumber;


    /**
     * 备注
     */
    private String wuzijuanzengContent;


    /**
     * 操作时间
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
	 * 获取：捐赠人
	 */
    public String getWuzijuanzengName() {
        return wuzijuanzengName;
    }


    /**
	 * 设置：捐赠人
	 */
    public void setWuzijuanzengName(String wuzijuanzengName) {
        this.wuzijuanzengName = wuzijuanzengName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getWuzijuanzengPhone() {
        return wuzijuanzengPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setWuzijuanzengPhone(String wuzijuanzengPhone) {
        this.wuzijuanzengPhone = wuzijuanzengPhone;
    }
    /**
	 * 获取：捐赠人住址
	 */
    public String getWuzijuanzengAddress() {
        return wuzijuanzengAddress;
    }


    /**
	 * 设置：捐赠人住址
	 */
    public void setWuzijuanzengAddress(String wuzijuanzengAddress) {
        this.wuzijuanzengAddress = wuzijuanzengAddress;
    }
    /**
	 * 获取：捐赠数量
	 */
    public Integer getWuzijuanzengNumber() {
        return wuzijuanzengNumber;
    }


    /**
	 * 设置：捐赠数量
	 */
    public void setWuzijuanzengNumber(Integer wuzijuanzengNumber) {
        this.wuzijuanzengNumber = wuzijuanzengNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getWuzijuanzengContent() {
        return wuzijuanzengContent;
    }


    /**
	 * 设置：备注
	 */
    public void setWuzijuanzengContent(String wuzijuanzengContent) {
        this.wuzijuanzengContent = wuzijuanzengContent;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：操作时间
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
