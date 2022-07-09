package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="Classes")
public class Classes {
	
	@Id
	@Column(name="Class_Id")
	private int classId;
	
	@Column(name="Class_Name")
	private String className;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="Expected_Duration")
	private int expectedDuration;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getExpectedDuration() {
		return expectedDuration;
	}

	public void setExpectedDuration(int expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	
	
}
