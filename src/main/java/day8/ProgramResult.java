package day8;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgramResult
{
	boolean isInfinite;
	int accumulatorValue;
}
