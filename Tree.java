import java.util.*;
public class Tree{
	HashMap<String,Integer> child = new HashMap<String,Integer>();
	String attributes[] = new String[255];
    int attributesSize=attributes.length;
	public static void addChild(String name){

	}
	public static void isEmpty(){

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