package javaandjava8;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {

		int rowCount = 1;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the Pyramid Size: ");
		
		int pyramidSize = in.nextInt();
		
		for(int i=pyramidSize; i>0; i--)
		{
			for(int j=0; j<i-1; j++)
			{
				System.out.print(" ");
			}
			for(int j=0; j<rowCount; j++)
			{
				System.out.print(rowCount + " ");
			}
			
			System.out.println();
			rowCount++;
		}
	}

}
