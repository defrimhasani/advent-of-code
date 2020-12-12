package day12;

public enum Direction
{
	NORTH(0, 1),
	EAST(1, 0),
	SOUTH(0, -1),
	WEST(-1, 0);

	int xOff;
	int yOff;

	Direction(int xOff, int yOff)
	{
		this.xOff = xOff;
		this.yOff = yOff;
	}

	public static Direction rotate(Direction start, int amount, boolean clockwise)
	{
		Direction toReturn = start;

		for (int i = 0; i < amount; i++)
		{
			if (toReturn == Direction.NORTH)
			{
				toReturn = clockwise ? EAST : WEST;
			}
			else if (toReturn == Direction.EAST)
			{
				toReturn = clockwise ? SOUTH : NORTH;
			}
			else if (toReturn == Direction.SOUTH)
			{
				toReturn = clockwise ? WEST : EAST;
			}
			else if (toReturn == Direction.WEST)
			{
				toReturn = clockwise ? NORTH : SOUTH;
			}
		}
		return toReturn;
	}
}