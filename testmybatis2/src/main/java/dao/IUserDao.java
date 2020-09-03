package dao;

import java.util.List;

import domain.QueryVo;
import domain.QueryVolds;
import domain.User;

public interface IUserDao {
	int saveUser(User user);
	List<User> findAll();
	User findById(Integer userId);
	int updateUser(User user);
	int deleteUser(Integer userid);
	List<User> findByName(String username);
	int count();
	List<User> findByVo(QueryVo queryVo);
	List<User> findInIds(QueryVolds queryVolds);
}
