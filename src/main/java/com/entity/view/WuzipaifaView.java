package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WuzipaifaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资派发
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wuzipaifa")
public class WuzipaifaView extends WuzipaifaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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
	//级联表 自愿者
		/**
		* 自愿者姓名
		*/

		@ColumnInfo(comment="自愿者姓名",type="varchar(200)")
		private String zhiyaunzheName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String zhiyaunzhePhoto;
		/**
		* 自愿者联系方式
		*/

		@ColumnInfo(comment="自愿者联系方式",type="varchar(200)")
		private String zhiyaunzhePhone;
		/**
		* 自愿者身份证号
		*/

		@ColumnInfo(comment="自愿者身份证号",type="varchar(200)")
		private String zhiyaunzheIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String zhiyaunzheEmail;
		/**
		* 住址
		*/

		@ColumnInfo(comment="住址",type="varchar(200)")
		private String zhiyaunzheAddress;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;
		/**
		* 自愿者服务记录
		*/

		@ColumnInfo(comment="自愿者服务记录",type="text")
		private String zhiyaunzheContent;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer zhiyaunzheDelete;



	public WuzipaifaView() {

	}

	public WuzipaifaView(WuzipaifaEntity wuzipaifaEntity) {
		try {
			BeanUtils.copyProperties(this, wuzipaifaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	//级联表的get和set 自愿者

		/**
		* 获取： 自愿者姓名
		*/
		public String getZhiyaunzheName() {
			return zhiyaunzheName;
		}
		/**
		* 设置： 自愿者姓名
		*/
		public void setZhiyaunzheName(String zhiyaunzheName) {
			this.zhiyaunzheName = zhiyaunzheName;
		}

		/**
		* 获取： 头像
		*/
		public String getZhiyaunzhePhoto() {
			return zhiyaunzhePhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setZhiyaunzhePhoto(String zhiyaunzhePhoto) {
			this.zhiyaunzhePhoto = zhiyaunzhePhoto;
		}

		/**
		* 获取： 自愿者联系方式
		*/
		public String getZhiyaunzhePhone() {
			return zhiyaunzhePhone;
		}
		/**
		* 设置： 自愿者联系方式
		*/
		public void setZhiyaunzhePhone(String zhiyaunzhePhone) {
			this.zhiyaunzhePhone = zhiyaunzhePhone;
		}

		/**
		* 获取： 自愿者身份证号
		*/
		public String getZhiyaunzheIdNumber() {
			return zhiyaunzheIdNumber;
		}
		/**
		* 设置： 自愿者身份证号
		*/
		public void setZhiyaunzheIdNumber(String zhiyaunzheIdNumber) {
			this.zhiyaunzheIdNumber = zhiyaunzheIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getZhiyaunzheEmail() {
			return zhiyaunzheEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setZhiyaunzheEmail(String zhiyaunzheEmail) {
			this.zhiyaunzheEmail = zhiyaunzheEmail;
		}

		/**
		* 获取： 住址
		*/
		public String getZhiyaunzheAddress() {
			return zhiyaunzheAddress;
		}
		/**
		* 设置： 住址
		*/
		public void setZhiyaunzheAddress(String zhiyaunzheAddress) {
			this.zhiyaunzheAddress = zhiyaunzheAddress;
		}
		/**
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}

		/**
		* 获取： 自愿者服务记录
		*/
		public String getZhiyaunzheContent() {
			return zhiyaunzheContent;
		}
		/**
		* 设置： 自愿者服务记录
		*/
		public void setZhiyaunzheContent(String zhiyaunzheContent) {
			this.zhiyaunzheContent = zhiyaunzheContent;
		}

		/**
		* 获取： 假删
		*/
		public Integer getZhiyaunzheDelete() {
			return zhiyaunzheDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setZhiyaunzheDelete(Integer zhiyaunzheDelete) {
			this.zhiyaunzheDelete = zhiyaunzheDelete;
		}


	@Override
	public String toString() {
		return "WuzipaifaView{" +
			", wuziUuidNumber=" + wuziUuidNumber +
			", wuziName=" + wuziName +
			", wuziKucunNumber=" + wuziKucunNumber +
			", wuziContent=" + wuziContent +
			", wuziDelete=" + wuziDelete +
			", zhiyaunzheName=" + zhiyaunzheName +
			", zhiyaunzhePhoto=" + zhiyaunzhePhoto +
			", zhiyaunzhePhone=" + zhiyaunzhePhone +
			", zhiyaunzheIdNumber=" + zhiyaunzheIdNumber +
			", zhiyaunzheEmail=" + zhiyaunzheEmail +
			", zhiyaunzheAddress=" + zhiyaunzheAddress +
			", zhiyaunzheContent=" + zhiyaunzheContent +
			", zhiyaunzheDelete=" + zhiyaunzheDelete +
			"} " + super.toString();
	}
}
