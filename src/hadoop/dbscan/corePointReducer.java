package hadoop.dbscan;

import java.util.ArrayList;
import java.util.Collections;

public class corePointReducer extends Reducer<LongWritable, Information, LongWritable,Text>{

	private Configuration conf;
	private FSDataOutputStream os;
	private FileSystem fs;
	private Path outputSameCluster;
	
	public corePointReducer() // here should be setup function. this function only excute one time.
	{
		conf = new Configuration();
		fs = FileSystem.get(conf);
		outputSameCluster = new Path("/cluterFile.txt");
		os = fs.create(outputSameCluster);
		
	}
	
	public void reduce(LongWritable key,Iterable<Information> values, Context context){
		
		ArrayList<Integer> storeClassificateNo = new ArrayList<Integer>();
		int count =0;
		boolean core = false;
		for(Information info : values)
		{
			if(info.getCore()==1)
			{
				core = true;
			}
			if(!storeClassificateNo.contains(info.getMinimun()))
			{
				storeClassificateNo.add(info.getMinimun());
			}
		}
		
		if(storeClassificateNo.size()>=2 && core) // this condition means the input key is a shared point. 
		{
			//to do
			// write(storeClassificateNo.) in to a hdfs file.
			String outputString="";
			
			Collections.sort(storeClassificateNo);
			key = storeClassificateNo.get(0);
			storeClassificateNo.remove(0);
			
			int i=0;
			while(i<storeClassificateNo.size()-1)
			{
				outputString+=storeClassificateNo.get(i).toString()+",";
			}
			outputString = outputString + storeClassificateNo.get(storeClassificateNo.size()-1);
			context.write(key,new Text(outputString)); //return one line to write into file.
			//
		}
	}
}
