package com.hengshuo.chengszj.service.impl.admin;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.service.admin.AdminService;



public class AdminServiceI extends BaseDao_I<Admin, Serializable>implements AdminService {
	private static final Logger log=Logger.getLogger(AdminServiceI.class.getName());
	
	public List<Admin> login(String name)  {
		
			Object[] value={name};
			String queryString="From Admin where name=?";
			List<Admin> sList=this.find(queryString, value);
			return sList;
	
	}
		
	
	
	
	
	public AdminServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminServiceI(Class<Admin> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}


	
}
