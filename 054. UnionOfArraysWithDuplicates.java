class Solution {
    
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
       
       HashSet<Integer> hs=new HashSet <>();
       
        for(int i=0; i<a.length; i++) {
            hs.add(a[i]);
        }
       
        for(int i=0; i<b.length; i++) {
            hs.add(b[i]);
        }
       
        ArrayList<Integer> list=new ArrayList <>(hs);
        return list;
    }
}
