package day10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Puzzle;

public class AdapterArray extends Puzzle
{
	private final List<Integer> data;

	private final Map<String, Long> cache;


	public AdapterArray() throws IOException, URISyntaxException
	{
		super("day10.txt");

		data = getInput().stream().map(Integer::parseInt).collect(Collectors.toList());
		data.sort(Integer::compareTo);
		cache = new HashMap<>();
	}

	public int partOne()
	{

		AtomicInteger differenceOfOne = new AtomicInteger(1);
		AtomicInteger differenceOfThree = new AtomicInteger(1);


		IntStream.range(1, data.size()).forEach(i -> {

			int difference = data.get(i) - data.get(i - 1);

			if (difference == 1)
			{
				differenceOfOne.getAndIncrement();
			}
			else if (difference == 3)
			{
				differenceOfThree.getAndIncrement();
			}

		});

		return differenceOfOne.get() * differenceOfThree.get();
	}


	public long partTwo()
	{

		data.add(0, 0);
		data.add(data.get(data.size() - 1) + 3);

		return getArrangements(data);
	}

	private long getArrangements(List<Integer> inputs)
	{
		if (inputs.size() == 1)
			return 1;

		long arrangements = 0;
		int index = 1;
		int current = inputs.get(0);
		while (inputs.size() > index && inputs.get(index) - current < 4)
		{
			List<Integer> subList = inputs.subList(index, inputs.size());
			String subListStr = Arrays.toString(subList.toArray(new Integer[0]));

			if (cache.containsKey(subListStr))
				arrangements += cache.get(subListStr);
			else
			{
				long subArrangements = getArrangements(subList);
				cache.put(subListStr, subArrangements);
				arrangements += subArrangements;
			}
			index++;
		}
		return arrangements;
	}
}
