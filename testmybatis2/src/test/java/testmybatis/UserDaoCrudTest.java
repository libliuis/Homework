package testmybatis;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.IUserDao;
import domain.QueryVo;
import domain.QueryVolds;
import domain.User;
import junit.framework.Assert;

public class UserDaoCrudTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private IUserDao userDao;
	
	@Before
	public void SetUp()throws Exception{
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(in);
		session = factory.openSession();
		userDao = session.getMapper(IUserDao.class);
		
	}
	
	@Test
	public void testFindOne() {
		User user = userDao.findById(41);
		System.out.println(user);
		Assert.assertEquals("张三", user.getUsername());
	}
	
	@Test
	public void testFindInIds() {
		QueryVolds volds = new QueryVolds();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(41);
		ids.add(42);
		ids.add(43);
		volds.setIds(ids);
		
		List<User>users = userDao.findInIds(volds);
		
		Assert.assertEquals(3, users.size());;
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setUserName("华泰");
		user.setUserAddress("南京市建邺区");
		user.setUserSex("男");
		user.setUserBirthday(new Date());
		
		int id =userDao.saveUser(user);
//		Assert.assertEquals(1, id);
		User savedUser = userDao.findById(user.getUserId());
		Assert.assertEquals("华泰",savedUser.getUsername());
	}
	
	@Test
	public void testUpdateUser() {
		int id=45;
		User user = userDao.findById(id);
		
		user.setUserAddress("北京市顺义区");
		int res = userDao.updateUser(user);
		
		User savedUser = userDao.findById(id);
		Assert.assertEquals("北京市顺义区", savedUser.getUserAddress());
		System.out.println(user.getUserAddress());
		System.out.println(savedUser.getUserAddress());
	}
	
	@Test 
	public void testDeleteUser() {
		int res = userDao.deleteUser(65);
		
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void testFindByName() {
		List<User> users = userDao.findByName("%王%");
				
		Assert.assertEquals(1, users.size());
		
		for(User user:users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testCount() {
		int res = userDao.count();
		
		Assert.assertEquals(17, res);
	}
	
	@Test
	public void testQueryByVo() {
		QueryVo vo = new QueryVo();
		vo.setUsername("%王%");
		vo.setAddress("%南京%");
		List<User> users = userDao.findByVo(vo);
		
		Assert.assertEquals(1, users.size());
	}
	
	
	
	@After
	public void tearDown() throws Exception{
		session.commit();
		session.close();
		in.close();
	}
}
