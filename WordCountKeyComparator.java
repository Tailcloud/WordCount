package wordcount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class WordCountKeyComparator extends WritableComparator {
    
    public WordCountKeyComparator() {
        super(Text.class, true);
    }
    
    
    public int compare(WritableComparable o1, WritableComparable o2) {
        Text key1 = (Text) o1;
        Text key2 = (Text) o2;
        
        String text1 = key1.toString();
        String text2 = key2.toString();
        
        int flag = text1.compareTo(text2);
        if(flag>0){//text1>text2
            int check = text1.toLowerCase().compareTo(text2.toLowerCase());
            if(check>0){
                return 1;
            }else if(check==0){
                return 1;
            }else if(check<0){
                return -1;
            }
        }else if(flag==0){//text1=text2
            return 0;
        }else if(flag<0){//text1<text2
            int check = text1.toLowerCase().compareTo(text2.toLowerCase());
            if(check>0){
                return 1;
            }else if(check==0){
                return -1;
            }else if(check<0){
                return -1;
            }
        }
        return 0;
        
    }
}