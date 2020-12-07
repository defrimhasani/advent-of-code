package day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import common.Puzzle;

public class PassportProcessing extends Puzzle
{
	public PassportProcessing()
	{
		super("day4.txt");
	}

	public int getPartOneResult() throws IOException, URISyntaxException
	{
		return (int) getPassportData()
				.stream()
				.filter(passportDatum -> PassportValidator.isPassportValid(passportDatum, false))
				.count();

	}

	public int getPartTwoResult() throws IOException, URISyntaxException
	{
		return (int) getPassportData()
				.stream()
				.filter(passportDatum -> PassportValidator.isPassportValid(passportDatum, true))
				.count();

	}

	public List<Passport> getPassportData() throws IOException, URISyntaxException
	{
		List<Passport> list = new ArrayList<>();

		StringBuilder passportRaw = new StringBuilder();

		for (String s : getInput())
		{
			if (s.isEmpty())
			{
				list.add(getPassport(passportRaw.toString()));
				passportRaw = new StringBuilder();
			}
			else
			{
				passportRaw.append(s.endsWith(" ") ? s : s + " ");

			}
		}

		return list;
	}

	public Passport getPassport(String raw)
	{
		return new Passport(Arrays.stream(raw.split(" ")).map(s -> s.split(":"))
				.collect(Collectors.toMap(split -> split[0], split -> split[1], (a, b) -> b, HashMap::new)));
	}

}
