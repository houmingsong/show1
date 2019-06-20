

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovo.entity.MesEntity;
import com.lovo.entity.MessageEntity;
import com.lovo.entity.UserEntity;
import com.lovo.service.IMessageService;
import com.lovo.service.IUserService;

public class AcceptNewsTest {
	
	ClassPathXmlApplicationContext app = null;

	@Before
	public void before() {

		app = new ClassPathXmlApplicationContext("application.xml");
	}
	
	@Test
	public void acceptNewsFind() {
		IMessageService a = (IMessageService) app.getBean("messageService");
		List<MesEntity> list = a.show1(1);
		for (MesEntity mesEntity : list) {
			System.out.println(mesEntity);
		}		
	}
	
	@Test
	public void QueryAllUsers() {
		IMessageService a = (IMessageService) app.getBean("messageService");
		List<MessageEntity> list = a.QueryAllUsers();
		for (int i =0;i<list.size();i++) {
			System.out.println(list.get(i).getStudentName());
		}		
	}
	
	@Test
	public void login() {
		IUserService u = (IUserService) app.getBean("userService");
		UserEntity user = u.login("张三", "123");
		System.out.println(user);
	}
	
	@Test
	public void queryAlluserName() {
		IUserService u = (IUserService) app.getBean("userService");
		List<UserEntity> list = u.queryAlluserName();
		for (UserEntity uq : list) {		
			System.out.println(uq.getUsername());
		}
	}
	
}
