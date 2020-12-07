package day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import common.Puzzle;

public class CustomCustoms extends Puzzle
{
	public CustomCustoms()
	{
		super("day6.txt");
	}

	public List<Group> getGroups() throws IOException, URISyntaxException
	{
		List<Group> groups = new ArrayList<>();

		List<String> raw = new ArrayList<>();

		for (String s : getInput())
		{
			if (s.isEmpty())
			{
				Group group = new Group(raw);
				group.setPersons(raw.size());
				groups.add(group);
				raw = new ArrayList<>();
			}
			else
			{
				raw.add(s);
			}
		}
		Group group = new Group(raw);
		group.setPersons(raw.size());
		groups.add(group);

		return groups;
	}

	public int getResultForPartOne() throws IOException, URISyntaxException
	{
		int in = 0;

		HashSet<Character> characters = new HashSet<>();

		List<Group> groups = getGroups();

		for (Group group : groups)
		{
			for (String rawDatum : group.getRawData())
			{
				for (char c : rawDatum.toCharArray())
				{
					characters.add(c);
				}
			}

			in += characters.size();

			characters = new HashSet<>();
		}

		return in;
	}

	public Character[] intersect(Character[] a, Character[] b)
	{
		return Stream.of(a)
				.filter(Arrays.asList(b)::contains)
				.toArray(Character[]::new);
	}

	public long getResultForPartTwo() throws IOException, URISyntaxException
	{
		List<Group> groups = getGroups();

		for (Group group : groups)
		{
			Character[] main = group.getRawData().get(0).chars()
					.mapToObj(ch -> (char) ch)
					.toArray(Character[]::new);

			for (int i = 1; i < group.getRawData().size(); i++)
			{
				main = intersect(main, group.getRawData().get(i).chars()                 // IntStream
						.mapToObj(ch -> (char) ch)
						.toArray(Character[]::new));
			}

			group.setQuestions(main.length);
		}
		return groups.stream().mapToInt(Group::getQuestions).sum();
	}
}
