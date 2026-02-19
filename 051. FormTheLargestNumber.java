class Solution {
    public String findLargest(int[] arr) {
       
        String[] strArr = new String[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = Integer.toString(arr[i]);
        }
        
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        if (strArr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String num : strArr) {
            result.append(num);
        }

        return result.toString();

    }
}
