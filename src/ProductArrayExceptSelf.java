import static java.lang.System.out;

import java.util.Arrays;

public class ProductArrayExceptSelf
{

	public static int[] productExceptSelf(int[] nums)
	{
		int n = nums.length;
		int[] ans = new int[nums.length];
		ans[0] = 1;
		for(int i = 1; i < n; i++)
		{
			ans[i] = ans[i - 1] * nums[i - 1];
		}
		for(int i = n - 2; i >= 0; i--)
		{
			ans[i] = ans[i] * nums[i + 1];
			nums[i] = nums[i] * nums[i + 1];
		}

		return ans;
	}
}
