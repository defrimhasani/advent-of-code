package day11;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import common.Puzzle;

public class SeatingSystem extends Puzzle
{
	public SeatingSystem()
	{
		super("day11.txt");
	}

	public int partOne() throws IOException, URISyntaxException
	{
		List<String> input = getInput();
		char[][] allSeats = input.stream().map(String::toCharArray).toArray(char[][]::new);

		boolean same = false;
		char[][] updated = allSeats;
		while (!same)
		{
			char[][] temp = reformatPart(updated);
			same = true;
			for (int i = 0; i < updated.length; i++)
			{
				if (!same)
					break;
				for (int j = 0; j < updated[i].length; j++)
				{
					if (temp[i][j] != updated[i][j])
					{
						same = false;
						break;
					}
				}
			}
			updated = temp;
		}

		int occupied = 0;

		for (char[] chars : updated)
		{
			for (char aChar : chars)
			{
				if (aChar == '#')
				{
					occupied++;
				}
			}
		}

		//PART 2
		same = false;
		updated = allSeats;
		while (!same)
		{
			char[][] temp = updatePart2(updated);
			same = true;
			for (int i = 0; i < updated.length; i++)
			{
				if (!same)
					break;
				for (int j = 0; j < updated[i].length; j++)
				{
					if (temp[i][j] != updated[i][j])
					{
						same = false;
						break;
					}
				}
			}
			updated = temp;
		}

		occupied = 0;
		for (char[] chars : updated)
		{
			for (char aChar : chars)
			{
				if (aChar == '#')
				{
					occupied++;
				}
			}
		}

		System.out.println(occupied);


		return occupied;
	}

	public char[][] updatePart2(char[][] seats)
	{
		char[][] updated = new char[seats.length][seats[0].length];

		for (int i = 0; i < updated.length; i++)
		{
			for (int j = 0; j < updated[i].length; j++)
			{
				char chatAt = seats[i][j];

				switch(chatAt)
				{
					case 'L':
						boolean occupied = true;

						for (int iOff = -1; iOff < 2; iOff++)
						{
							if (!occupied)
								break;
							for (int jOff = -1; jOff < 2; jOff++)
							{
								if (iOff == 0 && jOff == 0)
									continue;
								if (!occupied)
									break;
								for (int scale = 1; scale < 100; scale++)
								{
									int iOffScale = iOff * scale;
									int jOffScale = jOff * scale;
									if (i + iOffScale < 0 || j + jOffScale < 0 || i + iOffScale >= updated.length || j + jOffScale >= updated[i].length)
										continue;

									char chatAtOff = seats[i + iOffScale][j + jOffScale];
									if (chatAtOff == '#')
									{
										occupied = false;
										break;
									}
									else if (chatAtOff == 'L')
									{
										break;
									}
								}
							}
						}

						updated[i][j] = occupied ? '#' : 'L';
						break;
					case '#':
						int occupiedCount = 0;

						for (int iOff = -1; iOff < 2; iOff++)
						{
							for (int jOff = -1; jOff < 2; jOff++)
							{
								if (iOff == 0 && jOff == 0)
									continue;
								for (int scale = 1; scale < 100; scale++)
								{
									int iOffScale = iOff * scale;
									int jOffScale = jOff * scale;
									if (i + iOffScale < 0 || j + jOffScale < 0 || i + iOffScale >= updated.length || j + jOffScale >= updated[i].length)
										continue;

									char chatAtOff = seats[i + iOffScale][j + jOffScale];
									if (chatAtOff == '#')
									{
										occupiedCount++;
										break;
									}
									else if (chatAtOff == 'L')
									{
										break;
									}
								}
							}
						}

						updated[i][j] = occupiedCount >= 5 ? 'L' : '#';
						break;
					default:
						updated[i][j] = '.';
						break;
				}
			}
		}
		return updated;
	}

	public char[][] reformatPart(char[][] seats)
	{
		char[][] updated = new char[seats.length][seats[0].length];

		for (int i = 0; i < updated.length; i++)
		{
			for (int j = 0; j < updated[i].length; j++)
			{
				char chatAt = seats[i][j];
				switch(chatAt)
				{
					case 'L':
						boolean occupied = true;
						for (int iOff = -1; iOff < 2; iOff++)
						{
							if (!occupied)
								break;
							for (int jOff = -1; jOff < 2; jOff++)
							{
								if (iOff == 0 && jOff == 0 || i + iOff < 0 || j + jOff < 0 || i + iOff >= updated.length || j + jOff >= updated[i].length)
									continue;

								char chatAtOff = seats[i + iOff][j + jOff];
								if (chatAtOff == '#')
								{
									occupied = false;
									break;
								}
							}
						}

						updated[i][j] = occupied ? '#' : 'L';
						break;
					case '#':
						int occupiedCount = 0;
						for (int iOff = -1; iOff < 2; iOff++)
						{
							for (int jOff = -1; jOff < 2; jOff++)
							{
								if (iOff == 0 && jOff == 0 || i + iOff < 0 || j + jOff < 0 || i + iOff >= updated.length || j + jOff >= updated[i].length)
									continue;

								char chatAtOff = seats[i + iOff][j + jOff];
								if (chatAtOff == '#')
								{
									occupiedCount++;
								}
							}
						}

						updated[i][j] = occupiedCount >= 4 ? 'L' : '#';
						break;
					default:
						updated[i][j] = '.';
						break;
				}
			}
		}
		return updated;
	}
}
