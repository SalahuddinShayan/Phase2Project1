package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assigned")
public class Assign {
	
	@Id
	@Column(name="Assign_ID")
	private int aId;
	
	@Column(name="Class_ID")
	private int classId;
	
	@Column(name="Teacher_ID")
	private int tId;
	
	@Column(name="Subject_ID")
	private int sId;

	

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	

	 
	

}
