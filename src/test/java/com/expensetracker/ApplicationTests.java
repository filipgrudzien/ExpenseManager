package com.expensetracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
