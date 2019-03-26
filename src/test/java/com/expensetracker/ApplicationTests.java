package com.expensetracker;

import com.expensetracker.entities.User;
import com.expensetracker.repositories.UserRepository;
import com.expensetracker.repositories.UserRoleRepository;
import com.expensetracker.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	/*
	private UserService userServiceUnderTest;
	private User user;

	@Before
	public void setUp() {
		initMocks(this);
		userServiceUnderTest = new UserService();
		user = User.builder()
				.id(1)
				.name("Gustavo")
				.lastName("Ponce")
				.email("test@test.com")
				.build();

		Mockito.when(mockUserRepository.save(any()))
				.thenReturn(user);
		Mockito.when(mockUserRepository.findByEmail(anyString()))
				.thenReturn(user);
	}

	@Test
	public void testFindUserByEmail() {
		// Setup
		final String email = "test@test.com";

		// Run the test
		final User result = userServiceUnderTest.findUserByEmail(email);

		// Verify the results
		assertEquals(email, result.getEmail());
	}

	@Test
	public void testSaveUser() {
		// Setup
		final String email = "test@test.com";

		// Run the test
		User result = userServiceUnderTest.saveUser(User.builder().build());

		// Verify the results
		assertEquals(email, result.getEmail());
	}
	*/

	@Test
	public void contextLoads() {
	}

}
