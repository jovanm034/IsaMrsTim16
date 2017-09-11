package isamrs.rest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


import isamrs.rest.controller.UserController;
import isamrs.rest.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {
	
	@Autowired
	UserController userCtrl;
	
	@Test
	public void registerUserAlreadyExist() throws Exception
	{
		User g = new User("David", "Vuletas", "davidvuletas@gmail.com", "123", "123");
		int size = userCtrl.getUsers().getBody().getSize();
		userCtrl.createUser(g);
		assertEquals(size,userCtrl.getUsers().getBody().getSize());
	}
	
	@Test
	public void badLogin() throws Exception
	{
		User u = new User();
		u.setEmail("neki@gmail.com");
		u.setPassword("1234");
		assertEquals(userCtrl.login(u).getStatusCode(),HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void goodLogin() throws Exception
	{
		User u = new User();
		u.setEmail("karacbranko@gmail.com");
		u.setPassword("123");
		assertEquals(userCtrl.login(u).getStatusCode(),HttpStatus.OK);

	}
	
	@Test
	public void updateUser() throws Exception
	{
		for (User u : userCtrl.getUsers().getBody()) {
			if(u.getEmail().equals("karacbranko@gmail.com"))
			{
				u.setLastName("Brankovic");
				assertEquals(HttpStatus.ACCEPTED,userCtrl.editeUser(u.getId(), u).getStatusCode());
				return;
			}
		}
	}

}
