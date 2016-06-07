package hadoop.dbscan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClusterCombiner {

	public static void clusterCombine(File f)
	{
		
		int[] primitiveCluster;
		String line;
		boolean label;
		List<Integer> visitedPoints;
		
		label =true;
		visitedPoints = new ArrayList<Integer>();
		
		
		while(label){
			
		//initial the computing
		line = f.readline().split(",");
		
		//judge whether the loop need to end.
		if(line==NULL) // read all lines
		{
			label = false;
			continue;
		}
			
		//judge whether the point has been visited, if it is yes,cancel.
		if(visitedPoints.contains(line[0]));
			continue;
		
		List<Integer> cluster = new ArrayList<Integer>();
		
		//give a initial cluster
		for(String lineData : line)
		{
			cluster.add(Integer(lineData));
		}
		
		f.close();
		
		f.open(); // open file again
		
		while(!f.readline())
		{
			line = f.readline().split(",");
			for(String lineData : line)
			{
				if(cluster.contains(line))
				{
					//to do
					// add all the elements in line into cluster, then sort by ascend
					//then break;
				}
			}
		}
		
		}
	}
	
	public static void main(String[] argv)
	{
		
	}

}
