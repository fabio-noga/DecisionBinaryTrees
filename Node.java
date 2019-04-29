public class Node {
        
         double val;
         String type;

         double getVal(){
         	return this.val;
        }

         String getType(){
         	return this.type;
        }

         void setType(String s){
         	this.type = s ; 
        }
        
         void setVal(double v){
         	this.val = v ;
        }
        
        public Node(){
        	this.val = 0 ; 
        	this.type = ""; 
        }

        public Node(double d, String s) {
            this.type = s;
            this.val = d;
        }
    }