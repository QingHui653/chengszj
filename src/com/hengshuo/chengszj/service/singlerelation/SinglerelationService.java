package com.hengshuo.chengszj.service.singlerelation;

import java.io.Serializable;
import java.util.List;

import com.hengshuo.chengszj.dao.BaseDao_S;
import com.hengshuo.chengszj.model.Singlerelation;

public interface SinglerelationService extends BaseDao_S<Singlerelation, Serializable> {
	public Singlerelation findByreceiptid(int id);
	public List<Singlerelation> Byreceiptid(int id);
}
