package org.zhouqinsheng.faceExam.model;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;


/**
 *
 * 用户信息表
 * @author zqs
 *
 */
@Entity
@Table(name="t_user_info")
public class UserInfo {

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
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户类型
	 */
	@Column(name="user_type")
	private Date userType;

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
	 * 获取用户名
	 * @return 用户名
	 */
	public String getUsername() {
		 return username;
	}

	/**
	 * 设置用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) { 
		 this.username = username;
	}


	/**
	 * 获取用户密码
	 * @return 用户密码
	 */
	public String getPassword() {
		 return password;
	}

	/**
	 * 设置用户密码
	 * @param password 用户密码
	 */
	public void setPassword(String password) { 
		 this.password = password;
	}


	/**
	 * 获取用户类型
	 * @return 用户类型
	 */
	public Date getUserType() {
		 return userType;
	}

	/**
	 * 设置用户类型
	 * @param userType 用户类型
	 */
	public void setUserType(Date userType) { 
		 this.userType = userType;
	}


}
