package com.codsoft.Word_Counter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

	static int countWord(String text) {
		String arr[]=text.split(" ");
		return arr.length;
	}
	static int wordFrequency(String text,String word) {
		String [] arr=text.split("\\b");
		int cnt=0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i].equalsIgnoreCase(word)) {
				cnt++;
			}
		}
		return cnt;
	}
   public static void main(String[] args) {
	   System.out.println("word and frquency count program");
	   System.out.println("-----------------------------------");
	   
	   System.out.println("Enter 'T' to input text or 'F' to input a file :");
	   Scanner scanner =new Scanner(System.in);
	   String choice =scanner.nextLine();
	   
	   if(choice.equalsIgnoreCase("t")) {
		   System.out.println("Enter the text :");
		   String text=scanner.nextLine();
		   int wordCount=countWord(text);
		   System.out.println("Total word count :" +wordCount);
		   
		   System.out.println("Do you want to check the frquency of a word in you text? Y/N");
		   String freqChoice=scanner.nextLine();
		   
		   if(freqChoice.equalsIgnoreCase("Y")) {
			   System.out.println("Enter the word whose frequency you want to check");
			   String word=scanner.nextLine();
			   int frequency=wordFrequency(text, word);
			   System.out.println("the frquecy of "+ word +"is "+ frequency);
		   }
		   else if(freqChoice.equalsIgnoreCase("N")) {
			   System.out.println("sure ,ThankYou");
		   }else {
			   System.out.println("Enter the valid input");
		   }
	   }else if(choice.equalsIgnoreCase("F")) {
		   System.out.println("Enter the file name");
		   String filename=scanner.nextLine();
		   try {
			   File file=new File("E:\\codSoft " + filename);
			   Scanner fileScanner=new Scanner(file);
			   StringBuilder sb=new StringBuilder();
			   while(fileScanner.hasNextLine()) {
				   sb.append(fileScanner.hasNextLine());
				   sb.append(" ");
			   }
			   fileScanner.close();
			   
			   String fileContent=sb.toString();
			   int wordCount=countWord(fileContent);
			   System.out.println("total word count" +wordCount);
			   
			   System.out.println("Do you want to check the frequency of the word in your file? YES/NO");
			    String freqchoice=scanner.nextLine();
			    
			    if(freqchoice.equalsIgnoreCase("YES")) {
			    	System.out.println("Enter the word whose frequency you want to check");
			    	String word=scanner.nextLine();
			    	int frequency=wordFrequency(fileContent, word);
			    	System.out.println("The frequency of "+word +"is "+frequency);
			    }
			    else if(freqchoice.equalsIgnoreCase("NO")) {
			    	System.out.println("Sure Thank you !!");
			    }
			    else {
			    	System.out.println("Enter the valid input");
			    }
		   }
			    catch(FileNotFoundException e) {
			    	System.out.println("file not found");
			    }
		   }
		   else {
			   System.out.println("Invalid choice");
		   }
		   scanner.close();
	   }
	   
	   }
