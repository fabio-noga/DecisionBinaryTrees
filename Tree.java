import java.util.*;
public class Tree extends Node{
	Node parent;
		HashMap<String,String> examples = new HashMap<String,String>();
	Tree next;
	/*String attributes[] = new String[255];
    int attributesSize=attributes.length;*/
    public Tree(){
    	parent=null;
    	next=null;
    }
	public Tree(Node a,HashMap<String,String> b,Tree c){
		this.parent=a;
		this.examples=b;
		this.next=c;
	}
	boolean isEmpty(){
		return examples.isEmpty();
	}
	void printTree(){
		System.out.printf("%s\n",this.parent.type);
        for (String key : examples.keySet()) {
			System.out.printf("   -> %s\n",key);
		}
		if(this.next!=null)this.next.printTree();
		return;
	}
	int Size(){
		Tree temp=this;
		int i=0;
		while(temp!=null){
			i++;
			temp=temp.next;
		}
		return i;
	}
	/*
	Exemplo de Árvore - O melhor atributo é escolhido através do importance(maior gain entre atributos).
						Uma vez escolhido é criado uma subtree com o importance dos atributos restantes.
	Restaurant:

	Patrons:None->Play.No
			Some->Play.Yes
			Full->Hungry:No->Play.No
						 Yes->Type:French->Play.Yes
						 		   Italian->Play.No
						 		   Burguer->Play.Yes
						 		   Fri/Sat:No->Play.No
						 		   		   Yes->Play.Yes
*/}