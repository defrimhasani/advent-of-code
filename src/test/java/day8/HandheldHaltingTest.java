package day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 8: Handheld Halting ---")
class HandheldHaltingTest
{

	@Test
	@DisplayName("Run your copy of the boot code. Immediately before any instruction is executed a second time," +
			" what value is in the accumulator?")
	void partOne() throws IOException, URISyntaxException
	{
		HandheldHaltingPt1 partOneSolution = new HandheldHaltingPt1();
		assertEquals(2014, partOneSolution.getPartOneResult());
	}

	@Test
	@DisplayName("Fix the program so that it terminates normally by changing exactly one jmp (to nop) or nop (to jmp)." +
			" What is the value of the accumulator after the program terminates?")
	void partTwo() throws IOException, URISyntaxException
	{
		HandheldHaltingPt2 partTwoSolution = new HandheldHaltingPt2();
		assertEquals(2251, partTwoSolution.getPartTwoResult());
	}
}
