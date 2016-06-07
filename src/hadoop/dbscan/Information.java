package hadoop.dbscan;

public class Information {

	private int minimun;
	private int core;
	
	public Information(){
		this.setMinimun(-1);
		this.setCore(0);
	}

	public int getMinimun() {
		return minimun;
	}

	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}

	public int getCore() {
		return core;
	}

	public void setCore(int core) {
		this.core = core;
	}
	
}
