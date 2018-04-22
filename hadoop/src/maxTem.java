import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by single on 16/11/26.
 */
public class maxTem {
    public static void main(String[] args) throws Exception {

        Job job = new Job();
        job.setJarByClass(MaxTemMapper.class);
        job.setJobName("Max temperature");

        FileInputFormat.addInputPath(job, new Path("/Users/liyajun/Desktop/1902"));
        FileInputFormat.addInputPath(job, new Path("/Users/liyajun/Desktop/1901"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/liyajun/Desktop/out"));

        job.setMapperClass(MaxTemMapper.class);
        job.setReducerClass(MaxTemReducer.class);
        job.setCombinerClass(MaxTemReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
