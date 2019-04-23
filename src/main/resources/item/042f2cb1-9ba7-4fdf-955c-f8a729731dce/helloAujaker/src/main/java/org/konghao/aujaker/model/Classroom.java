package org.konghao.aujaker.model;


import javax.persistence.*;


/**
 *
 * 班级信息
 * @author ynkonghao
 *
 */
@Entity
@Table(name="t_classroom")
public class Classroom {

	/**
	 * 班级id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	/**
	 * 年级
	 */
	private Integer grade;

	/**
	 * 班级名称
	 */
	private String name;

	/**
	 * 获取班级id
	 * @return 班级id
	 */
	public int getId() {
		 return id;
	}

	/**
	 * 设置班级id
	 * @param id 班级id
	 */
	public void setId(int id) { 
		 this.id = id;
	}


	/**
	 * 获取年级
	 * @return 年级
	 */
	public Integer getGrade() {
		 return grade;
	}

	/**
	 * 设置年级
	 * @param grade 年级
	 */
	public void setGrade(Integer grade) { 
		 this.grade = grade;
	}


	/**
	 * 获取班级名称
	 * @return 班级名称
	 */
	public String getName() {
		 return name;
	}

	/**
	 * 设置班级名称
	 * @param name 班级名称
	 */
	public void setName(String name) { 
		 this.name = name;
	}


}
