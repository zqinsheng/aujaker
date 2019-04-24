package org.zhouqinsheng.faceExam.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * 考生信息
 * @author zqs
 *
 */
@Entity
@Table(name="t_exam_person")
public class ExamPerson {

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
	 * 姓名
	 */
	private String personName;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 身份证号
	 */
	@Column(name="id_card")
	private String idCard;

	/**
	 * 电话号码
	 */
	private String phone;

	/**
	 * 考生照片
	 */
	@Column(name="person_photo")
	private String personPhoto;

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
	 * 获取姓名
	 * @return 姓名
	 */
	public String getPersonName() {
		 return personName;
	}

	/**
	 * 设置姓名
	 * @param personName 姓名
	 */
	public void setPersonName(String personName) { 
		 this.personName = personName;
	}


	/**
	 * 获取性别
	 * @return 性别
	 */
	public String getGender() {
		 return gender;
	}

	/**
	 * 设置性别
	 * @param gender 性别
	 */
	public void setGender(String gender) { 
		 this.gender = gender;
	}


	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public String getIdCard() {
		 return idCard;
	}

	/**
	 * 设置身份证号
	 * @param idCard 身份证号
	 */
	public void setIdCard(String idCard) { 
		 this.idCard = idCard;
	}


	/**
	 * 获取电话号码
	 * @return 电话号码
	 */
	public String getPhone() {
		 return phone;
	}

	/**
	 * 设置电话号码
	 * @param phone 电话号码
	 */
	public void setPhone(String phone) { 
		 this.phone = phone;
	}


	/**
	 * 获取考生照片
	 * @return 考生照片
	 */
	public String getPersonPhoto() {
		 return personPhoto;
	}

	/**
	 * 设置考生照片
	 * @param personPhoto 考生照片
	 */
	public void setPersonPhoto(String personPhoto) { 
		 this.personPhoto = personPhoto;
	}


}
