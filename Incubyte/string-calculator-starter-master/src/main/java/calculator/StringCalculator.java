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
	  	ArrayList<Integer> negatives = new ArrayList();
	  	
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
		  	  		if(a<0)
		  	  		{
		  	  			negatives.add(a);
		  	  		}
		  	  		else
		  	  		{
			  	  		sum = sum + a;	
		  	  		}
		  	  		cont = true;
					temp = "";
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
		if(a<0)
	  	{
	  		negatives.add(a);
	  	}
	  	else
	  	{
	  		sum = sum + a;  	  		
	  	}
		temp = "";
		int n_neg = negatives.size();
		if(n_neg>0)
		{
			class MyException extends Exception
			{
				String exc = "";
				public MyException(String exc)
				{
					super(exc);
					this.exc = exc;
				}
				
				@Override
				public String toString()
				{
					return "negatives not allowed "+exc;
				}
			}
			try
			{
				throw new MyException(Arrays.toString(negatives.toArray()));
			}
			catch(MyException e)
			{
				System.out.println(e);
			}
			
		}
		
	  	
	  	System.out.println(input+"  "+sum);
	    return sum;
  }

}