package com.hengshuo.chengszj.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;

import com.hengshuo.chengszj.common.page.PageSupport;


/** 
 * 通用dao(包括增加、删除、修改、查询、支持分页、支持HQL、和面向对象)接口,其它dao接口只需继承该接口
 * @author  作者姓名 song
 * @version 创建时间：2009-9-3 下午05:14:32 
 * @version 1.1
 */

public interface BaseDao_S<T, PK extends Serializable> {
    
	/*******************以下是基本检索、增加、修改、删除操作******************/
	
	/**
	 * 存储实体到数据库
	 * @param entity 实体引用
	 * @return void
	 */
	public void save(T entity);
	
	
	/**
	 * 增加或更新实体
	 * @param entity 实体引用
	 * @return void
	 */
	public void saveOrUpdate(T entity);
	

	/**
	 * 更新实体
	 * @param entity 实体引用
	 * @return void
	 */ 
	public void update(T entity);

	/**
	 * 更新实体并加锁
	 * @param entity 实体引用
	 * @param lock 锁引用
	 * @return void
	 */ 
	public void updateWithLock(T entity, LockMode lock);


	/**
	 * 增加或更新集合中的全部实体
	 * @param entity 实体引用集合
	 * @return void 
	 */ 
	public void saveOrUpdateAll(Collection<T> entities);

	/**
	 * 删除指定的实体
	 * @param entity 实体引用
	 * @return void
	 */
	public void delete(T entity);

	/**
	 * 加锁并删除指定的实体
	 * @param entity 实体引用
	 * @param lock 锁引用
	 * @return void
	 */
	public void deleteWithLock(T entity, LockMode lock);

	/**
	 * 根据主键删除指定实体
	 * @param id 实体主键
	 * @return void
	 */
	public void deleteByKey(PK id);

	/**
	 * 根据主键加锁并删除指定的实体
	 * @param entity 实体引用
	 * @return void
	 */ 
	public void deleteByKeyWithLock(PK id, LockMode lock);

	/**
	 * 删除集合中的全部实体
	 */ 
	public void deleteAll(Collection<T> entities);

	
	/**
	 * 根据主键获取实体。如果没有相应的实体，返回 null。
	 * @param id 主键
	 * @return T 实体引用
	 */
    public T get(PK id);

    /**
     * 根据主键获取实体并加锁。如果没有相应的实体，返回 null。
     */ 
    public T getWithLock(PK id, LockMode lock);

    /**
     * 根据主键获取实体。如果没有相应的实体，抛出异常。
     * @param id 主键
	 * @return void
     */ 
    public T load(PK id);

    /** 
     * 根据主键获取实体并加锁。如果没有相应的实体，抛出异常。
     * @param id
     * @param lock
     * @return T
     */
    public T loadWithLock(PK id, LockMode lock);

    /**
     * 获取全部实体。
	 * @return T 实体引用
     */
    public List<T> loadAll();


    // -------------------- HSQL ----------------------

    /**
     * 使用HSQL语句直接增加、更新、删除实体
     * @param queryString hql语句
	 * @return 是否更新成功
     */
    public int bulkUpdate(String queryString);

    /**
     * 使用HSQL语句直接增加、更新、删除实体
     * @param queryString hql语句
	 * @return 是否更新成功
     */
    public int bulkUpdate(String queryString, Object[] values);

   /**
    * 使用HSQL语句检索数据
    * @param queryString
    * @param conf 是否使用配置HSQL
    * @return List<T>
    */
    public List<T> findByHQL(String queryString,boolean conf);
    
    /**
     * 使用HSQL语句检索数据支持翻页
     * @param queryString sql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @param conf 是否使用配置HSQL
     * @return PageSupport<T>
     */
    public PageSupport findPageByHQL(String queryString,int page,int pageSizec,boolean conf);
    /**
     * 使用SQL语句检索数据
     * @param queryString
     * @param conf 是否使用配置SQL
     * @return List<T>
     */
    public List findBySQL(String queryString,boolean conf);
    
    /**
     * 使用SQL语句检索数据支持翻页
     * @param queryString sql语句
     * @param page 当前页
     * @param pageSize 每页多少行
     * @param conf 是否使用配置SQL
     * @return PageSupport<T>
     */
    public PageSupport findPageBySQL(String queryString,int page,int pageSizec,boolean conf);

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
    public PageSupport findPageByHQLWithParamsAndValues(String queryString,int page,int pageSize,boolean conf,String[] params,Object[] values) ;
    
    
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
    public PageSupport findPageBySQLWithParamsAndValues(String queryString,int page,int pageSize,boolean conf,String[] params,Object[] values) ;
    
    
    
   /**
    * 使用带参数的HSQL语句检索数据
    * @param queryString
    * @param values
    * @return List<T>
    */
    public List<T> find(String queryString, Object[] values);

   /**
    * 使用带命名的参数的HSQL语句检索数据
    * @param queryString
    * @param paramNames
    * @param values
    * @return List<T>
    */
    public List<T> findByNamedParam(String queryString, String[] paramNames,
            Object[] values);

