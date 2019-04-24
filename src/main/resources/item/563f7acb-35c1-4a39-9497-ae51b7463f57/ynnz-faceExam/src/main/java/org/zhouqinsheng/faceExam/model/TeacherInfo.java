package org.zhouqinsheng.faceExam.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * 监考老师
 * @author zqs
 *
 */
@Entity
@Table(name="t_teacher_info")
public class TeacherInfo {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Lob
	@Column(name="id")
	private String id;

	/**
	 * 教师名称
	 */
	@Column(name="teacher_name")
	private String teacherName;

	/**
	 * 教师性别:1男2女
	 */
	@Column(name="gender")
	private Integer gender;

	/**
	 * 获取id
	 * @return id
	 */
	public String getId() {
		 return id;
	}

	/**
	 * 设置id
	 * @param id id
	 */
	public void setId(String id) { 
		 this.id = id;
	}


	/**
	 * 获取教师名称
	 * @return 教师名称
	 */
	public String getTeacherName() {
		 return teacherName;
	}

	/**
	 * 设置教师名称
	 * @param teacherName 教师名称
	 */
	public void setTeacherName(String teacherName) { 
		 this.teacherName = teacherName;
	}


	/**
	 * 获取教师性别:1男2女
	 * @return 教师性别:1男2女
	 */
	public Integer getGender() {
		 return gender;
	}

	/**
	 * 设置教师性别:1男2女
	 * @param gender 教师性别:1男2女
	 */
	public void setGender(Integer gender) { 
		 this.gender = gender;
	}


}
