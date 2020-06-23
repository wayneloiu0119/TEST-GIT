package model;

import java.util.List;

import model.bean.TypeBean;

public interface TypeDAO {

	TypeBean select(int typeid);

	List<TypeBean> select();

	TypeBean insert(TypeBean bean);

	TypeBean update(String typeName, int typeId);

	boolean delete(int typeId);

}