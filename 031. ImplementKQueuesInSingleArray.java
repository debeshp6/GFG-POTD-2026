class kQueues {
    
    List<Queue<Integer>> ls;
    int capacity, currCap;

    kQueues(int n, int k) {
        capacity = n;
        currCap = 0;
        ls = new ArrayList<>();
        for(int i = 0; i < k; i++)
            ls.add(new LinkedList<>());
    }

    void enqueue(int x, int i) {
        ls.get(i).offer(x);
        currCap++;
    }

    int dequeue(int i) {
        if(ls.get(i).isEmpty()) return -1;
        currCap--;
        return ls.get(i).poll();
    }

    boolean isEmpty(int i) {
        return ls.get(i).isEmpty();
    }

    boolean isFull() {
        return currCap == capacity;
    }
}
