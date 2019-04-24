package org.zhouqinsheng.faceExam.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;


/**
 *
 * 考场信息
 * @author zqs
 *
 */
@Entity
@Table(name="t_exam_room")
public class ExamRoom {

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
	 * 考场名称
	 */
	@Column(name="exam_name")
	private String examName;

	/**
	 * 考试地点
	 */
	@Column(name="exam_address")
	private String examAddress;

	/**
	 * 考场人数
	 */
	@Column(name="person_num")
	private Date personNum;

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
	 * 获取考场名称
	 * @return 考场名称
	 */
	public String getExamName() {
		 return examName;
	}

	/**
	 * 设置考场名称
	 * @param examName 考场名称
	 */
	public void setExamName(String examName) { 
		 this.examName = examName;
	}


	/**
	 * 获取考试地点
	 * @return 考试地点
	 */
	public String getExamAddress() {
		 return examAddress;
	}

	/**
	 * 设置考试地点
	 * @param examAddress 考试地点
	 */
	public void setExamAddress(String examAddress) { 
		 this.examAddress = examAddress;
	}


	/**
	 * 获取考场人数
	 * @return 考场人数
	 */
	public Date getPersonNum() {
		 return personNum;
	}

	/**
	 * 设置考场人数
	 * @param personNum 考场人数
	 */
	public void setPersonNum(Date personNum) { 
		 this.personNum = personNum;
	}


}
