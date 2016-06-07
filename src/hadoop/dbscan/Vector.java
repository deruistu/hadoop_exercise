package hadoop.dbscan;

public class Vector {
	private double[] vector;
	
	public Vector(int n){
		vector = new double[n];
	}
	
	public double[] getVector(){
		return this.vector;
	}
	
	public void setVector(double[] vector)
	{
		this.vector=vector;
	}
	
	public double[] changeFromString(String[] vector){
		for(int i =1 ; i<vector.length;i++)
		{
			this.vector[i-1]=Double.parseDouble(vector[i]);
		}
		return this.vector;
	}
}
