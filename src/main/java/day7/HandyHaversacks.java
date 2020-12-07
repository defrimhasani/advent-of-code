package day7;

import static java.util.Arrays.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import common.Puzzle;
import javafx.util.Pair;

public class HandyHaversacks extends Puzzle
{
	public static final String NO_OTHER_BAGS = "no other bags.";
	public static final String SHINY_GOLD = "shiny gold";

	protected static List<Bag> bags;

	public HandyHaversacks() throws IOException, URISyntaxException
	{
		super("day7.txt");

		bags = getInput().stream().map(HandyHaversacks::getColorLine).collect(Collectors.toList());
	}

	public static Bag getColorLine(final String rawLine)
	{
		String[] data = rawLine.split("contain");

		String colorName = data[0].trim().replaceAll("bags", "").trim();

		String contentRaw = data[1].trim();

		Bag colorLine = new Bag(colorName);

		if (!contentRaw.contains(NO_OTHER_BAGS))
		{
			String[] colorsContent = contentRaw.split(",");

			stream(colorsContent).forEach(s -> {

				int amountOfColor = Integer.parseInt(s.replaceAll("\\D+", ""));

				String color = amountOfColor > 1 ? s.replaceAll("[0-9]", "").trim().replaceAll("bags", "").trim()
						: s.replaceAll("[0-9]", "").trim().replaceAll("bag", "").trim();

				colorLine.addColor(amountOfColor, color.replaceAll("\\.", "").trim());
			});

		}

		return colorLine;

	}

	private static Bag getLine(final String bagName)
	{
		return bags.stream().filter(c -> c.getColor().equalsIgnoreCase(bagName)).findFirst().get();
	}

	private static List<Bag> lines(final String name)
	{
		return bags.stream().filter(c -> c.getColor().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	public static int countBagsForGoldBag(final String bagName)
	{
		List<Bag> lines = lines(bagName);

		int res = 1;

		res += lines.stream().mapToInt(line -> line.getContains().stream()
				.mapToInt(contain -> (contain.getKey() * countBagsForGoldBag(contain.getValue()))).sum()).sum();

		return res;
	}

	public static boolean theBagContainsShinyGoldBags(final String bagName)
	{
		for (Pair<Integer, String> sugBag : getLine(bagName).getContains())
		{
			if (sugBag.getValue().equals(SHINY_GOLD))
			{
				return true;
			}
		}

		for (Pair<Integer, String> sugBag : getLine(bagName).getContains())
		{
			boolean contains = theBagContainsShinyGoldBags(sugBag.getValue());

			if (contains)
				return true;
		}

		return false;

	}

	public int getPartOneResult()
	{
		return (int) bags.stream().filter(bag -> theBagContainsShinyGoldBags(bag.getColor())).count();

	}

	public int getPartTwoResult()
	{
		return countBagsForGoldBag(SHINY_GOLD) - 1;
	}
}
