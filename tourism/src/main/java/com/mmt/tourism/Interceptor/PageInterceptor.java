package com.mmt.tourism.Interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmt.tourism.util.Page;

//分页拦截器
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor {

	private Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
	@Override
	public Object intercept(Invocation Invocation) throws Throwable {
		StatementHandler statementHandler=(StatementHandler)Invocation.getTarget();
		//数据对象，封装了mybatis配置文件对象属性
		MetaObject metaObject=MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		//获取mybatis配置文件对象
		MappedStatement mappedStatement= (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		//获取配置xml文件中insert delete update select元素标签的id值
		String id=mappedStatement.getId();
		BoundSql boundSql= statementHandler.getBoundSql();
		//获取原始的sql语句
		String sql=boundSql.getSql();
		if(id.matches(pageingExpr)){//对末尾有Page的sql标签相应的sql语句操作
			//查询总条数，完善Page信息
			int totalNumber=handler(sql,Invocation,metaObject);
			
			Page page=new Page();
			page.setTotalNumber(totalNumber);
			
			String pageSql=sql+" lIMIT "+page.getDbindex()+","+page.getDbNumber();
			//设置mybatis的属性值(替换sql语句)
			
			logger.info("分页sql>>>"+pageSql);
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		if(!id.matches(pageingExpr))
			logger.info("sql>>>"+sql);
		return Invocation.proceed();
	}

	private int handler(String sql, Invocation invocation, MetaObject metaObject) throws SQLException {
		String countSql="SELECT COUNT(*) FROM ("+sql+")a";
		//{@Signature(args)}值
		Connection connection=(Connection) invocation.getArgs()[0];
		PreparedStatement preparedStatement= connection.prepareStatement(countSql);
		//获取参数信息类
		ParameterHandler parameterHandler= (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
	    //设置参数值
		parameterHandler.setParameters(preparedStatement);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
			return resultSet.getInt(1);
		return 0;
	}

	@Override
	public Object plugin(Object target) {//拦截对象
		//使得自身可代理拦截对象(target对象为@Signature(type)指定的类)
		return Plugin.wrap(target, this);
	}

	private String pageingExpr;
	@Override
	public void setProperties(Properties properties) {
		pageingExpr=properties.getProperty("pageingExpr");
	}

}
