package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LingyongguihuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资领用归还
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("lingyongguihuan")
public class LingyongguihuanView extends LingyongguihuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 操作类型的值
	*/
	@ColumnInfo(comment="操作类型的字典表值",type="varchar(200)")
	private String lingyongguihuanValue;

	//级联表 物资
		/**
		* 物资编号
		*/

		@ColumnInfo(comment="物资编号",type="varchar(200)")
		private String wuziUuidNumber;
		/**
		* 物资名称
		*/

		@ColumnInfo(comment="物资名称",type="varchar(200)")
		private String wuziName;
		/**
		* 物资类型
		*/
		@ColumnInfo(comment="物资类型",type="int(11)")
		private Integer wuziTypes;
			/**
			* 物资类型的值
			*/
			@ColumnInfo(comment="物资类型的字典表值",type="varchar(200)")
			private String wuziValue;
		/**
		* 物资库存
		*/

		@ColumnInfo(comment="物资库存",type="int(11)")
		private Integer wuziKucunNumber;
		/**
		* 物资详情
		*/

		@ColumnInfo(comment="物资详情",type="text")
		private String wuziContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wuziDelete;
	//级联表 小区管理员
		/**
		* 小区管理员姓名
		*/

		@ColumnInfo(comment="小区管理员姓名",type="varchar(200)")
		private String xiaoquguanliName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String xiaoquguanliPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String xiaoquguanliPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String xiaoquguanliIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String xiaoquguanliEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer xiaoquguanliDelete;



	public LingyongguihuanView() {

	}

	public LingyongguihuanView(LingyongguihuanEntity lingyongguihuanEntity) {
		try {
			BeanUtils.copyProperties(this, lingyongguihuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 操作类型的值
	*/
	public String getLingyongguihuanValue() {
		return lingyongguihuanValue;
	}
	/**
	* 设置： 操作类型的值
	*/
	public void setLingyongguihuanValue(String lingyongguihuanValue) {
		this.lingyongguihuanValue = lingyongguihuanValue;
	}


	//级联表的get和set 物资

		/**
		* 获取： 物资编号
		*/
		public String getWuziUuidNumber() {
			return wuziUuidNumber;
		}
		/**
		* 设置： 物资编号
		*/
		public void setWuziUuidNumber(String wuziUuidNumber) {
			this.wuziUuidNumber = wuziUuidNumber;
		}

		/**
		* 获取： 物资名称
		*/
		public String getWuziName() {
			return wuziName;
		}
		/**
		* 设置： 物资名称
		*/
		public void setWuziName(String wuziName) {
			this.wuziName = wuziName;
		}
		/**
		* 获取： 物资类型
		*/
		public Integer getWuziTypes() {
			return wuziTypes;
		}
		/**
		* 设置： 物资类型
		*/
		public void setWuziTypes(Integer wuziTypes) {
			this.wuziTypes = wuziTypes;
		}


			/**
			* 获取： 物资类型的值
			*/
			public String getWuziValue() {
				return wuziValue;
			}
			/**
			* 设置： 物资类型的值
			*/
			public void setWuziValue(String wuziValue) {
				this.wuziValue = wuziValue;
			}

		/**
		* 获取： 物资库存
		*/
		public Integer getWuziKucunNumber() {
			return wuziKucunNumber;
		}
		/**
		* 设置： 物资库存
		*/
		public void setWuziKucunNumber(Integer wuziKucunNumber) {
			this.wuziKucunNumber = wuziKucunNumber;
		}

		/**
		* 获取： 物资详情
		*/
		public String getWuziContent() {
			return wuziContent;
		}
		/**
		* 设置： 物资详情
		*/
		public void setWuziContent(String wuziContent) {
			this.wuziContent = wuziContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWuziDelete() {
			return wuziDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWuziDelete(Integer wuziDelete) {
			this.wuziDelete = wuziDelete;
		}
	//级联表的get和set 小区管理员

		/**
		* 获取： 小区管理员姓名
		*/
		public String getXiaoquguanliName() {
			return xiaoquguanliName;
		}
		/**
		* 设置： 小区管理员姓名
		*/
		public void setXiaoquguanliName(String xiaoquguanliName) {
			this.xiaoquguanliName = xiaoquguanliName;
		}

		/**
		* 获取： 头像
		*/
		public String getXiaoquguanliPhoto() {
			return xiaoquguanliPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setXiaoquguanliPhoto(String xiaoquguanliPhoto) {
			this.xiaoquguanliPhoto = xiaoquguanliPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getXiaoquguanliPhone() {
			return xiaoquguanliPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setXiaoquguanliPhone(String xiaoquguanliPhone) {
			this.xiaoquguanliPhone = xiaoquguanliPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getXiaoquguanliIdNumber() {
			return xiaoquguanliIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setXiaoquguanliIdNumber(String xiaoquguanliIdNumber) {
			this.xiaoquguanliIdNumber = xiaoquguanliIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getXiaoquguanliEmail() {
			return xiaoquguanliEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setXiaoquguanliEmail(String xiaoquguanliEmail) {
			this.xiaoquguanliEmail = xiaoquguanliEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getXiaoquguanliDelete() {
			return xiaoquguanliDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setXiaoquguanliDelete(Integer xiaoquguanliDelete) {
			this.xiaoquguanliDelete = xiaoquguanliDelete;
		}


	@Override
	public String toString() {
		return "LingyongguihuanView{" +
			", lingyongguihuanValue=" + lingyongguihuanValue +
			", xiaoquguanliName=" + xiaoquguanliName +
			", xiaoquguanliPhoto=" + xiaoquguanliPhoto +
			", xiaoquguanliPhone=" + xiaoquguanliPhone +
			", xiaoquguanliIdNumber=" + xiaoquguanliIdNumber +
			", xiaoquguanliEmail=" + xiaoquguanliEmail +
			", xiaoquguanliDelete=" + xiaoquguanliDelete +
			", wuziUuidNumber=" + wuziUuidNumber +
			", wuziName=" + wuziName +
			", wuziKucunNumber=" + wuziKucunNumber +
			", wuziContent=" + wuziContent +
			", wuziDelete=" + wuziDelete +
			"} " + super.toString();
	}
}
