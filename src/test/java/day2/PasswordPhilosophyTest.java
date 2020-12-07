package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 2: Password Philosophy ---")
class PasswordPhilosophyTest
{
	private PasswordPhilosophy passwordPhilosophy;

	@BeforeEach
	public void setup() throws IOException, URISyntaxException
	{
		passwordPhilosophy = new PasswordPhilosophy();
	}

	@Test
	@DisplayName("How many passwords are valid according to their policies?")
	void partOne()
	{
		assertEquals(465, passwordPhilosophy.getPartOneResult());
	}

	@Test
	@DisplayName("How many passwords are valid according to the new interpretation of the policies?")
	void partTwo()
	{
		assertEquals(294, passwordPhilosophy.getPartTwoResult());

	}
}
