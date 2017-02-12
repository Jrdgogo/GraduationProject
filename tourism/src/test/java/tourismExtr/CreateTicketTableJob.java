package tourismExtr;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmt.tourism.dao.TicketMapper;
import com.sun.corba.se.spi.protocol.InitialServerRequestDispatcher;

public class CreateTicketTableJob extends InitDataBase{
	

	private static final String createTicketTableSql="CREATE TABLE IF NOT EXISTS t_ticket{?}("
				/*主键*/
				+"id VARCHAR(32) PRIMARY KEY,"
				/*套餐id*/
				+"setMenuId VARCHAR(32),"
				/*票号*/
				+"number TINYINT NOT NULL,"
				/*状态  0未出售   1已出售 */
				+"status BIT NOT NULL DEFAULT 0,"
				/*创建时间*/
				+"createDate TIMESTAMP NOT NULL DEFAULT current_timestamp,"
				/*更新时间*/
				+"CONSTRAINT fk_ticket{?} FOREIGN KEY(setMenuId) REFERENCES t_viewsetmenu(id));";
    private Integer createTableDays=15;
    private static Logger logger = LoggerFactory.getLogger(CreateTicketTableJob.class);

	@Override
	protected void run() {
		try {
			Statement statement=dataSource.getConnection().createStatement(); 
			int days=0;
			long time=new Date().getTime();
			while(createTableDays-->0){
				String dataformat=dateFormat(time+1000*60*60*24*days,"yyyy_MM_dd");
				statement.execute(margeCmd(createTicketTableSql, dataformat,dataformat));
				logger.info("t_ticket"+dataformat+"表创建成功");
				days++;  
			}
		} catch (SQLException e) {
			logger.info("t_ticket表创建失败");
		}
		
	}

	private String dateFormat(long date, String pattern) {
		return new SimpleDateFormat(pattern).format(new Date(date));
	}

	
}