    /**
     * 使用命名的HSQL语句检索数据
     * @param queryName
     * @return List<T>
     */
    public List<T> findByNamedQuery(String queryName);

    /**
     * 使用带参数的命名HSQL语句检索数据
     * @param queryName
     * @param values
     * @return List<T>
     */
    public List<T> findByNamedQuery(String queryName, Object[] values);

    /**
     * 使用带命名参数的命名HSQL语句检索数据
     * @param queryName
     * @param paramNames
     * @param values
     * @return List<T>
     */
    public List<T> findByNamedQueryAndNamedParam(String queryName,
            String[] paramNames, Object[] values);

    /**
     * 使用HSQL语句检索数据，返回 Iterator
     * @param queryString
     * @return Iterator
     */
    public Iterator iterate(String queryString);

    /**
     * 使用带参数HSQL语句检索数据，返回 Iterator
     * @param queryString
     * @param values
     * @return Iterator
     */
    public Iterator iterate(String queryString, Object[] values);

    /**
     * 关闭检索返回的 Iterator
     * @param it
     */
    public void closeIterator(Iterator it);

    // -------------------------------- Criteria ------------------------------

    /**
     * 创建与会话无关的检索标准对象
     */
    public DetachedCriteria createDetachedCriteria();

   /**
    *  创建与会话绑定的检索标准对象
    * @return
    */
    public Criteria createCriteria();

   /**
    *  使用指定的检索标准检索数据
    * @param criteria
    * @return List<T>
    */
    public List<T> findByCriteria(DetachedCriteria criteria);

    /**
     * 使用指定的检索标准检索数据，返回部分记录
     * @param criteria
     * @param firstResult
     * @param maxResults
     * @return List<T>
     */
    public List<T> findByCriteria(DetachedCriteria criteria, int firstResult,
            int maxResults);

   /**
    * 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
    * @param entity
    * @param propertyNames
    * @return List<T>
    */
    public List<T> findEqualByEntity(T entity, String[] propertyNames);

   /**
    * 使用指定的实体及属性(非主键)检索（满足属性 like 串实体值）数据
    * @param entity
    * @param propertyNames
    * @return List<T>
    */
    public List<T> findLikeByEntity(T entity, String[] propertyNames);

    /**
     * 使用指定的检索标准检索数据，返回指定范围的记录
     * @param criteria
     * @return Integer
     */
    public Integer getRowCount(DetachedCriteria criteria);

   /**
    * 使用指定的检索标准检索数据，返回指定统计值
    * @param criteria
    * @param propertyName
    * @param StatName
    * @return Object
    */
    public Object getStatValue(DetachedCriteria criteria, String propertyName,
            String StatName);

    // -------------------------------- Others -------------------------------

    /**
     * 加锁指定的实体
     */
    public void lock(T entity, LockMode lockMode);

   /**
    * 强制初始化指定的实体
    * @param proxy
    */
    public void initialize(Object proxy);

    /**
     * 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
     */
    public void flush();
    /**
     * 清空缓存一级缓存数据
     * @param entityClass
     */
    public void evict(T t);
    
    /**
     * 清除二级缓存中的某条数据
     * @param entityClass 被清除数据的类
     * @param k 主键
     */
    public void evictFromFactory(Class entityClass,PK id);
    
    /**
     * 清除某个类所有实例的二级缓存
     * @param entityClass 被清除的类
     */
    public void evict(Class entityClass);
    
    //---------------------------------分页方法-------------------------------
    
    /**
	 * 根据hql语句查找前n条记录
	 * @param hql 查询语句
	 * @param top 前top条记录
	 * @return 符合条件的前top条记录
	 */
	public List<T> findTopByHql(final String hql, final int top);
	
	/**
	 * 根据映射对象做匹配查询
	 * @param obj      映射对象
	 * @param likeName 查询对象
	 * @param likeValue  查询对象所对应的值（带"%")
	 * @param page       页号
	 * @return
	 */
	public PageSupport<T> findPageByExampleLike(T obj, String likeName, String likeValue, int page, int pageSize);

	/**
	 * 根据特定的对象做分页查询，支持排序
	 * @param orderProperty 排序对象
	 * @param orderType     排序条件
	 * @param page          页号
	 * @param pageSize      页大小
	 * @return
	 */
	public PageSupport<T> findAllWithOrder(String orderProperty,String orderType, int page, int pageSize);
	
	/**
	 * 根据特定的对象做分页查询，支持排序
	 * @param obj
	 * @param orderProperty
	 * @param orderType
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageSupport<T> findPageByExampleAndOrder(T obj,String orderProperty, String orderType, int page, int pageSize);
	
	/**
	 * 根据映射对象做分页查询
	 * @param obj    映射对象
	 * @param page   页号
	 * @param pageSize  页大小
	 * @return
	 */
	public PageSupport<T> findPageByExample(T obj, int page, int pageSize) ;
	
	/**
	 * 根据页号和页面大小做分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageSupport<T> findAll(int page, int pageSize);
	/**
	 * 根据页号做分页查询
	 * @param page
	 * @return
	 */
	public PageSupport<T> findAll(int page);
	
	public void test();
}

