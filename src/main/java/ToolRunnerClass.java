
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUK
 */
public class ToolRunnerClass extends Configured implements Tool{
    
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new ToolRunnerClass(), args);
        System.exit(res);
    }

    @Override
    public int run(String[] strings) throws Exception {
        
    Configuration c = this.getConf();

    
    Path input=new Path("D:\\format ale na wielkiej kurwie\\NetBeansProjects\\Testowa\\target\\wordcount.txt");

    Path output=new Path("\\target\\out\\out1");

    Job j=new Job(c,"wordcount");

    j.setJarByClass(ToolRunnerClass.class);

    j.setMapperClass(NewServlet.MapForWordCount.class);

    j.setReducerClass(NewServlet.ReduceForWordCount.class);

    j.setOutputKeyClass(Text.class);

    j.setOutputValueClass(IntWritable.class);

    FileInputFormat.addInputPath(j, input);

    FileOutputFormat.setOutputPath(j, output);

    return j.waitForCompletion(true) ? 0 : 1;
    
    }
    
}
