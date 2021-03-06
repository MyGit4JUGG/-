package beans.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.dao.ProjectDAO;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;


public class TestProjectService {
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
		
	}
	@Test
	public void testFindObjects(){
		//1.获取业务对象
		ProjectService projectService=ctx.getBean(
				"projectServiceImpl",ProjectService.class);

		
		//2.调用业务对象方法
		List<Project> list=projectService.findObjects();
		System.out.println(list);
		//3.测试结果是否正确
		Assert.assertNotEquals(null, list);
		//当前表中数据总计有3条，测试数据是否都渠道了
		Assert.assertEquals(3, list.size());
		System.out.println(list);
	}
	@Test
	public void testFindPageObjects(){
		/*ProjectService projectService=ctx.getBean(
				"projectServiceImpl",ProjectService.class);
		Map<String, Object> map=projectService.findPageObjects(1);
		List<Project> list=(List<Project>)map.get("list");
		Assert.assertEquals(2, list.size());
		System.out.println("list:"+list);*/
	}
	@Test
	public void testSaveObject(){
		ProjectService projectService=ctx.getBean(
				"projectServiceImpl",ProjectService.class);
		Project p=new Project();
		p.setName("东欧游");
		p.setCode("tt-20171116-CN-BJ-001");
		p.setBeginDate(new Date());
		p.setEndDate(new Date());
		p.setValid(1);
		p.setNote("去年买了个表");
		projectService.saveObject(p);
		System.out.println("insert ok");
	}
	
	@After
	public void destroy(){
		ctx.close();
	}
	

}























