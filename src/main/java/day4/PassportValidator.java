package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public final class PassportValidator
{
	public static final String BIRTH_OF_YEAR = "byr";
	public static final String ISSUE_YEAR = "iyr";
	public static final String EXPIRATION_YEAR = "eyr";
	public static final String HEIGHT = "hgt";
	public static final String HAIR_COLOR = "hcl";
	public static final String EYE_COLOR = "ecl";
	public static final String PASSPORT_ID = "pid";
	public static final String COUNTRY_ID = "cid";

	public static final String CENTIMETER = "cm";
	public static final String INCH = "in";


	public static boolean isPassportValid(Passport passport, boolean applyFieldValidation)
	{
		ArrayList<String> keys = new ArrayList<>(passport.getData().keySet());

		HashMap<String, String> data = passport.getData();

		boolean firstTry = keys.containsAll(Arrays.asList(BIRTH_OF_YEAR, ISSUE_YEAR, EXPIRATION_YEAR, HEIGHT, HAIR_COLOR, EYE_COLOR, PASSPORT_ID, COUNTRY_ID));
		boolean secondTry = keys.containsAll(Arrays.asList(BIRTH_OF_YEAR, ISSUE_YEAR, EXPIRATION_YEAR, HEIGHT, HAIR_COLOR, EYE_COLOR, PASSPORT_ID));

		if (firstTry || secondTry)
		{
			if (applyFieldValidation)
			{
				return isByrValid(data.get(BIRTH_OF_YEAR)) &&
						isiYrValid(data.get(ISSUE_YEAR)) &&
						isEyrValid(data.get(EXPIRATION_YEAR)) &&
						isHgtValid(data.get(HEIGHT)) &&
						isHclValid(data.get(HAIR_COLOR)) &&
						isEclValid(data.get(EYE_COLOR)) &&
						isPidValid(data.get(PASSPORT_ID));
			}

			return true;


		}

		return false;
	}

	private static boolean isByrValid(final String value)
	{
		try
		{
			int year = Integer.parseInt(value);

			return year >= 1920 && year <= 2002;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	private static boolean isiYrValid(final String value)
	{
		try
		{
			int year = Integer.parseInt(value);

			return year >= 2010 && year <= 2020;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	private static boolean isEyrValid(final String value)
	{
		try
		{
			int year = Integer.parseInt(value);

			return year >= 2020 && year <= 2030;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	private static String getHeightUnit(final String value)
	{

		String result = "";

		if (value.contains(CENTIMETER))
		{
			result = CENTIMETER;
		}
		else if (value.contains(INCH))
		{
			result = INCH;
		}

		return result;
	}

	private static boolean isHgtValid(final String value)
	{
		boolean isValid = false;

		final String unit = getHeightUnit(value);

		if (unit.equals(CENTIMETER))
		{

			try
			{
				int cmValue = Integer.parseInt(value.split(CENTIMETER)[0].trim());
				isValid = cmValue >= 150 && cmValue <= 193;
			}
			catch (Exception ignored)
			{
			}
		}
		else if (unit.equals(INCH))
		{

			try
			{
				int inchValue = Integer.parseInt(value.split(INCH)[0].trim());
				isValid = inchValue >= 59 && inchValue <= 76;
			}
			catch (Exception ignored)
			{
			}
		}

		return isValid;
	}

	private static boolean isHclValid(final String value)
	{

		return value.matches("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
	}

	private static boolean isEclValid(final String value)
	{
		return value.equals("amb") ||
				value.equals("blu") ||
				value.equals("brn") ||
				value.equals("gry") ||
				value.equals("grn") ||
				value.equals("hzl") ||
				value.equals("oth");
	}

	private static boolean isPidValid(final String value)
	{

		if (value.trim().length() == 9)
		{

			try
			{
				Integer.parseInt(value);

				return true;

			}
			catch (NumberFormatException e)
			{
				return false;
			}
		}
		return false;
	}


}
