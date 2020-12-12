package day12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import common.Puzzle;

public class RainRisk extends Puzzle
{
	private static final Character NORTH_VALUE = 'N';
	private static final Character SOUTH_VALUE = 'S';
	private static final Character EAST_VALUE = 'E';
	private static final Character WEST_VALUE = 'W';
	private static final Character LEFT_VALUE = 'L';
	private static final Character RIGHT_VALUE = 'R';
	private static final Character FORWARD_VALUE = 'F';

	private final List<String> data;

	public RainRisk() throws IOException, URISyntaxException
	{
		super("day12.txt");
		data = getInput();

	}

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		RainRisk rainRisk = new RainRisk();
		rainRisk.partTwo();
	}

	public int partOne()
	{

		int x = 0;
		int y = 0;

		Direction facing = Direction.EAST;

		for (String s : data)
		{
			int amount = Integer.parseInt(s.substring(1));

			if (s.charAt(0) == NORTH_VALUE)
				y += amount;
			else if (s.charAt(0) == EAST_VALUE)
				x += amount;
			else if (s.charAt(0) == SOUTH_VALUE)
				y -= amount;
			else if (s.charAt(0) == WEST_VALUE)
				x -= amount;
			else if (s.charAt(0) == FORWARD_VALUE)
			{
				x += facing.xOff * amount;
				y += facing.yOff * amount;
			}
			else if (s.charAt(0) == LEFT_VALUE)
				facing = Direction.rotate(facing, amount / 90, false);
			else if (s.charAt(0) == RIGHT_VALUE)
				facing = Direction.rotate(facing, amount / 90, true);
		}

		return Math.abs(x) + Math.abs(y);
	}

	public int partTwo()
	{
		int sx = 0;
		int sy = 0;
		int wx = 10;
		int wy = 1;

		for (String s : data)
		{
			int amount = Integer.parseInt(s.substring(1));

			if (s.charAt(0) == NORTH_VALUE)
				wy += amount;
			else if (s.charAt(0) == EAST_VALUE)
				wx += amount;
			else if (s.charAt(0) == SOUTH_VALUE)
				wy -= amount;
			else if (s.charAt(0) == WEST_VALUE)
				wx -= amount;
			else if (s.charAt(0) == FORWARD_VALUE)
			{
				sx = sx + wx * amount;
				sy = sy + wy * amount;
			}
			else if (s.charAt(0) == LEFT_VALUE)
			{
				for (int i = 0; i < amount / 90; i++)
				{
					int temp = wy;
					wy = wx;
					wx = temp * -1;
				}
			}
			else if (s.charAt(0) == RIGHT_VALUE)
			{
				for (int i = 0; i < amount / 90; i++)
				{
					int temp = wy;
					wy = wx * -1;
					wx = temp;
				}
			}
		}

		return Math.abs(sx) + Math.abs(sy);

	}
}
