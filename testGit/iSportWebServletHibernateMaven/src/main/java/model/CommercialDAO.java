package model;

import java.util.List;

import model.bean.CommercialBean;

public interface CommercialDAO {

	CommercialBean select(int CommercialId);

	List<CommercialBean> select();

	boolean insert(CommercialBean bean);

	CommercialBean update(CommercialBean bean);

	boolean delete(int CommercialId);

}