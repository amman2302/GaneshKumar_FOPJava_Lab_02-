package com.gl.fssd.denomination.main;

import java.util.Scanner;
import com.gl.fssd.denomination.cash.CashDenomination;

public class DriverClass {
	public static void main(String[] args) {
		Scanner sObj = new Scanner(System.in);
		System.out.println("Input number of denominations:");
		int numberOfDenominations = sObj.nextInt();
		
		int [] arrDenominations = new int[numberOfDenominations];
		System.out.println("Input the values of denominations");
		for(int i = 0; i< numberOfDenominations; i++)
		{
			arrDenominations[i] = sObj.nextInt();
		}  
		CashDenomination cashDenominationObj = new CashDenomination();
		cashDenominationObj.setNumberOfDenominations(numberOfDenominations);
		cashDenominationObj.setArrDenominations(arrDenominations);
		cashDenominationObj.doCashDenominationOps();
	}//End of main method

}//End of DriverClass