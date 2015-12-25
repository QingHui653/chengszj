package com.hengshuo.chengszj.service.impl.receipt;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.service.receipt.ReceiptService;

public class ReceiptServiceI extends BaseDao_I<Receipt, Serializable> implements ReceiptService {
	private static final Logger log=Logger.getLogger(ReceiptServiceI.class.getName());
	
	
	public ReceiptServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiptServiceI(Class<Receipt> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Receipt> findReceipts(String userid, String time) {
			String query="From Receipt where userid=? and time=?";
			Object[] values={userid,time};
			
		return this.find(query, values);
	}

	@Override
	public List<Receipt> ListReceipts(String userid) {
		String query="From Receipt where userid=?";
		Object[] values={userid};
		
		return this.find(query, values);
	}

}
