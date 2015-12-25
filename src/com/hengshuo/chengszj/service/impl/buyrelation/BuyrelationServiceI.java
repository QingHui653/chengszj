package com.hengshuo.chengszj.service.impl.buyrelation;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Buyrelation;
import com.hengshuo.chengszj.service.buyrelation.BuyrelationService;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;

public class BuyrelationServiceI extends BaseDao_I<Buyrelation, Serializable> implements BuyrelationService {
	private static final Logger log=Logger.getLogger(BuyrelationServiceI.class.getName());
	
	
	public BuyrelationServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyrelationServiceI(Class<Buyrelation> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Buyrelation findByHelpid(Integer id) {
		String queString="from Buyrelation where helpMeId=?";
		Object[] values={id};
		return (Buyrelation) this.find(queString, values).get(0);
	}

	@Override
	public List<Buyrelation> ByHelpid(Integer id) {
		String queString="from Buyrelation where helpMeId=?";
		Object[] values={id};
		return this.find(queString, values);
	
	}

	
}
