package com.hengshuo.chengszj.service.impl.withdrawals;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Withdrawals;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;
import com.hengshuo.chengszj.service.withdrawals.WithdrawalsService;

public class WithdrawalsServiceI extends BaseDao_I<Withdrawals, Serializable> implements WithdrawalsService{

	private static final Logger log=Logger.getLogger(WithdrawalsServiceI.class.getName());
	
	
	public WithdrawalsServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WithdrawalsServiceI(Class<Withdrawals> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

}
