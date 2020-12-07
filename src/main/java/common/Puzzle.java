package common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import day7.HandyHaversacks;

public class Puzzle
{
	private final String resource;

	public Puzzle(String resource)
	{
		this.resource = resource;
	}

	public List<String> getInput() throws URISyntaxException, IOException
	{
		return Files.readAllLines(Paths.get(HandyHaversacks.class.getClassLoader().getResource(resource).toURI()));
	}
}
