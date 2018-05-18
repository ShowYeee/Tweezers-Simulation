package MiniProject;

public class Simulatingthedice {
	
	
	static int[][] total(int d , int n) {
		
		int thedata[][] = dicedata(d,n);
		int total[][] = totaltest(thedata,d);
		int simtotal[][] = new int [6][d+1];

		
		for(int i = 0 ; i < total.length ; i++) {
			for(int j = 0 ; j < total[i].length ; j++) {
				
				if(total[i][j] != 0) {
					simtotal[j][total[i][j]]++;
				}
				else {
					simtotal[j][0]++;
				}
				
			}	
		}
		return simtotal;
		
	}
	
	static int[][] dicedata(int d , int n) {
		
		int thedata[][] = new int[n][d];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < d ; j++) {
				thedata[i][j] = (int)(Math.random()*(6)+1) ;
			}
		}
		
		return thedata;
	}
	
	
	static int[][] totaltest (int a[][],int d) {
		
		int total[][] = new int[a.length][6];
		
		for(int i = 0 ; i < a.length ; i++) {
			for(int j = 0 ; j < d ; j++) {
				
				for(int k = 1 ; k <= 6 ; k++)if(a[i][j] == k)total[i][k-1]++;
			}
		}
		
		return total;
		
	}

}
