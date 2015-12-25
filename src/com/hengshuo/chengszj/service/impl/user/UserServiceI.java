package com.hengshuo.chengszj.service.impl.user;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.impl.admin.AdminServiceI;
import com.hengshuo.chengszj.service.user.UserService;

public class UserServiceI extends BaseDao_I<User, Serializable> implements UserService {
	private static final Logger log=Logger.getLogger(UserServiceI.class.getName());
	
	public UserServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserServiceI(Class<User> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> findUserByUserid(String userid) {
		String query="from User where userid=?";
		Object[] value={userid};
		List<User> list=this.find(query, value);
		return list;
	}

	@Override
	public List<User> findUserByCity(String city) {
		String query="from User where city=? and status=?";
		Object[] value={city,"Y"};
		List<User> list=this.find(query, value);
		return list;
	}
	@Override
	public Double findYuE(String userid) {
		String query="from User where userid=?";
		Object[] value={userid};
		List<User> list=this.find(query, value);
		return list.get(0).getBalance();
	}

	

	

}
