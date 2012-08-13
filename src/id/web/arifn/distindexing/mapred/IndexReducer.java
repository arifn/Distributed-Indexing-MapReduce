
/*
 * IndexReducer.java
 *
 * Created on May 15, 2012, 6:29:45 AM
 */

package id.web.arifn.distindexing.mapred;


import id.web.arifn.distindexing.writable.DocSumWritable;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 *
 * @author arifn
 */
public class IndexReducer extends MapReduceBase implements Reducer<Text,Text,Text,DocSumWritable> {
	
	private HashMap<String, Integer> map;


	private void add(String tag) {
        Integer val;

        if (map.get(tag) != null) {
          val = map.get(tag);
          map.remove(tag);
        } else {
          val = 0;
        }

        map.put(tag, val+1);
    }
	
	@Override
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, DocSumWritable> output, Reporter reporter)
            throws IOException {
		 map = new HashMap<String, Integer>();

	        while(values.hasNext()){
	            add(values.next().toString());
	        }

	        output.collect(key, new DocSumWritable(map));
        	
    }
}
