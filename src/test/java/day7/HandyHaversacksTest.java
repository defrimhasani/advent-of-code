package day7;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 7: Handy Haversacks ---")
class HandyHaversacksTest
{
	private HandyHaversacks handyHaversacks;

	@BeforeEach
	public void setup() throws IOException, URISyntaxException
	{
		handyHaversacks = new HandyHaversacks();
	}

	@Test
	@DisplayName("How many bag colors can eventually contain at least one shiny gold bag?")
	void partOne()
	{
		assertEquals(185, handyHaversacks.getPartOneResult());
	}

	@Test
	@DisplayName("How many individual bags are required inside your single shiny gold bag?")
	void partTwo()
	{
		assertEquals(89084, handyHaversacks.getPartTwoResult());
	}
}
