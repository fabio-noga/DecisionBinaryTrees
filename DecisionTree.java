import java.util.*;
public class DecisionTree extends Aux{


	// PSEUDO CODIGO



	public static Tree pluratyValue(examples){
		//selects the most common output value among a set of examples, breaking ties randomly.
	
	}
	public static tree DecisionTreeLearning(Tree[] examples,String[] attributes,Tree[] parenExamples){
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
	}
}