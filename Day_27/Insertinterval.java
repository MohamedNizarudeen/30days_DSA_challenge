import java.util.ArrayList;
import java.util.List;

// A class to store an interval
class Interval {
	int begin, end;

	Interval(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public String toString() {
		return "{" + begin + ", " + end + "}";
	}
}

class Insertinterval
{
	public static List<Interval> mergeIntervals(List<Interval> intervals, Interval interval)
	{
		List<Interval> result = new ArrayList<>();

		// base case
		if (intervals.isEmpty())
		{
			result.add(interval);
			return result;
		}

		int i = 0;
		while (i < intervals.size())
		{
			// if the current interval doesn't overlap with the specified interval
			if (intervals.get(i).end < interval.begin || intervals.get(i).begin > interval.end)
			{
				// push current interval to the result
				result.add(intervals.get(i++));
			}
			else
			{
				// if the current interval overlaps with the specified interval,
				// merge all overlapping intervals into one
				int start = interval.begin, end = interval.end;
				while (i < intervals.size() && intervals.get(i).begin <= interval.end)
				{
					start = Math.min(start, intervals.get(i).begin);
					end = Math.max(end, intervals.get(i).end);
					i++;
				}

				// push the merged interval to the result
				result.add(new Interval(start, end));
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		List<Interval> intervals = List.of(new Interval(1, 5), new Interval(7, 8),
										new Interval(9, 10), new Interval(12, 15));

		Interval interval = new Interval(5, 9);

		List<Interval> result = mergeIntervals(intervals, interval);
		System.out.println(result);
	}
}