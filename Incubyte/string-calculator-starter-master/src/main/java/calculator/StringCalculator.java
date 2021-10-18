package calculator;

class StringCalculator {

   public int add(String input) 
  {
	  	int i=0;
	  	int sum = 0;int a = 0;
	  	int length = input.length();
	  	String temp = "";
	  	TreeSet<Character> del = new TreeSet();
	  	del.add('\n');
	  	del.add(',');
	  	
	  	if(length>1 && input.charAt(0)=='/' && input.charAt(1)=='/')
	  	{
	  		for(i=2;i<length && input.charAt(i)!='\n';i++)
		  	{
		  		del.add(input.charAt(i));
		  	}
	  	}
	  	
	  	for(;i<length;i++)
	  	{
	  		boolean cont = false;
	  		char curr = input.charAt(i);
	  		Iterator<Character> it = del.iterator();
	  		while(it.hasNext())
	  		{
	  			if(curr==it.next())
	  			{
	  				a = 0;
		  	  		try
		  	  		{
		  	  			a = Integer.parseInt(temp);
		  	  		}
		  	  		catch(Exception e)
		  	  		{
		  	  			a = 0;
		  	  		}
		  	  		sum = sum + a;
		  	  		temp = "";
		  	  		cont = true;
		  		}
		  		if(!cont)
		  		{
		  			temp = temp + curr;
		  		}
	  		}
	  	}
	  	
	  	a = 0;
		try
		{
			a = Integer.parseInt(temp);
		}
		catch(Exception e)
		{
			a = 0;
		}
		sum = sum + a;
		temp = "";
	  	
	  	System.out.println(input+"  "+sum);
	    return sum;
  }

}