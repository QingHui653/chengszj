package com.hengshuo.chengszj.service.impl.singlerelation;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Singlerelation;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;
import com.hengshuo.chengszj.service.singlerelation.SinglerelationService;

public class SinglerelationServiceI extends BaseDao_I<Singlerelation, Serializable>implements SinglerelationService {
	private static final Logger log=Logger.getLogger(SinglerelationServiceI.class.getName());
	
	public SinglerelationServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinglerelationServiceI(Class<Singlerelation> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Singlerelation findByreceiptid(int id) {
		String query="from Singlerelation where receiptid=?";
		Object[] values={id};
		return (Singlerelation) this.find(query, values).get(0);
	}

	@Override
	public List<Singlerelation> Byreceiptid(int id) {
		// TODO Auto-generated method stub
		String query="from Singlerelation where receiptid=?";
		Object[] values={id};
		return this.find(query, values);
	
	}

}
