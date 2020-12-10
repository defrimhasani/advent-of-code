package day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("--- Day 10: Adapter Array ---")
class AdapterArrayTest
{

	private AdapterArray adapterArray;

	@BeforeEach
	public void setup() throws IOException, URISyntaxException
	{
		adapterArray = new AdapterArray();
	}

	@Test
	@DisplayName("What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?")
	void partOne()
	{
		assertEquals(2482, adapterArray.partOne());
	}

	@Test
	@DisplayName("What is the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device?")
	void partTwo()
	{
		assertEquals(96717311574016L, adapterArray.partTwo());
	}
}
