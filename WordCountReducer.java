package wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import sun.awt.SunHints.Value;

public class WordCountReducer extends Reducer<Text,IntWritable,???,???> {
	
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int count = 0;
		// agrregate the amount of same starting character
		for (IntWritable val: values) {
			System.out.println("in reducer:%s and %s",values,val);
			count += val.get();
		}
		context.write(key,new IntWritable(count));
		
	}
}
