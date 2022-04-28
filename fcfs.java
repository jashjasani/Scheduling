class Main{
	public static void main(String[] args){
		int[] proc = {1,2,3};
		int[] bt = {10,5,8};
		fcfs(proc,bt);
	}
	public static void fcfs(int[] proc,int[] bt){
		int size = proc.length;
		int wt[] = new int[size];
		int tat[] = new int[size];
		
		calculateWaitingTime(wt,bt);
	
		calculateTat(tat,wt,bt);

		double avgWt = avgWtTime(wt);
		double avgTat = avgTatime(tat); 

		System.out.println("Process \t\tBurst Time \t\tTurnaround Time \tWaiting Time");

		for(int i=0;i<size;i++){
			System.out.println(proc[i]+"\t\t\t"+bt[i]+"\t\t\t"+tat[i]+"\t\t\t"+wt[i]);
		}
		
		System.out.println("Avg waiting time : "+avgWt);
		System.out.println("Avg tat : "+avgTat);
	}

	public static void calculateWaitingTime(int[] wt,int[] bt){
		wt[0]=0;
		for(int i=1;i<wt.length;i++){
			wt[i]=bt[i-1]+wt[i-1];
		}
	}

	public static void calculateTat(int[] tat,int[] wt,int[] bt){

		for(int i=0;i<tat.length;i++){
			tat[i]=wt[i]+bt[i];
		}
	}

	public static double avgWtTime(int[] wt){
		double total_wt=0;

		for(int i=0;i<wt.length;i++){
			total_wt+=wt[i];			
		}
		return (total_wt/wt.length);
	}

	public static double avgTatime(int[] tat){
		double total_tat=0;

		for(int i=0;i<tat.length;i++){
			total_tat+=tat[i];
		}
		return (total_tat/tat.length);
	}

}
