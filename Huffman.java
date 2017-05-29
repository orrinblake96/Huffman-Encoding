package ut1;
import java.util.*;
import java.util.PriorityQueue;

import java.util.Scanner;
import java.util.PriorityQueue;;

public class Huffman{

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       
       while(true){ //keeps the whole thing looping forever
       System.out.print("Enter your sentence: ");
       String sentence = in.nextLine();
       String binaryString="";      //this stores the string of binary code
       
       
       for(int i=0; i < sentence.length(); i++){        //go through the sentence
           int decimalValue = (int)sentence.charAt(i);      //convert to decimal
           String binaryValue = Integer.toBinaryString(decimalValue);      //convert to binary
           for(int j=7;j>binaryValue.length();j--){
               binaryString+="0";           //this loop adds in those pesky leading zeroes
            }
           binaryString += binaryValue+" "; //add to the string of binary
       }
       System.out.println(binaryString);    //print out the binary
       
       int[] array = new int[256];      //an array to store all the frequencies
       
       for(int i=0; i < sentence.length(); i++){    //go through the sentence
           array[(int)sentence.charAt(i)]++;    //increment the appropriate frequencies
           
       }
       
       
       PriorityQueue<Tree>  priorityQueue = new PriorityQueue<Tree>() ;  
        
       
       for(int i = 0; i < array.length; i++)
       { 
           if(array[i] > 0)
           { 
               System.out.println("'"+(char)i + "' appeared "+array[i]+((array[i] == 1) ? " time" : " times"));            
               Tree myTree = new Tree();    
               myTree.setFrequency(array[i]); 
               myTree.setRoot(new Node());      
               myTree.getRoot().setData((char)i);
               priorityQueue.add(myTree);              
            }
        }
        
        
        while(priorityQueue.size()>1)
        {             
            Tree firstTree = priorityQueue.poll(); 
            Tree secondTree = priorityQueue.poll();
            Tree comboTree = new Tree();    
            comboTree.setFrequency(firstTree.getFrequency() + secondTree.getFrequency());   
            comboTree.setRoot(new Node());        
            comboTree.getRoot().setLeftChild(firstTree.getRoot());    
            comboTree.getRoot().setRightChild(secondTree.getRoot());
            priorityQueue.add(comboTree);                  
        }
        
        Tree HuffmanTree = priorityQueue.poll();   
        int totalLength=0;              
        String theCode;
        for(int i=0; i<sentence.length(); i++){
            theCode=HuffmanTree.getCode(sentence.charAt(i));
            System.out.print(theCode+" ");  
            totalLength+=theCode.length();  
        }
        
        System.out.println("\nCompressed size is "+totalLength+" bits / "+sentence.length()*7+" bits = "+(int)((totalLength*100)/(sentence.length()*7))+" %\n");
        }  
    }  
    
}