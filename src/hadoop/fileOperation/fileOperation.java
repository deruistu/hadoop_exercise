package hadoop.fileOperation;

public class fileOperation {

	
	public static void main(String[] argv)
	{
		Configuration conf = new Configuration();
		// set the parameters on Configuration
		conf.set("fs.defaultFS","/");
		// get an instance of file system
		FileSystem fs = FileSystem.get(conf);
		//create a path for output stream to write file in hfds
		Path destPath = new Path("/"); // "/" means the root
		//create an output stream
		FSDataOutputStream os = fs.create(destPath);
		
		
		
	}
}
