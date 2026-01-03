

// User function Template for Java

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;
        while(root.next!=null){
            Node t = root.next;
            if(root.data>t.data){
                root.next=null;
                Node prev=root;
                root=t;
                t=t.bottom;
                root.bottom=prev;
            }
            else{
                root.next=t.next;
                t.next=null;
            }
            while(t!=null){
                Node nextbottom = t.bottom;
                Node x = root;
                while(x.bottom!=null && x.bottom.data<t.data){
                    x=x.bottom;
                }
                t.bottom=x.bottom;
                x.bottom=t;
                t=nextbottom;
            }
        }
        return root;
        
    }
}

