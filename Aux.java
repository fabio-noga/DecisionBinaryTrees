import java.util.*;
public class Aux extends Tree {
    public static void importance(int a, int examples) {
        return;
    }
    public static int lastPosition;
    public static HashMap<String, Integer> possibleEnds = new HashMap<String, Integer>();
    //Devolve o melhor atributo a utilizar na matriz recebida
    public static double valueImportance(String[][] database) {
        double ent = entropy(database);
        System.out.println("Entropy: " + ent);
        double gain = ent;
        double max = -1;
        System.out.println(database.length + " " + database[0].length);
        for(int i = 0; i < database[0].length - 1; i++) {
        	//guarda todas as possibilidades do atributo numa hashmap
            HashMap<String, Integer> types = new HashMap<String, Integer>();
            System.out.println (database[0][i]);
            for(int j = 1; j < database.length; j++) {
                if(types.get(database[j][i]) != null) {
                    int temp = types.get(database[j][i]);
                    types.remove(database[j][i]);
                    types.put(database[j][i], ++temp);
                } else types.put(database[j][i], 1);
            }
            float total=0,sumTotal=0;
            //a cada possibilidade encontrada vai comparar com os finais possiveis e 
            //consequentemente vai color a quantidade de finais para cada possibilidade
            //de caminho numa terceira hashmap
            for (String key : types.keySet()) {
            	float localTotal=0;
            	HashMap<String, Integer> solutions = new HashMap<String, Integer>();
                int totalOcur = types.get(key);
                for(int j = 1; j < database.length; j++) {
                    if(!(database[j][i].equals(key)))continue;
                    for (String name : possibleEnds.keySet()) {
                        if(name.equals(database[j][lastPosition])) {
                            if(solutions.get(database[j][lastPosition]) != null) {
                                int temp = solutions.get(database[j][lastPosition]);
                                solutions.remove(database[j][lastPosition]);
                                solutions.put(database[j][lastPosition], ++temp);
                            } else solutions.put(database[j][lastPosition], 1);
                        }
                    }
                }
                for (String name : solutions.keySet()) {
                    int wvalue = solutions.get(name);
                    //System.out.print("-"+wvalue+"/"+(totalOcur)+"log2("+wvalue+"/"+(totalOcur)+")");
                    localTotal -= ((float)(wvalue) / (float)(totalOcur)) * log2((float)(wvalue) / (float)(totalOcur));

                }
                //System.out.print(")+");
                sumTotal+=((float)(totalOcur)/(float)(database.length-1))*localTotal;
            }
            //System.out.println(")");
            gain = ent - sumTotal;
            //o melhor atributo é o que tiver o info gain maior
            if(max < gain)max = gain;
            System.out.println(database[0][i] + " - Gain: " + (ent - sumTotal));
        }
        return max;
    }
    //log2(x)
    static double log2(double p) {
        if(p != 0)return Math.log(p) / Math.log(2);
        return 0;
    }
    static double entropy(String[][] database) {
        lastPosition = database[0].length - 1;
        //System.out.println(lastPosition+" "+database.length);
        for(int i = 1; i < database.length; i++) {
        	//Guarda/Altera a quantidade de finais possíveis (atributo play)
            if(possibleEnds.get(database[i][lastPosition]) != null) {
                int temp = possibleEnds.get(database[i][lastPosition]);
                possibleEnds.remove(database[i][lastPosition]);
                possibleEnds.put(database[i][lastPosition], ++temp);
            } else possibleEnds.put(database[i][lastPosition], 1);
        }
        float total = 0;
        //formula da entropy (utilizando o for each)
        for (String key : possibleEnds.keySet()) {
            int value = possibleEnds.get(key);
            total -= ((float)(value) / (float)(database.length - 1)) * log2((float)(value) / (float)(database.length - 1));
            //System.out.println ("Total "+total+"= value "+value+":"+database.length+" log2 "+log2((float)(value)/(float)(database.length-1)));
        }
        return total;
    }
}