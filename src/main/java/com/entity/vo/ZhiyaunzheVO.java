package com.entity.vo;

import com.entity.ZhiyaunzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 自愿者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiyaunzhe")
public class ZhiyaunzheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 自愿者姓名
     */

    @TableField(value = "zhiyaunzhe_name")
    private String zhiyaunzheName;


    /**
     * 头像
     */

    @TableField(value = "zhiyaunzhe_photo")
    private String zhiyaunzhePhoto;


    /**
     * 自愿者联系方式
     */

    @TableField(value = "zhiyaunzhe_phone")
    private String zhiyaunzhePhone;


    /**
     * 自愿者身份证号
     */

    @TableField(value = "zhiyaunzhe_id_number")
    private String zhiyaunzheIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "zhiyaunzhe_email")
    private String zhiyaunzheEmail;


    /**
     * 住址
     */

    @TableField(value = "zhiyaunzhe_address")
    private String zhiyaunzheAddress;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 自愿者服务记录
     */

    @TableField(value = "zhiyaunzhe_content")
    private String zhiyaunzheContent;


    /**
     * 假删
     */

    @TableField(value = "zhiyaunzhe_delete")
    private Integer zhiyaunzheDelete;


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
	 * 设置：自愿者姓名
	 */
    public String getZhiyaunzheName() {
        return zhiyaunzheName;
    }


    /**
	 * 获取：自愿者姓名
	 */

    public void setZhiyaunzheName(String zhiyaunzheName) {
        this.zhiyaunzheName = zhiyaunzheName;
    }
    /**
	 * 设置：头像
	 */
    public String getZhiyaunzhePhoto() {
        return zhiyaunzhePhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setZhiyaunzhePhoto(String zhiyaunzhePhoto) {
        this.zhiyaunzhePhoto = zhiyaunzhePhoto;
    }
    /**
	 * 设置：自愿者联系方式
	 */
    public String getZhiyaunzhePhone() {
        return zhiyaunzhePhone;
    }


    /**
	 * 获取：自愿者联系方式
	 */

    public void setZhiyaunzhePhone(String zhiyaunzhePhone) {
        this.zhiyaunzhePhone = zhiyaunzhePhone;
    }
    /**
	 * 设置：自愿者身份证号
	 */
    public String getZhiyaunzheIdNumber() {
        return zhiyaunzheIdNumber;
    }


    /**
	 * 获取：自愿者身份证号
	 */

    public void setZhiyaunzheIdNumber(String zhiyaunzheIdNumber) {
        this.zhiyaunzheIdNumber = zhiyaunzheIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getZhiyaunzheEmail() {
        return zhiyaunzheEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setZhiyaunzheEmail(String zhiyaunzheEmail) {
        this.zhiyaunzheEmail = zhiyaunzheEmail;
    }
    /**
	 * 设置：住址
	 */
    public String getZhiyaunzheAddress() {
        return zhiyaunzheAddress;
    }


    /**
	 * 获取：住址
	 */

    public void setZhiyaunzheAddress(String zhiyaunzheAddress) {
        this.zhiyaunzheAddress = zhiyaunzheAddress;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：自愿者服务记录
	 */
    public String getZhiyaunzheContent() {
        return zhiyaunzheContent;
    }


    /**
	 * 获取：自愿者服务记录
	 */

    public void setZhiyaunzheContent(String zhiyaunzheContent) {
        this.zhiyaunzheContent = zhiyaunzheContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getZhiyaunzheDelete() {
        return zhiyaunzheDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setZhiyaunzheDelete(Integer zhiyaunzheDelete) {
        this.zhiyaunzheDelete = zhiyaunzheDelete;
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
