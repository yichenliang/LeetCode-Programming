/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    char[] buff4 = new char[4];
    int ptr4 = 0;
    int count4 = 0;
    
    public int read(char[] buf, int n) {
        int result = 0; // the actual number we read from file in this read call, and return this number 
        
        while(result < n){
            
            if(ptr4 == 0){
               count4 = read4(buff4);
            }
           
            if(count4 == 0) break;
        
            while(ptr4 < count4 && result < n){
                buf[result] = buff4[ptr4];
                ptr4++;
                result++;
            }
            
            if(ptr4 >= count4){
                ptr4 = 0;
            }
        }
        
        return result;
    }
}

// variable definition:
//  buff4: store the content read from read4, need to be global variable, because it need to remeber the result from the last round
//  ptr4: record the number which have not been read in buff4, need to be global, ...
//  count4: the actual number of characters in buff4 (actual size)

//time complexity: O(N)
//space complexity: O(1)