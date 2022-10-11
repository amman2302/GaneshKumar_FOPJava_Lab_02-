/**
 * 
 */
package com.gl.fssd.paymoney.main;

import java.util.Scanner;
import com.gl.fssd.paymoney.transaction.*;
/**
 * @author SMGRL
 *
 */
public class DriverClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Transaction transObj = new Transaction();
		Scanner scObj = new Scanner(System.in);
		
		System.out.println("Please input  number of transactions:");
		int noOfTransaction = scObj.nextInt();	// number of transactions
		transObj.setiTotal_no_transacction(noOfTransaction);
		
		int [] transArray = new int[noOfTransaction]; 
		System.out.println("Input the transaction values");
		for (int i = 0; i< noOfTransaction; i++)	// input noOfTransaction inputs in array
		{
			transArray[i]= scObj.nextInt();
		}
		transObj.setiArrTransacctionValues(transArray);
		
		System.out.println("Please input number of targets:");
		int noOfTargets = scObj.nextInt();
		transObj.setiTotal_no_target(noOfTargets);
		transObj.doTransactionOperations();
	}

}
