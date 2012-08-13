package id.web.arifn.distindexing.writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class DocSumWritable implements Writable{

	private HashMap<String,Integer> map = new HashMap<String, Integer>();
	
	public DocSumWritable() {
    }

    public DocSumWritable(HashMap<String,Integer> map){

    	this.map = map;
    }
    
    private Integer getCount(String tag){
        return map.get(tag);
    }
	
	@Override
	public void readFields(DataInput in) throws IOException {
		Iterator<String> it = map.keySet().iterator();
        Text tag = new Text();        

        while(it.hasNext()){
        	String t = it.next();
            tag = new Text(t);            
            tag.readFields(in);
            new IntWritable(getCount(t)).readFields(in);
        }
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		Iterator<String> it = map.keySet().iterator();
        Text tag = new Text();
        IntWritable count = new IntWritable();
        
        while(it.hasNext()){            
        	String t = it.next();            
            new Text(t).write(out);
            new IntWritable(getCount(t)).write(out);
        }
		
	}

	@Override
    public String toString() {        

		String output = "";
        
        for(String tag : map.keySet()){        	                                   
            output += (tag+"=>"+getCount(tag).toString()+" ");
        }
        
        

        return output;
        
    }
	
}
