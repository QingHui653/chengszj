package com.hengshuo.chengszj.service.user;

import java.io.Serializable;
import java.util.List;

import com.hengshuo.chengszj.dao.BaseDao_S;
import com.hengshuo.chengszj.model.User;

public interface UserService extends BaseDao_S<User, Serializable> {
		public List<User> findUserByUserid(String userid);
		public List<User> findUserByCity(String city);
		/**
		 * 查询余额
		 * @param userid
		 * @return
		 */
		public Double findYuE(String userid);
		

		
}
