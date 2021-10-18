package calculator;

class StringCalculator {

    public int add(String input) 
    {
    	int a = 0; int b = 0; int sum = 0;
    	StringTokenizer st = new StringTokenizer(input,",");
    	if(st.hasMoreTokens())
    	{
    		String temp = st.nextToken();
    		try
    		{
    			a = Integer.parseInt(temp);
    		}
    		catch(Exception e)
    		{
    			a = 0;
    		}
    	}
    	if(st.hasMoreTokens())
    	{
    		String temp = st.nextToken();
    		try
    		{
    			b = Integer.parseInt(temp);
    		}
    		catch(Exception e)
    		{
   			b = 0;
    		}
    	}
    	sum = a + b;
//    	System.out.println(input+"  "+sum);
        return sum;
    }

}