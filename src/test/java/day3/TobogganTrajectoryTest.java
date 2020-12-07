package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 3: Toboggan Trajectory ---")
class TobogganTrajectoryTest
{
	private TobogganTrajectory tobogganTrajectory;

	@BeforeEach
	public void setup() throws IOException, URISyntaxException
	{
		tobogganTrajectory = new TobogganTrajectory();

	}

	@Test
	@DisplayName("Starting at the top-left corner of your map and following a slope of right 3 and down 1," +
			" how many trees would you encounter?")
	void partOne()
	{
		assertEquals(205, tobogganTrajectory.getPartOneResult());
	}

	@Test
	@DisplayName("What do you get if you multiply together the number of trees encountered on each of the listed slopes?")
	void partTwo()
	{
		assertEquals(3952146825L, tobogganTrajectory.getPartTwoResult());
	}
}
