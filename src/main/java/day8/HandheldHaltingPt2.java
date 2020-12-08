package day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HandheldHaltingPt2 extends HandheldHaltingPt1
{
	public int getPartTwoResult() throws IOException, URISyntaxException
	{
		return getPartTwoResult(getInput());
	}

	public int getPartTwoResult(final List<String> data)
	{
		int index = 0;

		boolean run = true;

		String old = "";

		ProgramResult secondResult;

		do
		{
			boolean found = false;
			while (!found && index < data.size())
			{
				String op = data.get(index);
				String[] opAndArgs = op.split(" ");
				if (opAndArgs[0].equals(NO_OPERATION_INSTR))
				{
					found = true;
					old = data.get(index);
					data.set(index, old.replace(NO_OPERATION_INSTR, JUMP_INS));
				}
				else if (opAndArgs[0].equals(JUMP_INS))
				{
					found = true;
					old = data.get(index);
					data.set(index, old.replace(JUMP_INS, NO_OPERATION_INSTR));
				}
				else
				{
					index++;
				}
			}
			secondResult = executeProgram(data);

			if (!secondResult.isInfinite())
			{
				run = false;
			}
			else
			{
				data.set(index, old);
			}
			index++;
		} while (run && index < data.size());

		return secondResult.getAccumulatorValue();
	}

	public ProgramResult executeProgram(final List<String> input)
	{
		ProgramResult toReturn = new ProgramResult();

		int accumulatorValue = 0;
		int counter = 0;

		List<Integer> counterHistory = new ArrayList<>();

		boolean execute = true;

		while (execute)
		{
			counterHistory.add(counter);
			String op = input.get(counter);
			String[] opAndArgs = op.split(" ");
			if (NO_OPERATION_INSTR.equals(opAndArgs[0]))
			{
				counter++;
			}
			else if (ACCUMULATOR_INST.equals(opAndArgs[0]))
			{
				accumulatorValue += Integer.parseInt(opAndArgs[1]);
				counter++;
			}
			else if (JUMP_INS.equals(opAndArgs[0]))
			{
				counter += Integer.parseInt(opAndArgs[1]);
			}

			if (counterHistory.contains(counter))
			{
				execute = false;
				toReturn.setInfinite(true);
				toReturn.setAccumulatorValue(accumulatorValue);
			}
			else if (counter >= input.size())
			{
				execute = false;
				toReturn.setInfinite(false);
				toReturn.setAccumulatorValue(accumulatorValue);
			}
		}

		return toReturn;
	}
}
