import java.util.*;
public class Aux extends Tree{
	public static void importance(int a,int examples){
		return;
	}
	public static int lastPosition;
	public static HashMap<String,Integer> possibleEnds = new HashMap<String,Integer>();
	public static double valueImportance(String[][] database){
		double ent = entropy(database);
		System.out.println("Entropy: "+ent);
		double gain=ent;
		double total=0;

		for(int i=0;i<database[i].length;i++){
			for(int j=0;j<database[i][j].length();j++){
				float total2=0;
				int sum=0;
				for(int k=0;k<database[k].length;k++){
					if(database[k][j].equals(database[i][j]))sum++;
				}
				for (String name : possibleEnds.keySet()) {
					int temp=0;
					for(int k=0;k<database[k].length;k++){
						if(database[k][lastPosition].equals(name))
							temp++;
					}
					total2-=(temp/sum)*log2(temp/5);
				}
				total+=(((float)(sum)/((float)(database.length-1)))*(float)(total2));
				System.out.println(total+"+="+(float)(sum)/(float)(database.length-1)+"*"+total);
				
			}
			//System.out.println("Gain: "+(ent-total));
		}
		gain-=total;
		return gain;
	}
	/*public static int countIn(int pos,String first, String second){
		int total=0;
		for(int i=0;i<database.length;i++){
			if(first.equals(database[i][pos]))
				if(second.equals(database[i][lastPosition]))
					total+=1;
		}
		return total;
	}*/
	static double log2(double p){
		if(p!=0)return Math.log(p)/Math.log(2);
		return 0;
	}
	static double entropy(String[][] database){
		lastPosition=database[0].length-1;
		//System.out.println(lastPosition+" "+database.length);
		for(int i=1;i<database.length;i++){
			if(possibleEnds.get(database[i][lastPosition])!=null){
				int temp= possibleEnds.get(database[i][lastPosition]);
				possibleEnds.remove(database[i][lastPosition]);
				possibleEnds.put(database[i][lastPosition],++temp);
			}else possibleEnds.put(database[i][lastPosition],1);
		}
		float total=0;
		for (String name : possibleEnds.keySet()) {
		    String key = name;
            int value = possibleEnds.get(name);
		    //System.out.println ("Key: " + key + " Value: " + value);
		    total-=((float)(value)/(float)(database.length-1))*log2((float)(value)/(float)(database.length-1));
		  	//System.out.println ("Total "+total+"= value "+value+":"+database.length+" log2 "+log2((float)(value)/(float)(database.length-1)));
		}
	return total;
	}
}