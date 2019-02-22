//657. Judge Route Circle
//Approach: switch


class Solution {
   
     public boolean judgeCircle(String moves) {
    	 
    	 if(moves == null) return false;
    	 if(moves.length() == 0 ) return true;
    	 
    	 char[] moveArr = moves.toCharArray();
    	 
    	 int Ucount = 0;
    	 int Dcount = 0;
    	 int Lcount = 0;
    	 int Rcount = 0;
    	 
    	 for(char move : moveArr) {
    		 switch(move) {
    		 case 'U':
                      Ucount++; 
                      break;
    		 case 'D':
    			      Dcount++;
    			      break;
    		 case 'L':
    			      Lcount++;
    			      break;
    		 case 'R':
                      Rcount++;
                      break;
             default:
            	   return false;
    		 }
    	 }
    	 
    	 if(Ucount == Dcount && Lcount == Rcount) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
    	 
    }

   public static void main(String args[])
    {
		Solution solution = new Solution();
		//String input = "UD" ;
		String input = "LL" ;
		
		boolean res = solution.judgeCircle(input);
		System.out.println(res);
    }
}


