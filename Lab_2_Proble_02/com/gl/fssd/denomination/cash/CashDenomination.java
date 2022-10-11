package com.gl.fssd.denomination.cash;

import java.util.Scanner;
import com.gl.fssd.denomination.util.SortingUtility;

public class CashDenomination {
	private int iNumberOfDenominations;
	private int[] iArrDenominations;
	
	public int getNumberOfDenominations() {
		return iNumberOfDenominations;
	}

	public void setNumberOfDenominations(int iNumberOfDenominations) {
		this.iNumberOfDenominations = iNumberOfDenominations;
	}

	public int[] getArrDenominations() {
		return iArrDenominations;
	}

	public void setArrDenominations(int[] iArrDenominations) {
		this.iArrDenominations = iArrDenominations;
	}

	public void doCashDenominationOps()
	{
		boolean bIsAchieved = false;
		Scanner sObj = new Scanner(System.in);
		
		System.out.println("\n........CashDenomination operation started.....\n");
		
		SortingUtility.mergeSort(iArrDenominations);
				
		int [] iArrCounter = new int[iNumberOfDenominations];

		System.out.println("Input the amount you want to pay: ");
		int iAmountToPay = sObj.nextInt();
				
		int iRemainingAmount = countNotes(iArrDenominations, iArrCounter, 0, iNumberOfDenominations - 1, iAmountToPay);
				
		if (iRemainingAmount > 0)
		{
			System.out.println("Amount cannot be paid in give denominations!");
		}
		else
		{
			for(int i = iNumberOfDenominations - 1; i>=0; i--)
			{
				if(iArrCounter[i] != 0)
				{
					System.out.println("Denomination of " + iArrDenominations[i] + ":" + iArrCounter[i]);
				}
			}
		}		
		System.out.println("\n........CashDenomination operation completed.....");
	}//End of doCashDenominationOps() 
	
	private int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay )
	{
		/*
		 */
		if (amountToPay == 0)
		{
			return 0;
		}
		if (amountToPay < arrDenominations[0])
		{
			return amountToPay;
		}
		
		
		if(amountToPay >= arrDenominations[high])
		{
			counter[high] = amountToPay / arrDenominations[high];
			amountToPay %= arrDenominations[high];
			return countNotes(arrDenominations, counter, 0, high, amountToPay);
		}
		int mid = (low+high)/2;
		if(amountToPay <= arrDenominations[mid])
		{
			return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
		}
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}
}