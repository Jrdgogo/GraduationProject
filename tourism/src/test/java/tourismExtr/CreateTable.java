package tourismExtr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTable extends InitDataBase {
	
	private List<String> cmdarray=new ArrayList<String>();
	
	private static final String createSqlCMD="source {filePathName}";
	private static Logger logger = LoggerFactory.getLogger(CreateTable.class);
	public CreateTable() {
		super(true);
		initCommands();
	}

	private void initCommands() {
		cmdarray.add(sqlBinDir.substring(0, 2));
		cmdarray.add(margeCmd(CDDIR,sqlBinDir));
		cmdarray.add(margeCmd(conSqlCMD,"localhost","3306",dataSource.getUsername(),dataSource.getPassword()));
	    File file=new File(new File("").getAbsolutePath()+"/src/test/java/sql");
	    if(!file.exists())
	    	throw new RuntimeException("未找到sql目录，请确定是否位于test/java包下");
	    if(!file.isDirectory()||file.listFiles().length<=0)
	    	throw new RuntimeException("未找到sql文件");
	    for(File sqlFile:file.listFiles()){
	    	if(!sqlFile.getName().endsWith(".sql"))
	    		continue;
	    	cmdarray.add(margeCmd(createSqlCMD,sqlFile.getAbsolutePath()));
	    }
	}

	@Override
	protected void run(){
		try {
			Process process=runtime.exec(cmdarray.toArray(new String[cmdarray.size()]));
		    process.waitFor();
		    if(process.exitValue()==0)
		    	logger.info("数据库表初始化完成");
		} catch (IOException e) {
			logger.info("数据库表初始化失败",e);
		} catch (InterruptedException e) {
			logger.info("等待数据库表初始化错误",e);
		}

	}

}
