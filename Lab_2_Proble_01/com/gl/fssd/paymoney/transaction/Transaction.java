/**
 * 
 */
package com.gl.fssd.paymoney.transaction;

import java.util.Scanner;

/**
 * 
 * @author Ganesh Kumar B ( ganesh.vinu@gmail.comm)
 *
 */

public class Transaction {
	private int iTotal_no_transacction = 0;
	private int[] iArrTransacctionValues;
	private int iTotal_no_target = 0;
	private boolean bIsTargetAchieved = false;
	private int iTransCnt = -1;
	

	public Transaction()
	{
		
	}//End of Constructor
	
	public int getiTotal_no_transacction() {
		return iTotal_no_transacction;
	}

	public void setiTotal_no_transacction(int iTotal_no_transacction) {
		this.iTotal_no_transacction = iTotal_no_transacction;
	}

	public int[] getiArrTransacctionValues() {
		return iArrTransacctionValues;
	}

	public void setiArrTransacctionValues(int[] iArrTransacctionValues) {
		this.iArrTransacctionValues = iArrTransacctionValues;
	}

	public int getiTotal_no_target() {
		return iTotal_no_target;
	}

	public void setiTotal_no_target(int iTotal_no_target) {
		this.iTotal_no_target = iTotal_no_target;
	}


	public int getiTransCnt() {
		return iTransCnt;
	}

	public void setiTransCnt(int iTransCnt) {
		this.iTransCnt = iTransCnt;
	}

	
	private boolean checkTargets(int iTargetvalue) {
		int sum = 0;
		bIsTargetAchieved = false;
		for(int i = 0; i < iArrTransacctionValues.length; i++)
		{
			sum += iArrTransacctionValues[i];
			if (sum >= iTargetvalue)
			{
				iTransCnt = i+1;
				bIsTargetAchieved = true;
				break;
			}	
		}		
		return bIsTargetAchieved;
	}
	
	public void doTransactionOperations() {
		boolean bIsAchieved = false;
		System.out.println("\n........Transaction operation started.....\n");
		Scanner scObj = new Scanner(System.in);
		for (int i = 0; i<iTotal_no_target; i++) // input targets
		{
			System.out.println("Input the target value # " + (i+1) );
			int iTargetvalue = scObj.nextInt();
			bIsAchieved  = checkTargets( iTargetvalue);
			if (bIsAchieved)
			{
				System.out.println("Target achieved in :" + iTransCnt + " target(s)");
				
			}
			else
			{
				System.out.println("Target not achieved");
			}
			setiTransCnt(0);
		}
		System.out.println("\n........Transaction operation completed.....");
	}

}//End of class Transaction
