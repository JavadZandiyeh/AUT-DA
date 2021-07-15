import java.util.*;

public class Puny{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int[] l = new int[n];
		for(int i = 0; i < n; i++)
		    l[i] = scanner.nextInt();
		
		List<tuple> my_list = new ArrayList<tuple>();
		
		// type 1
		int pos = 0;
		for(int i = 0; i < n; i++){
		    if(i == (n - 1))
		        my_list.add(new tuple(pos, i));
		    else if(l[i] > l[i + 1]){
		        my_list.add(new tuple(pos, i));
		        pos = i + 1;
		    }
		}
		
		int i1 = -1;
		int i2 = -1;
		outerloop:
		for(tuple i: my_list){
		    int[] slice = Arrays.copyOfRange(l, i.x, (i.y + 1));
		    for(int j = 0; j < (i.y-i.x+1); j++){
		        for(int t = 0; t < (i.y-i.x+1); t++){
		            if(slice[t] == (slice[j] + c)){
		                i1 = j + i.x + 1;
		                i2 = t + i.x + 1;
		                break outerloop;
		            }
		        }
		    }
		}
		
		if(i1 != -1 && i2 != -1){
		    System.out.println(i1 + " " + i2);
		    return;
		}
		
        
        // type2
        my_list.clear();
        pos = 0;
		for(int i = 0; i < n; i++){
		    if(i == (n - 1))
		        my_list.add(new tuple(pos, i));
		    else if(l[i] < l[i + 1]){
		        my_list.add(new tuple(pos, i));
		        pos = i + 1;
		    }
		}
		
		
		i1 = -1;
		i2 = -1;
		outerloop1:
		for(tuple i: my_list){
		    int[] slice = Arrays.copyOfRange(l, i.x, (i.y + 1));
		    for(int j = 0; j < (i.y-i.x+1); j++){
		        for(int t = 0; t < (i.y-i.x+1); t++){
		            if(slice[t] == (slice[j] - c)){
		                i1 = j + i.x + 1;
		                i2 = t + i.x + 1;
		                break outerloop1;
		            }
		        }
		    }
		}
		
		if(i1 != -1 && i2 != -1){
		    System.out.println(i1 + " " + i2);
		    return;
		}
		
		
		HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++)
            hm.put(l[i], i);
        for (int i = 0; i < n; i++){
            if (hm.get(l[i]+c) != null) {
                System.out.print((i+1) + " " + (hm.get(l[i]+c)+1));
                return;
            }
            else if(hm.get(l[i]-c) != null) {
                System.out.print((i+1) + " " + (hm.get(l[i]-c)+1));
                return;
            }
        }
	
		System.out.println(-1);
	}
	
	public static class tuple{
	    int x, y;
	    public tuple(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
}
