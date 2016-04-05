package wordcount;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private IntWritable one = new IntWritable(1);
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		StringTokenizer itr = new StringTokenizer(value.toString(), " \t");

		while (itr.hasMoreTokens()) {

			String toProcess = itr.nextToken();
			String char1 = toProcess.substring(0,1);
			if(char1.matches("^[a-zA-Z]"))
    			context.write(new Text(char1), new IntWritable(1))

		}


	}
}

