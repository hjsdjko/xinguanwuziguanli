package com.entity.model;

import com.entity.ZhiyaunzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 自愿者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiyaunzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 自愿者姓名
     */
    private String zhiyaunzheName;


    /**
     * 头像
     */
    private String zhiyaunzhePhoto;


    /**
     * 自愿者联系方式
     */
    private String zhiyaunzhePhone;


    /**
     * 自愿者身份证号
     */
    private String zhiyaunzheIdNumber;


    /**
     * 邮箱
     */
    private String zhiyaunzheEmail;


    /**
     * 住址
     */
    private String zhiyaunzheAddress;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 自愿者服务记录
     */
    private String zhiyaunzheContent;


    /**
     * 假删
     */
    private Integer zhiyaunzheDelete;


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
	 * 获取：自愿者姓名
	 */
    public String getZhiyaunzheName() {
        return zhiyaunzheName;
    }


    /**
	 * 设置：自愿者姓名
	 */
    public void setZhiyaunzheName(String zhiyaunzheName) {
        this.zhiyaunzheName = zhiyaunzheName;
    }
    /**
	 * 获取：头像
	 */
    public String getZhiyaunzhePhoto() {
        return zhiyaunzhePhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setZhiyaunzhePhoto(String zhiyaunzhePhoto) {
        this.zhiyaunzhePhoto = zhiyaunzhePhoto;
    }
    /**
	 * 获取：自愿者联系方式
	 */
    public String getZhiyaunzhePhone() {
        return zhiyaunzhePhone;
    }


    /**
	 * 设置：自愿者联系方式
	 */
    public void setZhiyaunzhePhone(String zhiyaunzhePhone) {
        this.zhiyaunzhePhone = zhiyaunzhePhone;
    }
    /**
	 * 获取：自愿者身份证号
	 */
    public String getZhiyaunzheIdNumber() {
        return zhiyaunzheIdNumber;
    }


    /**
	 * 设置：自愿者身份证号
	 */
    public void setZhiyaunzheIdNumber(String zhiyaunzheIdNumber) {
        this.zhiyaunzheIdNumber = zhiyaunzheIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getZhiyaunzheEmail() {
        return zhiyaunzheEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setZhiyaunzheEmail(String zhiyaunzheEmail) {
        this.zhiyaunzheEmail = zhiyaunzheEmail;
    }
    /**
	 * 获取：住址
	 */
    public String getZhiyaunzheAddress() {
        return zhiyaunzheAddress;
    }


    /**
	 * 设置：住址
	 */
    public void setZhiyaunzheAddress(String zhiyaunzheAddress) {
        this.zhiyaunzheAddress = zhiyaunzheAddress;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：自愿者服务记录
	 */
    public String getZhiyaunzheContent() {
        return zhiyaunzheContent;
    }


    /**
	 * 设置：自愿者服务记录
	 */
    public void setZhiyaunzheContent(String zhiyaunzheContent) {
        this.zhiyaunzheContent = zhiyaunzheContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getZhiyaunzheDelete() {
        return zhiyaunzheDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setZhiyaunzheDelete(Integer zhiyaunzheDelete) {
        this.zhiyaunzheDelete = zhiyaunzheDelete;
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
