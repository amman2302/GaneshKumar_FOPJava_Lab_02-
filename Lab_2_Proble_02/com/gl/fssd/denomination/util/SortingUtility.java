package com.gl.fssd.denomination.util;

public class SortingUtility {
	
	public static void mergeSort(int[] iArr)
	{
		mergeSort(iArr, 0, iArr.length - 1);
	}//End of mergeSort(int[] iArr)

	private static void mergeSort(int [] iArr, int iLeft, int iRight)
	{
		if(iLeft < iRight)
		{
			int iMid = (iLeft + iRight ) / 2;
			mergeSort(iArr, iLeft, iMid);
			mergeSort(iArr, iMid+1, iRight);
			merge(iArr, iLeft, iMid, iRight);
		}
	}//End of mergeSort(int [] iArr, int iLeft, int iRight)

	private static void merge(int[] iArr, int iLeft, int iMid, int iRight)
	{

		int n1 = iMid - iLeft + 1;
		int n2 = iRight - iMid;
		int [] iArrLeft = new int[n1];
		int [] iArrRight = new int[n2];
		
		for (int i = 0; i< n1; i++)
		{
			iArrLeft[i] = iArr[iLeft + i];
		}
		for (int i = 0; i< n2; i++)
		{
			iArrRight[i] = iArr[iMid + i + 1];
		}
		int i = 0, j = 0, k = iLeft;
		
		while(i<n1 && j<n2)
		{
			if (iArrLeft[i] < iArrRight[j])
			{
				iArr[k++] = iArrLeft[i++];
			}
			else
			{
				iArr[k++] = iArrRight[j++];
			}
		}
		while (i < n1)
		{
			iArr[k++] = iArrLeft[i++];
		}
		while (j<n2)
		{
			iArr[k++] = iArrRight[j++];
		}
	
	} //End of merge(int[] iArr, int iLeft, int iMid, int iRight)
}