package com.hengshuo.chengszj.service.backset;

import java.io.Serializable;
import java.util.List;

import com.hengshuo.chengszj.dao.BaseDao_S;
import com.hengshuo.chengszj.model.Backset;

public interface BacksetService extends BaseDao_S<Backset, Serializable> {
		public List<Backset> findBacksetsByType(String type);
		public List<String> findPrice(String type);
}
