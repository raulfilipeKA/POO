package semana03.pratica;

import java.util.ArrayList;

public class SortedIntArray implements semana03.pratica.SortingPolicy {
    private ArrayList<Integer> arr;
    private semana03.pratica.SortingPolicy policy;

    public SortedIntArray(SortingPolicy policy){
        this.arr = new ArrayList<>();
        this.policy = policy;

    }

    public int size(){
        return arr.size();
    }

    public void add(int value) {
        int i = 0;
        while (i < arr.size() && policy.isBefore(arr.get(i), value)) {
            i++;
        }
        arr.add(i, value);
    }

    public int get(int index){
        return arr.get(index);
    }


    @Override
    public boolean isBefore(int a, int b) {
        //return !(a<b);
        return a > b;
    }
}
