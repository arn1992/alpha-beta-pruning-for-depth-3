/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.beta_pruning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author arn
 */
public class alphabeta {
    
  
 static int turns;
 static int notes;
 static int min;
 static int max;
 static int terminalstates;
  static double leaf[];
 
        public static void main(String[] args)throws FileNotFoundException{
           Scanner k=new Scanner(new File("i.txt"));
           turns=k.nextInt();
           
           int depth=0;
           depth=turns*2;
           System.out.println("Depth is: "+depth);
           
 notes=k.nextInt();
 System.out.println("Branch is: "+ notes);
 
 min=k.nextInt();
 max=k.nextInt();
 System.out.println("min value is: "+min);
 System.out.println("max value is: "+max);
 terminalstates=notes*notes;
 System.out.println("terminal States is: "+terminalstates);
 
 System.out.println("--------------------------------------");
 System.out.println("--------------------------------------");
 System.out.println("         Comparison                   ");
 System.out.println("before alpha-beta pruning comaprisons is: "+terminalstates);
 
  leaf=new double[terminalstates];
 for(int i=0;i<terminalstates;i++){
 
 leaf[i]=k.nextDouble();
 System.out.println(leaf[i]);

 }
  Node n1=new Node(leaf[0]);
               
               Node n2=new Node(leaf[1]);
               Node n3=new Node(leaf[2]);
  Node n4=new Node(leaf[3]);
   Node n5=new Node(leaf[4]);
    Node n6=new Node(leaf[5]);
     Node n7=new Node(leaf[6]);
     Node n8=new Node(leaf[7]);
     Node n9=new Node(leaf[8]);
      
    root grandpa=new root(-20,-20,20);
    root father1=new root(20,-20,20);
    root father2=new root(20,-20,20);
    root father3=new root(20,-20,20);
     double v = 0;
double alpha=0;double beta = 0;
    int pruning=0;
    /*done for min node value update because child are max*/
    for(int i=0;i<notes;i++){
            
        if(i==0){
            pruning++;
     v=n1.value;
     alpha=n1.value;
    beta=20;
    father1.value=v;
    father1.alpha=-20;
    father1.beta=v;
        }
        else if(i==1 && father1.value>father1.alpha ){
        pruning++;
         v=n2.value;
     alpha=n2.value;
    beta=20;
    //System.out.println("i=1.0");
    
    if(v<father1.value)
    {
        //System.out.println("i=1.1");
    father1.value=v;
    father1.alpha=-20;
    father1.beta=v;
    }    
        
        }
        else if(i==2 && father1.value>father1.alpha){
        pruning++;
         v=n3.value;
     alpha=n3.value;
    beta=20;
    //System.out.println("i=2.0");
         
    if(v<father1.value)
    {
        //System.out.println("i=2.1");
    father1.value=v;
    father1.alpha=-20;
    father1.beta=v;
    }    
        }
    }
    grandpa.value=father1.value;
    grandpa.alpha=father1.value;
    grandpa.beta=20;
    
    System.out.println("--------------------------------------");
 System.out.println("--------------------------------------");
 
    System.out.println("after father 1 evaluated: ");
    System.out.println("root node value: "+grandpa.value);
    
    System.out.println("purn value: "+pruning);
    
    
    //father2
    
    if(grandpa.value< grandpa.beta){
        alpha=grandpa.alpha;
        father2.value=20;
        father2.alpha=alpha;
        father2.beta=20;
    for(int i=0;i<notes;i++){
    if(i==0){
         pruning++;
     v=n4.value;
     beta=20;
     if(alpha<n4.value){
      alpha=n4.value;
     }
   father2.value=v;
   father2.beta=v;
        
    
    }
    else if(i==1 && father2.value>father2.alpha ){
        pruning++;
         v=n5.value;
     alpha=n5.value;
    beta=20;
   // System.out.println("i2=1.0");
    
    if(v<father2.value)
    {
        //System.out.println("i=1.1");
    father2.value=v;
   
    father2.beta=v;
    }    
        
        }
        else if(i==2 && father2.value>father2.alpha){
        pruning++;
         v=n5.value;
     alpha=n5.value;
    beta=20;
   // System.out.println("i2=2.0");
    
    if(v<father2.value)
    {
        //System.out.println("i=1.1");
    father2.value=v;
   
    father2.beta=v;
    }     
        }
    }
    
    }
    
    if(father2.value>grandpa.value){
    grandpa.value=father2.value;
    grandpa.alpha=father2.value;
    grandpa.beta=20;
    
    }
    
    System.out.println("--------------------------------------");
 System.out.println("--------------------------------------");
 
   System.out.println("after father 2 evaluated: ");
    System.out.println("root node value: "+grandpa.value);
    
    System.out.println("purn value: "+pruning);
    
    //father3
    
    if(grandpa.value< grandpa.beta){
        alpha=grandpa.alpha;
        father3.value=20;
        father3.alpha=alpha;
        father3.beta=20;
    for(int i=0;i<notes;i++){
    if(i==0){
         pruning++;
     v=n7.value;
     beta=20;
     if(alpha<n7.value){
      alpha=n7.value;
     }
   father3.value=v;
   father3.beta=v;
        
    
    }
    else if(i==1 && father3.value>father3.alpha ){
        pruning++;
         v=n8.value;
     alpha=n8.value;
    beta=20;
   // System.out.println("i2=1.0");
    
    if(v<father3.value)
    {
        //System.out.println("i=1.1");
    father3.value=v;
   
    father3.beta=v;
    }    
        
        }
        else if(i==2 && father3.value>father3.alpha){
        pruning++;
         v=n9.value;
     alpha=n9.value;
    beta=20;
   // System.out.println("i2=2.0");
    
    if(v<father3.value)
    {
        //System.out.println("i=1.1");
    father3.value=v;
   
    father3.beta=v;
    }     
        }
    }
    
    }
    
    if(father3.value>grandpa.value){
    grandpa.value=father3.value;
    grandpa.alpha=father3.value;
    grandpa.beta=20;
    
    }
    
    
    System.out.println("--------------------------------------");
 System.out.println("--------------------------------------");
 
   System.out.println("after father 3 or, final father evaluated: ");
    System.out.println("root node final value: "+grandpa.value);
    
    System.out.println("final purn value or, comparison value after pruning: "+pruning);
    
    }
    
}

class Node{
 
        public  double value;
       
 
        public Node( double val){
                value = val;
               
        }
 
       
 
}
class root{
 
        public  double value;
       public double alpha;
       public double beta;
 
        public root( double val,double alpha1,double beta1){
                value = val;
                alpha=alpha1;
                beta=beta1;
               
        }
 
       
 
}

