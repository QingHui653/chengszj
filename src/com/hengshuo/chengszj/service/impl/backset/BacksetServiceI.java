package com.hengshuo.chengszj.service.impl.backset;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Backset;
import com.hengshuo.chengszj.service.backset.BacksetService;

public class BacksetServiceI extends BaseDao_I<Backset, Serializable> implements BacksetService  {
		private static final Logger log=Logger.getLogger(BacksetServiceI.class.getName());
	
	
	public BacksetServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BacksetServiceI(Class<Backset> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Backset> findBacksetsByType(String type) {
		String queryString="from Backset where type=?";
		Object[] values={type};
		return this.find(queryString, values);
	}

	@Override
	public List<String> findPrice(String type) {
		String queryString="SELECT NAME FROM backset WHERE TYPE='"+type+"'";
		return this.findBySQL(queryString, false);
		
		
	}
	
}
