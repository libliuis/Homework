package testmybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.IAccountDao;
import dao.IUserDao;
import domain.AccountUser;
import junit.framework.Assert;

public class AccountTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private IAccountDao accountDao;
	
	@Before
	public void SetUp()throws Exception{
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(in);
		session = factory.openSession();
		accountDao = session.getMapper(IAccountDao.class);
		
	}
	
	@Test
	public void testFindAll() {
		List<AccountUser> accountUsers = accountDao.findAll();
		for(AccountUser au:accountUsers) {
			System.out.println(au);
		}
		
		Assert.assertEquals(3, accountUsers.size());
	}
	
	@After
	public void tearDown() throws Exception{
		session.commit();
		session.close();
		in.close();
	}
}
