package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE")
public class TypeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String typeName;

	@Override
	public String toString() {
		return "TypeBean [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}