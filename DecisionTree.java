import java.util.*;
public class DecisionTree extends Aux {


    public static Tree gardener(String database[][], PriorityQueue<Node> parent) {
        if(parent.isEmpty())return null;
        Node root = parent.poll();
        HashMap<String, String> examples = new HashMap<String, String>();
        int ati, i;
        for(ati = 0; ati < database[0].length; ati++) {
            if(root.type.equals(database[0][ati]))
                break;
        }
        //true foward false inconclusive
        boolean checker = true;
        String idealSolution = database[1][lastPosition];
        /*for(i = 2; i < database.length; i++) {
            if(!(database[i][ati].equals(idealSolution))){
            	checker=false;
            	//break;
            }

        }*/
        /*if(checker==false){
        	return new Tree(root,examples,null);
        }*/

        for(i = 1; i < database.length; i++) {
            if(examples.get(database[i][ati]) == null)
                examples.put(database[i][ati], database[i][lastPosition]);
        }


        //System.out.println("pai " + root.type);
        return new Tree(root, examples, gardener(database, parent));
    }
    public static String pluratyValue(String database[][], String name, Tree localTree) {
        HashMap<String, Integer> localEnds = new HashMap<String, Integer>();
        int ati = 0;
        for(String temp : database[0]) {
            if(temp.equals(name))
                break;
            ati++;
        }

        for(String key : localTree.examples.keySet()) {
            for(int i = 1; i < database.length; i++) {
                if(database[i][ati].equals(key)) {
                    //Guarda/Altera a quantidade de finais possíveis (atributo play)
                    if(localEnds.get(database[i][lastPosition]) != null) {
                        int temp = localEnds.get(database[i][lastPosition]);
                        localEnds.remove(database[i][lastPosition]);
                        localEnds.put(database[i][lastPosition], ++temp);
                    } else localEnds.put(database[i][lastPosition], 1);
                }
            }
        }

        //formula da entropy (utilizando o for each)
        int max = -1;
        String maxer = "";
        for (String key : localEnds.keySet()) {
            int value = localEnds.get(key);
            //System.out.println(name + " - " + key + " " + value);
            if(max < value) {
                max = value;
                maxer = key;
            }
            //System.out.println ("Total "+total+"= value "+value+":"+database.length+" log2 "+log2((float)(value)/(float)(database.length-1)));
        }
        return maxer;
    }
    public static void tester(String database[][], String input[], Tree localTree) {
        //int i = 0;
        String localName = "";
        while(localTree != null) {

            localName = localTree.parent.type;
            if(localTree.next==null) {

                System.out.println(pluratyValue(database, localName, localTree));
                return;
            }
            //column
            int ati = 0;
            for(String temp : database[0]) {
                if(localName.equals(temp))
                    break;
                ati++;
            }
            //
            HashMap<String, Boolean> localEnds = new HashMap<String, Boolean>();

            for(String key : localTree.examples.keySet()) {
                if(!key.equals(input[ati]))continue;
                String idealSolution = "";
                for(int i = 1; i < database.length; i++) {
                    if(database[i][ati].equals(key)) {
                        idealSolution = database[i][lastPosition];
                        break;
                    }
                }
                //System.out.println("Ideal: " + idealSolution);
                for(int i = 1; i < database.length; i++) {
                    if(database[i][ati].equals(key)) {
                        if(localEnds.get(database[i][ati]) != null) {
                            //System.out.println(localName + " " + key + " " + idealSolution + " " + localEnds.get(database[i][ati]));
                            boolean temp = localEnds.get(database[i][ati]);
                            if(!idealSolution.equals(database[i][lastPosition])) {
                                localEnds.put(database[i][ati], false);
                            }
                        } else {
                            localEnds.put(database[i][ati], true);
                        }
                    }
                }
                if((localEnds.get(key) == true) && input[ati].equals(key)) {
                    //System.out.println(input[ati]);
                    System.out.println(idealSolution);
                    return;
                }
            }
            localTree = localTree.next;
        }


/*public static Tree pluratyValue(examples){
	//seleciona o valor mais comum entre as soluções.
	//Ex: se o 55% dos outputs forem "Yes", esta função vai devolver "Yes"
	public static HashMap<String, Integer> possibleEnds = new HashMap<String, Integer>();
	for(int i = 1; i < database.length; i++) {
        //Guarda/Altera a quantidade de finais possíveis (atributo play)
        if(possibleEnds.get(database[i][lastPosition]) != null) {
            int temp = possibleEnds.get(database[i][lastPosition]);
            possibleEnds.remove(database[i][lastPosition]);
            possibleEnds.put(database[i][lastPosition], ++temp);
        } else possibleEnds.put(database[i][lastPosition], 1);
    }
    int max=-1;
    String best;
    for (String key : possibleEnds.keySet()) {
        int value = possibleEnds.get(key);
        if(max<value){
        	max=value;
        	best=key;
        }
        //System.out.println ("Total "+total+"= value "+value+":"+database.length+" log2 "+log2((float)(value)/(float)(database.length-1)));
    }
    return new Tree()

}*/
/*public static boolean allTheSame(HashSet<Node> examples){
	//se todos os exemplos tiverem a mesma classificação final
	/*
	 for(String name : types.keySet()) {
	 	*/
/*Node temp=new Node();
for(Node key : examples ){
	System.out.println(key.type+" - "+temp.type);
	//if((temp!=null)&&(temp!=key))return false;
	temp=key;
}
return true

}*/
/*public static tree DecisionTreeLearning(Tree[] examples,String[] attributes,Tree[] parenExamples){
	if(isEmpty(examples))
		return pluratyValue(parenExamples);
	else if (allTheSame(examples))
		return classification;
	else if (isEmpty(attributes))
		return pluratyValue(examples);
	else{
		A = argmax(a ∈ attributes) importance(a, examples);
		Tree tree = a new decision tree with root test A;
		for each value v k of A do
			exs = {e : e ∈ examples and e.A = v(k) }
			subtree = DecisionTreeLearning(exs, A.attributes, examples)
			add a branch to tree with label (A = v(k) ) and subtree (subtree)
		return tree
	}
	return tree;
}*/