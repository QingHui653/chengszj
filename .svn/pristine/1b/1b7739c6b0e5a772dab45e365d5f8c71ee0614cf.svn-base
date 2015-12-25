package com.hengshuo.chengszj.service.impl.helpmebuy;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Helpmebuy;
import com.hengshuo.chengszj.service.helpmebuy.HelpmebuyService;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;

public class HelpmebuyServiceI extends BaseDao_I<Helpmebuy, Serializable> implements HelpmebuyService {
	private static final Logger log=Logger.getLogger(HelpmebuyServiceI.class.getName());
	
	
	public HelpmebuyServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HelpmebuyServiceI(Class<Helpmebuy> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Helpmebuy> findHelpmebuys(String userid, String time) {
		String query="from Helpmebuy where userid=? and time=?";
		Object[] values={userid,time};
		return this.find(query, values);
	}

	@Override
	public List<Helpmebuy> ListHelpmebuys(String userid) {
		String query="from Helpmebuy where userid=?";
		Object[] values={userid};
		return this.find(query, values);
	}

}
