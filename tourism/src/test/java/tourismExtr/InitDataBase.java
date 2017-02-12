package tourismExtr;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class InitDataBase {
	
	
	protected static BasicDataSource dataSource;
	protected Runtime runtime;
	protected static final String sqlBinDir="D:/mysql-5.6.22-winx64/bin";
	protected static final String CDDIR="cd {sqlbindir}";
	protected static final String conSqlCMD="mysql -h{host} -P{port} -u{username} -p{password}";
	private static Logger logger = LoggerFactory.getLogger(InitDataBase.class);
	
	static{
		Properties properties=new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			dataSource=new BasicDataSource();
		    dataSource.setDriverClassName(properties.getProperty("driver"));
		    dataSource.setUrl(properties.getProperty("url"));
		    dataSource.setUsername(properties.getProperty("username"));
		    dataSource.setPassword(properties.getProperty("password"));
		} catch (IOException e) {
			logger.error("数据库连接池创建失败", e);
		}
	}
	
	public InitDataBase(){
		
	}
	public InitDataBase(Boolean isRuntime){
		if(isRuntime){
			runtime=Runtime.getRuntime();
		}
	}
	
	protected abstract void run();
	protected static String margeCmd(String cmd, String... args) {
		int index = 0, lastindex = 0;
		int i = 0;
		while (true) {
			if (i == args.length) {
				return cmd;
			}
			index = cmd.indexOf("{");
			if(index==-1)
				return cmd;
			lastindex = cmd.indexOf("}");
			cmd = cmd.replace(cmd.substring(index, lastindex + 1), args[i++]);
		}
	}

}
