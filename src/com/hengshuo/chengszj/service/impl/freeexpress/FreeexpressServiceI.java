package com.hengshuo.chengszj.service.impl.freeexpress;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Freeexpress;
import com.hengshuo.chengszj.service.freeexpress.FreeexpressService;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;

public class FreeexpressServiceI extends BaseDao_I<Freeexpress, Serializable> implements FreeexpressService {
	private static final Logger log=Logger.getLogger(FreeexpressServiceI.class.getName());
	
	public FreeexpressServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeexpressServiceI(Class<Freeexpress> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkKuaiDi(String userid, String company) {
		String queryString="SELECT company FROM freeexpress WHERE userid='"+userid+"'";
		List<String> list= this.findBySQL(queryString, false);
		if (list.size()>0) {
			if (list.get(0).equals(company)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}