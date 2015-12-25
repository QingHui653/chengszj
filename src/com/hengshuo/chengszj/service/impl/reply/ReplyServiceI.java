package com.hengshuo.chengszj.service.impl.reply;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Reply;
import com.hengshuo.chengszj.service.impl.singlerelation.SinglerelationServiceI;
import com.hengshuo.chengszj.service.reply.ReplyService;

public class ReplyServiceI extends BaseDao_I<Reply, Serializable> implements ReplyService {
	private static final Logger log=Logger.getLogger(ReplyServiceI.class.getName());

	public ReplyServiceI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyServiceI(Class<Reply> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}
	
	
}
