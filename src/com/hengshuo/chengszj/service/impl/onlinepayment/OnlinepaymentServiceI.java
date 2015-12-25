package com.hengshuo.chengszj.service.impl.onlinepayment;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Onlinepayment;
import com.hengshuo.chengszj.service.impl.user.UserServiceI;
import com.hengshuo.chengszj.service.onlinepayment.OnlinepaymentService;

public class OnlinepaymentServiceI extends BaseDao_I<Onlinepayment, Serializable> implements OnlinepaymentService {
	private static final Logger log=Logger.getLogger(OnlinepaymentServiceI.class.getName());

	public OnlinepaymentServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlinepaymentServiceI(Class<Onlinepayment> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}
	
}
