package day9;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 9: Encoding Error ---")
class EncodingErrorTest
{

	@Test
	void testSolution() throws IOException, URISyntaxException
	{
		EncodingError encodingError = new EncodingError();

		SolutionResult solution = encodingError.getSolution();

		assertEquals(731031916, solution.getPartOneResult());
		assertEquals(93396727, solution.getPartTwoResult());

	}
}
