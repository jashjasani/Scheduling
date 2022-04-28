class Main{
	public static void main(String[] args){
		int[] proc={1,2,3};
		int[] bt={10,5,8};


		findAvgTime(proc,bt,3);	

	}

	public static void findAvgTime(int[] proc,int[] bt,int quantum){
		int size = proc.length;
		int[] wt = new int[size];
		int[] tat = new int[size];
		double total_tat=0,total_wt=0;

		findAvgWt(proc,wt,bt,quantum);

		findAvgTat(proc,wt,bt,tat);
			
		System.out.println("Process\t\tBurst time\t\tWaiting T\t\tTurn Around");
		for(int i=0;i<proc.length;i++){
			System.out.println(proc[i]+"\t\t"+bt[i]+"\t\t\t"+wt[i]+"\t\t\t"+tat[i]);
			total_wt+=wt[i];
			total_tat+=tat[i];
		}
		System.out.println("Avg waiting time : "+(total_wt/size));
		System.out.println("Avg turn around time : "+(total_tat/size));
	}

	public static void findAvgWt(int[] proc,int[] wt,int[] bt,int quantum){

		int[] rem_bt = new int[proc.length];
		int total_time=0;

		for(int i=0;i<proc.length;i++){
			rem_bt[i]=bt[i];
		}

		while(true){
			boolean done = true;
			for(int i=0;i<proc.length;i++){
				if(rem_bt[i]>0){

					done=false;
					
					if(rem_bt[i]>quantum){
						total_time+=quantum;
						rem_bt[i]-=quantum;						
					}
					else{

						total_time+=rem_bt[i];

						wt[i]=total_time-bt[i];

						rem_bt[i]=0;
					}
				}			
			}
			if(done==true)
				break;
		}
	}
	public static void findAvgTat(int[] proc,int[] wt,int[] bt,int[] tat){
		for(int i=0;i<proc.length;i++){
			tat[i]=wt[i]+bt[i];
		}
	}
	
}
