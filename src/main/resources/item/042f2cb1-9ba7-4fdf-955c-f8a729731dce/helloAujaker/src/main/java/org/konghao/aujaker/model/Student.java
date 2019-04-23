package org.konghao.aujaker.model;


import javax.persistence.*;
import java.util.Date;


/**
 *
 * 学生信息
 * @author ynkonghao
 *
 */
@Entity
@Table(name="t_stu")
public class Student {

	/**
	 * 学生id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	/**
	 * 学生名称
	 */
	private String name;

	/**
	 * 身份证号
	 */
	private String sfzh;

	/**
	 * 班级id
	 */
	private Integer cid;

	/**
	 * 创建日期
	 */
	@Column(name="create_date")
	private Date createDate;

	/**
	 * 获取学生id
	 * @return 学生id
	 */
	public int getId() {
		 return id;
	}

	/**
	 * 设置学生id
	 * @param id 学生id
	 */
	public void setId(int id) { 
		 this.id = id;
	}


	/**
	 * 获取学生名称
	 * @return 学生名称
	 */
	public String getName() {
		 return name;
	}

	/**
	 * 设置学生名称
	 * @param name 学生名称
	 */
	public void setName(String name) { 
		 this.name = name;
	}


	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getSfzh() {
		 return sfzh;
	}

	/**
	 * 设置身份证号
	 * @param sfzh 身份证号
	 */
	public void setSfzh(String sfzh) { 
		 this.sfzh = sfzh;
	}


	/**
	 * 获取班级id
	 * @return 班级id
	 */
	public Integer getCid() {
		 return cid;
	}

	/**
	 * 设置班级id
	 * @param cid 班级id
	 */
	public void setCid(Integer cid) { 
		 this.cid = cid;
	}


	/**
	 * 获取创建日期
	 * @return 创建日期
	 */
	public Date getCreateDate() {
		 return createDate;
	}

	/**
	 * 设置创建日期
	 * @param createDate 创建日期
	 */
	public void setCreateDate(Date createDate) { 
		 this.createDate = createDate;
	}


}
