package hadoop.dbscan;

import java.util.List;

public class corePointMapper extends Mapper<LongWritable, Text, LongWritable, Information>{
	
	private Configuration conf;
	private FileSystem fs;
	Path outputRelatedPointPath;
	FSDataOutputStream os;
	
	public corePointMapper() //here should be setup function
	{
		conf = new Configuration();
		fs = FileSystem.get(conf);
		outputRelatedPointPath = new Path("/abc.txt"); // define the file name
		os = fs.create(outputRelatedPointPath);
		
	}
	
	
	public void map(LongWritable key, Text value, Mapper.Context.context) throws IOException, InterruptedException{
		String[] acceptedString;
		int id;
		double[] pointVector;
		double epsilon; // the radius of limitation
		List<Integer> neighbors;
		Information exchangeInfo;
		int minimun;
		
		int core =0;
		Vector v = new Vector(acceptedString.length);

		//arrange the value
		id = acceptedString[0];
		pointVector = v.changeFromString(acceptedString);
		
		neighbors = MeasureClass.computeNeighbor(epsilon, pointVector);
		neighbors.add(id);
		
		Collections.sort(neighbors);
		if (neighbor.length() > minpt){
			core =1;
			//to do 
			// write the list of neighbors into hdfs
			os.writeLine(neighbors); // with the neighbors into.
		}
		
		
		minimun = neighbors.get(0);
		exchangeInfo = new Information();
		
		//only send core point to reducer to handle
		if(core == 1){
			exchangeInfo.setCore(1);
			exchangeInfo.setMinimun(minimun);
			context.write(id,exchangeInfo);
		}
		
	}

}
