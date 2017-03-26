package tourismExtr;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.mmt.tourism.pojo.po.Eat;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.util.GlobalUtil;

public class ApplicationTests {

	@Test
	public void contextLoads() {
		new CreateTicketTableJob().run();
		new InsertTicketJob().run();
	}
	@Test
	public void md5() {
		String pwd=GlobalUtil.md5("pwd", "d20ee58cf5c5556698a5cecb9e595401");
	    System.out.println(pwd);
	}
	@Test
	public void id() {
		String id=GlobalUtil.getModelID(Eat.class);
		System.out.println(id);
		String name="油煎毛豆腐";
		String code=GlobalUtil.getCode(name);
		System.out.println("AH_HF_C2883b5c4_"+code);
		String pid=GlobalUtil.getModelID(Photo.class);
		System.out.println(pid);
	}
	@Test
	public void random() {
		for(int i=0;i<10;i++)
		System.out.print(" "+new Random().nextInt(4));
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(" "+new Random(new Date().getTime()).nextInt(4));
	}
}
