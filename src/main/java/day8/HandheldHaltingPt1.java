package day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import common.Puzzle;

public class HandheldHaltingPt1 extends Puzzle
{
	public static final String ACCUMULATOR_INST = "acc";
	public static final String NO_OPERATION_INSTR = "nop";
	public static final String JUMP_INS = "jmp";

	public HandheldHaltingPt1()
	{
		super("day8.txt");
	}

	public int getPartOneResult() throws IOException, URISyntaxException
	{
		int accumulatorValue = 0;
		int counter = 0;

		List<String> data = getInput();

		List<Integer> counterHistory = new ArrayList<>();

		boolean execute = true;

		while (execute)
		{
			counterHistory.add(counter);

			String operator = data.get(counter);

			String[] instruction = operator.split(" ");

			if (NO_OPERATION_INSTR.equals(instruction[0]))
			{
				counter++;
			}
			else if (ACCUMULATOR_INST.equals(instruction[0]))
			{
				accumulatorValue += Integer.parseInt(instruction[1]);
				counter++;
			}
			else if (JUMP_INS.equals(instruction[0]))
			{
				counter += Integer.parseInt(instruction[1]);
			}

			if (counterHistory.contains(counter))
			{
				execute = false;
			}
		}

		return accumulatorValue;
	}

}
