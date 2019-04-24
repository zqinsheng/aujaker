package org.zhouqinsheng.faceExam.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import java.util.Date;
import java.util.Date;


/**
 *
 * 考试信息
 * @author zqs
 *
 */
@Entity
@Table(name="t_exam_info")
public class ExamInfo {

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
	 * 考场id
	 */
	@Column(name="room_id")
	private String roomId;

	/**
	 * 监考教师id一
	 */
	@Column(name="one_teacher_id")
	private String oneTeacherId;

	/**
	 * 监考教师id二
	 */
	@Column(name="two_teacher_id")
	private String twoTeacherId;

	/**
	 * 考试开始时间
	 */
	@Column(name="start_date")
	private Date startDate;

	/**
	 * 考试结束时间
	 */
	@Column(name="end_date")
	private Date endDate;

	/**
	 * 创建日期
	 */
	@Column(name="create_date")
	private Date createDate;

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
	 * 获取考场id
	 * @return 考场id
	 */
	public String getRoomId() {
		 return roomId;
	}

	/**
	 * 设置考场id
	 * @param roomId 考场id
	 */
	public void setRoomId(String roomId) { 
		 this.roomId = roomId;
	}


	/**
	 * 获取监考教师id一
	 * @return 监考教师id一
	 */
	public String getOneTeacherId() {
		 return oneTeacherId;
	}

	/**
	 * 设置监考教师id一
	 * @param oneTeacherId 监考教师id一
	 */
	public void setOneTeacherId(String oneTeacherId) { 
		 this.oneTeacherId = oneTeacherId;
	}


	/**
	 * 获取监考教师id二
	 * @return 监考教师id二
	 */
	public String getTwoTeacherId() {
		 return twoTeacherId;
	}

	/**
	 * 设置监考教师id二
	 * @param twoTeacherId 监考教师id二
	 */
	public void setTwoTeacherId(String twoTeacherId) { 
		 this.twoTeacherId = twoTeacherId;
	}


	/**
	 * 获取考试开始时间
	 * @return 考试开始时间
	 */
	public Date getStartDate() {
		 return startDate;
	}

	/**
	 * 设置考试开始时间
	 * @param startDate 考试开始时间
	 */
	public void setStartDate(Date startDate) { 
		 this.startDate = startDate;
	}


	/**
	 * 获取考试结束时间
	 * @return 考试结束时间
	 */
	public Date getEndDate() {
		 return endDate;
	}

	/**
	 * 设置考试结束时间
	 * @param endDate 考试结束时间
	 */
	public void setEndDate(Date endDate) { 
		 this.endDate = endDate;
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
