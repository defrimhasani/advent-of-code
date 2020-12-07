package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 4: Passport Processing ---")
class PassportProcessingTest
{
	private PassportProcessing passportProcessing;

	@BeforeEach
	public void setup()
	{
		this.passportProcessing = new PassportProcessing();
	}

	@Test
	@DisplayName("Count the number of valid passports - those that have all required fields. Treat cid as optional." +
			" In your batch file, how many passports are valid?")
	void partOne() throws IOException, URISyntaxException
	{
		assertEquals(200, passportProcessing.getPartOneResult());
	}

	@Test
	@DisplayName("Count the number of valid passports - those that have all required fields and valid values." +
			" Continue to treat cid as optional. In your batch file, how many passports are valid?")
	void partTwo() throws IOException, URISyntaxException
	{
		assertEquals(116, passportProcessing.getPartTwoResult());
	}
}
