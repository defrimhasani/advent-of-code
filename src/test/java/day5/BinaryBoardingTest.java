package day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 5: Binary Boarding ---")
class BinaryBoardingTest
{

	private BinaryBoarding binaryBoarding;

	@BeforeEach
	public void setup()
	{
		this.binaryBoarding = new BinaryBoarding();
	}

	@Test
	@DisplayName("As a sanity check, look through your list of boarding passes. " +
			"What is the highest seat ID on a boarding pass?")
	void partOne() throws IOException, URISyntaxException
	{
		assertEquals(850, binaryBoarding.getPartOneResult());
	}

	@Test
	@DisplayName("Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list." +
			"What is the ID of your seat?")
	void partTwo() throws IOException, URISyntaxException
	{
		assertEquals(599, binaryBoarding.getPartTwoResult());
	}
}
