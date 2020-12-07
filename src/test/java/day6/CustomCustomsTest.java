package day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 6: Custom Customs ---")
class CustomCustomsTest
{
	private CustomCustoms customCustoms;

	@BeforeEach
	public void setup()
	{
		customCustoms = new CustomCustoms();
	}

	@Test
	@DisplayName("For each group, count the number of questions to which anyone answered \"yes\". What is the sum of those counts?")
	void partOne() throws IOException, URISyntaxException
	{
		assertEquals(6662, customCustoms.getResultForPartOne());
	}

	@Test
	@DisplayName("For each group, count the number of questions to which everyone answered \"yes\". What is the sum of those counts?")
	void partTwo() throws IOException, URISyntaxException
	{
		assertEquals(3382, customCustoms.getResultForPartTwo());
	}
}
