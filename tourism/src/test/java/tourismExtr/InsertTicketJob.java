package tourismExtr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmt.tourism.util.GlobalUtil;

public class InsertTicketJob extends CreateTicketTableJob {
	
	private static final String insertSql="INSERT INTO t_ticket{?}(id,setMenuId,number) VALUES(?,?,?)";	
	private static final String SelectSql="SELECT id,visitors FROM t_viewsetmenu";	
	private static Logger logger = LoggerFactory.getLogger(InsertTicketJob.class);
	@Override
	protected void run(){
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			connection.setAutoCommit(false);
			long stime=new Date().getTime();
			Map<String,Integer> params=getparams(connection);
			Iterator<Entry<String, Integer>> it=params.entrySet().iterator();
			while(it.hasNext()){
				int days=0;
				Entry<String, Integer> en=it.next();
				String id=en.getKey();
				Integer maxNo=en.getValue();
				int tableDays=createTableDays;
				while(tableDays-->0){
					long time=stime+1000*60*60*24*days;
					String dataformat=dateFormat(time,"yyyy_MM_dd");
					PreparedStatement preparedStatement=connection.prepareStatement((margeCmd(insertSql, dataformat)));
					int ticketNo=0;
					while(ticketNo++<maxNo){
						preparedStatement.setString(1, GlobalUtil.getTicketID(time));
						preparedStatement.setString(2, id);
						preparedStatement.setInt(3, ticketNo);
						preparedStatement.addBatch();
					}
					preparedStatement.executeBatch();
					days++;  
				}
			}
			connection.commit();
			logger.info("数据插入成功");
		} catch (SQLException e) {
			logger.error("数据插入失败",e);
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				logger.error("数据回滚失败",e);
			}
		}finally{
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("连接关闭失败",e);
				}
		}

	}
	
	private Map<String,Integer> getparams(Connection connection) throws SQLException{
		Map<String,Integer> map=new HashMap<String,Integer>();
		ResultSet set=connection.createStatement().executeQuery(SelectSql);
		while(set.next()){
			map.put(set.getString(1), set.getInt(2));
		}
		return map;
	}

}
