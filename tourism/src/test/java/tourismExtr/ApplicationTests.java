package tourismExtr;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.mmt.tourism.pojo.po.Eat;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.pojo.po.ViewSetMenu;
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
		String name="三河马蹄酥";//食品名
		String code=GlobalUtil.getCode(name);
		System.out.println("AH_HF_PBC1b005a"+code);//景点代码
		String pid=GlobalUtil.getModelID(Photo.class);
		System.out.println(pid);
	}
	@Test
	public void viewid() {
		String id=GlobalUtil.getModelID(View.class);
		System.out.println(id);
		String name="";//景点名
		String code=GlobalUtil.getCode(name);
		System.out.println("AH_HF_"+code);//城市代码
	}
	@Test
	public void viewSetmenuid() {
		String id=GlobalUtil.getModelID(ViewSetMenu.class);
		System.out.println(id);
		
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
