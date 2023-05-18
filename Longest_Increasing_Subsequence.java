package Practice_Project;



public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};	
        int[] lis = findLongestIncreasingSubsequence(nums);
        
        System.out.println("Longest Increasing Subsequence length: " + lis.length);
        System.out.println("Longest Increasing Subsequence: ");
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
    
    /*Find longest subsequence methods*/
    public static int[] findLongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] prevIndices = new int[n];
        int maxIndex = 0;
        
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            prevIndices[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    prevIndices[i] = j;
                }
            }
            
            if (lis[i] > lis[maxIndex]) {
                maxIndex = i;
            }
        }
        
        int[] subsequence = new int[lis[maxIndex]];
        int currentIndex = lis[maxIndex] - 1;
        int currentIndexValue = nums[maxIndex];
        
        while (maxIndex >= 0) {
            subsequence[currentIndex] = currentIndexValue;
            currentIndex--;
            
            maxIndex = prevIndices[maxIndex];
            if (maxIndex >= 0) {
                currentIndexValue = nums[maxIndex];
            }
        }
        return subsequence;
    }
}
