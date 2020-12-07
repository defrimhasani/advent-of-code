package day1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 1: Report Repair ---")
class ReportRepairTest
{
	private ReportRepair reportRepair;

	@BeforeEach
	public void setup() throws IOException, URISyntaxException
	{
		reportRepair = new ReportRepair();
	}


	@Test
	@DisplayName("Find the two entries that sum to 2020; what do you get if you multiply them together?")
	void partOne()
	{
		assertEquals(100419, reportRepair.getPartOneResult());
	}

	@Test
	@DisplayName("What is the product of the three entries that sum to 2020?")
	void partTwo()
	{
		assertEquals(265253940, reportRepair.getPartTwoResult());

	}
}
