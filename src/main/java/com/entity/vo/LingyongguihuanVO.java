package com.entity.vo;

import com.entity.LingyongguihuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资领用归还
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lingyongguihuan")
public class LingyongguihuanVO implements Serializable {
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
     * 操作类型
     */

    @TableField(value = "lingyongguihuan_types")
    private Integer lingyongguihuanTypes;


    /**
     * 操作数量
     */

    @TableField(value = "lingyongguihuan_number")
    private Integer lingyongguihuanNumber;


    /**
     * 备注
     */

    @TableField(value = "lingyongguihuan_content")
    private String lingyongguihuanContent;


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
	 * 设置：操作类型
	 */
    public Integer getLingyongguihuanTypes() {
        return lingyongguihuanTypes;
    }


    /**
	 * 获取：操作类型
	 */

    public void setLingyongguihuanTypes(Integer lingyongguihuanTypes) {
        this.lingyongguihuanTypes = lingyongguihuanTypes;
    }
    /**
	 * 设置：操作数量
	 */
    public Integer getLingyongguihuanNumber() {
        return lingyongguihuanNumber;
    }


    /**
	 * 获取：操作数量
	 */

    public void setLingyongguihuanNumber(Integer lingyongguihuanNumber) {
        this.lingyongguihuanNumber = lingyongguihuanNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getLingyongguihuanContent() {
        return lingyongguihuanContent;
    }


    /**
	 * 获取：备注
	 */

    public void setLingyongguihuanContent(String lingyongguihuanContent) {
        this.lingyongguihuanContent = lingyongguihuanContent;
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
