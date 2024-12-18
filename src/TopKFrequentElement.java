import java.util.*;

public class TopKFrequentElement
{
	public static int[] topKFrequent(int[] nums, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		ArrayList<Integer>[] bucketList = new ArrayList[nums.length + 1];

		for(int num : map.keySet())
		{
			if(bucketList[map.get(num)] == null)
			{
				bucketList[map.get(num)] = new ArrayList<>();
			}
			bucketList[map.get(num)].add(num);
		}
		int index = 0;
		int[] result = new int[k];
		for(int i = bucketList.length - 1; i >= 0; i--)
		{
			if(bucketList[i] != null)
			{
				for(int j = 0; j < bucketList[i].size(); j++)
				{
					result[index] = bucketList[i].get(j);
					index++;
					if(index == k)
					{
						return result;
					}
				}
			}
		}
		return result;

	}
}
