package com.hengshuo.chengszj.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.OrderEnum;
import com.hengshuo.chengszj.dao.BaseDao_S;


/**
 * 通用dao接口的实现类
 * @author 作者姓名 song
 * @version 创建时间：2009-9-18 上午10:05:18
 * @version 1.1
 */
public class BaseDao_I<T, PK extends Serializable> extends
		HibernateDaoSupport implements BaseDao_S<T, PK> {

//	protected final Log log = LogFactory.getLog(getClass());

	protected final Logger log=Logger.getLogger(BaseDao_I.class.getName()) ;

	protected Class<T> entityClass;

	public BaseDao_I(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public BaseDao_I() {
		
	}

//	 -------------------- 基本检索、增加、修改、删除操作 --------------------

    // 根据主键获取实体。如果没有相应的实体，返回 null。
    public T get(PK id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    // 根据主键获取实体并加锁。如果没有相应的实体，返回 null。
    public T getWithLock(PK id, LockMode lock) {
        T t = (T) getHibernateTemplate().get(entityClass, id, lock);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }

    // 根据主键获取实体。如果没有相应的实体，抛出异常。
    public T load(PK id) {
        return (T) getHibernateTemplate().load(entityClass, id);
    }

    // 根据主键获取实体并加锁。如果没有相应的实体，抛出异常。
    public T loadWithLock(PK id, LockMode lock) {
        T t = (T) getHibernateTemplate().load(entityClass, id, lock);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }

    // 获取全部实体。
    public List<T> loadAll() {
        return (List<T>) getHibernateTemplate().loadAll(entityClass);
    }

    // loadAllWithLock() ?

    // 更新实体
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    // 更新实体并加锁
    public void updateWithLock(T entity, LockMode lock) {
        getHibernateTemplate().update(entity, lock);
        this.flush(); // 立即刷新，否则锁不会生效。
    }

    // 存储实体到数据库
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    // saveWithLock()？

    // 增加或更新实体
    public void saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    // 增加或更新集合中的全部实体
    public void saveOrUpdateAll(Collection<T> entities) {
        getHibernateTemplate().saveOrUpdateAll(entities);
    }

    // 删除指定的实体
    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    // 加锁并删除指定的实体
    public void deleteWithLock(T entity, LockMode lock) {
        getHibernateTemplate().delete(entity, lock);
        this.flush(); // 立即刷新，否则锁不会生效。
    }

    // 根据主键删除指定实体
    public void deleteByKey(PK id) {
        this.delete(this.load(id));
    }

    // 根据主键加锁并删除指定的实体
    public void deleteByKeyWithLock(PK id, LockMode lock) {
        this.deleteWithLock(this.load(id), lock);
    }

    // 删除集合中的全部实体
    public void deleteAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    // -------------------- HSQL ----------------------------------------------

    // 使用HSQL语句直接增加、更新、删除实体,有sql注入危险
    public int bulkUpdate(String queryString) {
        return getHibernateTemplate().bulkUpdate(queryString);
    }

    // 使用带参数的HSQL语句增加、更新、删除实体
    public int bulkUpdate(String queryString, Object[] values) {
        return getHibernateTemplate().bulkUpdate(queryString, values);
    }

    // 使用HSQL语句检索数据/有sql注入危危险
    public List findByHQL(String queryString,boolean conf) {
    	if(conf){
    		return getSession().getNamedQuery(queryString).list();
    	}else{
    		getHibernateTemplate().setCacheQueries(true);
    		return getHibernateTemplate().find(queryString);
    	}
    }
    
    // 使用SQL语句检索数据/有sql注入危危险
    public List findBySQL(String queryString,boolean conf) {
    	if(conf==true){
    		return getSession().getNamedQuery(queryString).list();
    	}else{
    	return getSession().createSQLQuery(queryString).list();
    	}
    }
    
    /**
     * 使用HSQL语句检索数据支持翻页/有sql注入危危险
     * @param queryString hql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @return PageSupport<T>
     */
    public PageSupport findPageByHQL(String queryString,int page,int pageSize,boolean conf) {
    	PageSupport ps=null;
    	if(conf){
    		ps=new PageSupport(page, pageSize,getSession().getNamedQuery(queryString));
    	}else{
    		ps=new PageSupport(page, pageSize,getSession().createQuery(queryString));
    	}
    	return  ps;
    }
    
    
    /**
     * 使用SQL语句检索数据支持翻页/有sql注入危危险
     * @param queryString hql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @return PageSupport<T>
     */
    public PageSupport findPageBySQL(String queryString,int page,int pageSize,boolean conf) {
    	PageSupport ps=null;
    	if(conf){
    		ps=new PageSupport(page, pageSize,getSession().getNamedQuery(queryString));
    	}else{
    		ps=new PageSupport(page, pageSize,getSession().createSQLQuery(queryString));
    	}
    	return  ps;
    }
    
    /**
     * TODO test 
     * 使用HSQL语句检索数据支持翻页/无sql注入危危险
     * @param queryString hql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @param params 参数名称列表,无参数可以设置成NULL
     * @param values 参数值列表,无参数可以设置成NULL
     * @return PageSupport<T>
     */
    public PageSupport findPageByHQLWithParamsAndValues(String queryString,int page,int pageSize,boolean conf,String[] params,Object[] values) {
    	PageSupport ps=null;
    	Query query=null;
    	if(conf){
    		query=getSession().getNamedQuery(queryString);
    		if(null!=params){
    		for(int j=0;j<params.length;j++){
    			query.setParameter(params[j], values[j]);
    		}
    		}
    		ps=new PageSupport(page, pageSize,query);
    	}else{
    		query=getSession().createQuery(queryString);
    		if(null!=params){
    		for(int j=0;j<params.length;j++){
    			query.setParameter(params[j], values[j]);
    		}
    			
    		}
    		ps=new PageSupport(page, pageSize,query);
    	}
    	return  ps;
    }
    
    
    
    /**
     * TODO test 
     * 使用SQL语句检索数据支持翻页/无sql注入危危险
     * @param queryString hql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @param params 参数名称列表,无参数可以设置成NULL
     * @param values 参数值列表,无参数可以设置成NULL
     * @return PageSupport<T>
     */
    public PageSupport findPageBySQLWithParamsAndValues(String queryString,int page,int pageSize,boolean conf,String[] params,Object[] values) {
    	PageSupport ps=null;
    	Query query=null;
    	if(conf){
    		query=getSession().getNamedQuery(queryString);
    		if(null!=params){
    		for(int j=0;j<params.length;j++){
    			query.setParameter(params[j], values[j]);
    		}
    		}
    		ps=new PageSupport(page, pageSize,query);
    	}else{
    		query=getSession().createSQLQuery(queryString);
    		if(null!=params){
    		for(int j=0;j<params.length;j++){
    			query.setParameter(params[j], values[j]);
    		}
    			
    		}
    		ps=new PageSupport(page, pageSize,query);
    	}
    	return  ps;
    }
    
    
   

    // 使用带参数的HSQL语句检索数据
    public List find(String queryString, Object[] values) {
        return getHibernateTemplate().find(queryString, values);
    }

    // 使用带命名的参数的HSQL语句检索数据
    public List findByNamedParam(String queryString, String[] paramNames,
            Object[] values) {
        return getHibernateTemplate().findByNamedParam(queryString, paramNames,
                values);
    }

    // 使用命名的HSQL语句检索数据/有sql注入危危险
    public List findByNamedQuery(String queryName) {
        return getHibernateTemplate().findByNamedQuery(queryName);
    }

    // 使用带参数的命名HSQL语句检索数据
    public List findByNamedQuery(String queryName, Object[] values) {
        return getHibernateTemplate().findByNamedQuery(queryName, values);
    }

    // 使用带命名参数的命名HSQL语句检索数据
    public List findByNamedQueryAndNamedParam(String queryName,
            String[] paramNames, Object[] values) {
        return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
                paramNames, values);
    }

    // 使用HSQL语句检索数据，返回 Iterator /有sql注入危危险
    public Iterator iterate(String queryString) {
        return getHibernateTemplate().iterate(queryString);
    }

    // 使用带参数HSQL语句检索数据，返回 Iterator
    public Iterator iterate(String queryString, Object[] values) {
        return getHibernateTemplate().iterate(queryString, values);
    }

    // 关闭检索返回的 Iterator
    public void closeIterator(Iterator it) {
        getHibernateTemplate().closeIterator(it);
    }

    // -------------------------------- Criteria ------------------------------

    // 创建与会话无关的检索标准
    public DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(this.entityClass);
    }

    // 创建与会话绑定的检索标准
    public Criteria createCriteria() {
        return this.createDetachedCriteria().getExecutableCriteria(
                this.getSession());
    }

    // 检索满足标准的数据
    public List findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    // 检索满足标准的数据，返回指定范围的记录
    public List findByCriteria(DetachedCriteria criteria, int firstResult,
            int maxResults) {
        return getHibernateTemplate().findByCriteria(criteria, firstResult,
                maxResults);
    }

    // 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
    public List<T> findEqualByEntity(T entity, String[] propertyNames) {
        Criteria criteria = this.createCriteria();
        Example exam = Example.create(entity);
        exam.excludeZeroes();
        String[] defPropertys = getSessionFactory().getClassMetadata(
                entityClass).getPropertyNames();
        for (String defProperty : defPropertys) {
            int ii = 0;
            for (ii = 0; ii < propertyNames.length; ++ii) {
                if (defProperty.equals(propertyNames[ii])) {
                    criteria.addOrder(Order.asc(defProperty));
                    break;
                }
            }
            if (ii == propertyNames.length) {
                exam.excludeProperty(defProperty);
            }
        }
        criteria.add(exam);
        return (List<T>) criteria.list();
    }

    // 使用指定的实体及属性检索（满足属性 like 串实体值）数据
    public List<T> findLikeByEntity(T entity, String[] propertyNames) {
        Criteria criteria = this.createCriteria();
        for (String property : propertyNames) {
            try {
                Object value = org.apache.commons.beanutils.PropertyUtils.getProperty(entity, property);
                if (value instanceof String) {
                    criteria.add(Restrictions.like(property, (String) value,
                            MatchMode.ANYWHERE));
                    criteria.addOrder(Order.asc(property));
                } else {
                    criteria.add(Restrictions.eq(property, value));
                    criteria.addOrder(Order.asc(property));
                }
            } catch (Exception ex) {
                // 忽略无效的检索参考数据。
            }
        }
        return (List<T>) criteria.list();
    }

    // 使用指定的检索标准获取满足标准的记录数
    public Integer getRowCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List list = this.findByCriteria(criteria, 0, 1);
        return (Integer) list.get(0);
    }

    // 使用指定的检索标准检索数据，返回指定统计值(max,min,avg,sum)
    public Object getStatValue(DetachedCriteria criteria, String propertyName,
            String StatName) {
        if (StatName.toLowerCase().equals("max"))
            criteria.setProjection(Projections.max(propertyName));
        else if (StatName.toLowerCase().equals("min"))
            criteria.setProjection(Projections.min(propertyName));
        else if (StatName.toLowerCase().equals("avg"))
            criteria.setProjection(Projections.avg(propertyName));
        else if (StatName.toLowerCase().equals("sum"))
            criteria.setProjection(Projections.sum(propertyName));
        else
            return null;
        List list = this.findByCriteria(criteria, 0, 1);
        return list.get(0);
    }

    // -------------------------------- Others --------------------------------

    // 加锁指定的实体
    public void lock(T entity, LockMode lock) {
        getHibernateTemplate().lock(entity, lock);
    }

    // 强制初始化指定的实体
    public void initialize(Object proxy) {
        getHibernateTemplate().initialize(proxy);
    }

    // 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
    public void flush() {
        getHibernateTemplate().flush();
    }



	/**
	 * 根据页号做分页查询
	 * @param page
	 * @return
	 */
	public PageSupport<T> findAll(int page) {
    
		PageSupport<T> ps = new PageSupport<T>(page);
		findPageByCriteria(getSession().createCriteria(entityClass), ps);
		return ps;
	}

	/**
	 * 根据页号和页面大小做分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageSupport<T> findAll(int page, int pageSize) {
    
		PageSupport<T> ps = new PageSupport<T>(page, pageSize);
		findPageByCriteria(getSession().createCriteria(entityClass), ps);
		return ps;
	}

	/**
	 * 根据映射对象做分页查询
	 * @param obj    映射对象
	 * @param page   页号
	 * @param pageSize  页大小
	 * @return
	 */
	public PageSupport<T> findPageByExample(T obj, int page, int pageSize) {

		PageSupport<T> ps = new PageSupport<T>(page, pageSize);
		findPageByCriteria(getSession().createCriteria(entityClass).add(
				Example.create(obj)), ps);
		return ps;
	}

	/**
	 * 根据特定的对象做分页查询，支持排序
	 * @param obj
	 * @param orderProperty
	 * @param orderType
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageSupport<T> findPageByExampleAndOrder(T obj,
			String orderProperty, String orderType, int page, int pageSize) {

		PageSupport<T> ps = new PageSupport<T>(page, pageSize);
		Criteria cr = getSession().createCriteria(entityClass).add(
				Example.create(obj));
		Order order;
		if (OrderEnum.DESC.equals(orderType)) {
			order = Order.desc(orderProperty);
		} else {
			order = Order.asc(orderProperty);
		}
		findPageByCriteria(cr, order, ps);
		return ps;
	}

	/**
	 * 根据特定的对象做分页查询，支持排序
	 * @param orderProperty 排序对象
	 * @param orderType     排序条件
	 * @param page          页号
	 * @param pageSize      页大小
	 * @return
	 */
	public PageSupport<T> findAllWithOrder(String orderProperty,
			String orderType, int page, int pageSize)	{

		PageSupport<T> ps = new PageSupport<T>(page, pageSize);
		Criteria cr = getSession().createCriteria(entityClass);
		Order order;
		if(OrderEnum.DESC.equals(orderType))
		{
			order = Order.desc(orderProperty);
		}
		else
		{
			order = Order.asc(orderProperty);
		}
		findPageByCriteria(cr, order, ps);
		return ps;
	}
	/**
	 * 通过DetachedCriteria来查询，带分页支持.该方法不支持带order的查询
	 * @param criteria Criteria实例
	 * @param ps 分页对象，要先设定ps的当前页
	 * @return ps 分页包装类
	 */
	protected PageSupport findPageByCriteria(Criteria criteria, PageSupport ps) {
		try{
		if (criteria == null || ps == null)
		{
			return ps;
		}
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		List<T> items = (List<T>) criteria.setFirstResult((ps.getStartPage()-1)*ps.getPageSize())
				.setMaxResults(ps.getPageSize()).list();
//		List<T> items = (List<T>) criteria.setFirstResult(ps.getStartPage())
//		.setMaxResults(ps.getPageSize()).list();
//		criteria.setFirstResult(0).setMaxResults(ps.getPageSize());
		ps.setResult(items);
		ps.setTotalCount(totalCount);
		}catch(Exception e){
			e.printStackTrace();
//			this.messages=messages.pressError( "通过DetachedCriteria来查询，带分页支持.该方法不支持带order的查询:"+e.getMessage(), log);
		}finally{
//			closeSession();
		}
		return ps;
	}

	/**
	 * 通过Criteria来查询，带分页支持.该方法支持带order的查询
	 * @param criteria Criteria对象
	 * @param orders 排序类型
	 * @param ps 分页对象
	 * @return ps 分页包装类
	 */
	protected PageSupport findPageByCriteria(Criteria criteria,
			org.hibernate.criterion.Order[] orders, PageSupport ps) {
		try{
		if (criteria == null || ps == null)
			return ps;
		int totalCount = ((Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
//		ps.setTotalCount(totalCount);
		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		if (orders != null) {
			boolean haveId = false;
			for (int i = 0; i < orders.length; i++) {
				if (orders[i].toString().toLowerCase().startsWith("id ")
						|| orders[i].toString().toLowerCase()
								.startsWith("fid ")) {
					haveId = true;
				}
				criteria.addOrder(orders[i]);
			}
			if (!haveId) {// ??????????????id???id??
				criteria.addOrder(Order.asc("id"));
			}
		}
//		List items = criteria.setFirstResult(ps.getStartPage()).setMaxResults(
//				ps.getPageSize()).list();
//		ps.setResult(items);
		
//		log.debug(ps.startPage);
//		ps=new PageSupport(ps.startPage,ps.getPageSize(),criteria); //注意此处不要调用ps.getStartPage()
		List<T> items = (List<T>) criteria.setFirstResult((ps.getStartPage()-1)*ps.getPageSize())
		.setMaxResults(ps.getPageSize()).list();
ps.setResult(items);
ps.setTotalCount(totalCount);
		}catch(Exception e){
			e.printStackTrace();
//			this.messages=messages.pressError( "通过Criteria来查询，带分页支持.该方法支持带order的查询:"+e.getMessage(), log);
		}finally{
//			closeSession();
		}
		return ps;
	}

	/**
	 * 通过DetachedCriteria来查询，带分页支持.该方法支持带order的查询
	 * @param criteria Criteria对象
	 * @param order 排序类型
	 * @param ps 分页对象
	 */
	protected void findPageByCriteria(Criteria criteria,
			Order order, PageSupport<T> ps) {
		findPageByCriteria(criteria,
				new org.hibernate.criterion.Order[] { order }, ps);
	}

	/**
	 * 查询符合条件的记录，并返回从startIndex开始的前pageSize条记录
	 * @param obj 查询对象
	 * @param pageSize 页数据条目大小
	 * @param session Hibernate访问的session
	 * @param startIndex 开始序号
	 * @return
	 */
	
	protected List<T> findByQuery(Query obj, int pageSize, int startIndex) {
		if (pageSize > -1) {// change by lvzf -1表显示全部
			obj.setMaxResults(pageSize);
		}

		obj.setFirstResult(startIndex); // 获取记录数
		return (List<T>) obj.list();
	}

	/**
	 * 根据hql语句查找前n条记录
	 * @param hql 查询语句
	 * @param top 前top条记录
	 * @return 符合条件的前top条记录
	 */
	
	public List<T> findTopByHql(final String hql, final int top) {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query obj = session.createQuery(hql);
						return findByQuery(obj, top, 0);
					}
				});
	}


	/**
	 * 根据映射对象做匹配查询
	 * @param obj 映射对象
	 * @param likeName 查询对象
	 * @param likeValue 查询对象所对应的值（带"%")
	 * @param page 页号
	 * @return
	 */
	public PageSupport<T> findPageByExampleLike(T obj, String likeName,
			String likeValue, int page, int pageSize) {

		PageSupport<T> ps = new PageSupport<T>(page, pageSize);
		Criteria cr = getSession().createCriteria(entityClass).add(
				Example.create(obj));
		cr.add(Restrictions.like(likeName, likeValue, MatchMode.ANYWHERE));
		findPageByCriteria(cr, ps);
		return ps;
	}

	
	public void evict(T t) {
		
		this.getHibernateTemplate().evict(t);
	}

	public void evictFromFactory(Class entityClass, PK k) {
		
		this.getSessionFactory().evict(entityClass, k);
	}

	public void evict(Class entityClass) {
		
		this.getSessionFactory().evict(entityClass);
	}
	
	
	public void test (){
		log.debug("测试成功——————————————————————————————————");
	}

}
