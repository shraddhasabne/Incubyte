package calculator;

class StringCalculator {

 public int add(String input) 
	  {
		  	int i=0;
		  	int sum = 0;int a = 0;
		  	int length = input.length();
		  	String temp = "";
		  	TreeSet<String> del = new TreeSet();
		  	del.add("\n");
		  	del.add(",");
		  	ArrayList<Integer> negatives = new ArrayList();
		  	
		  	if(length>1 && input.charAt(0)=='/' && input.charAt(1)=='/')
		  	{
		  		boolean start = false;
		  		String del_temp = "";
		  		for(i=2;i<length && input.charAt(i)!='\n';i++)
			  	{
		  			if(start)
		  			{
		  				if(input.charAt(i)==']')
			  			{
		  					if(del_temp.length()>0)
		  						del.add(del_temp);
		  					del_temp = "";
			  				start=false;
			  			}
		  				else
		  				{
		  					del_temp = del_temp + input.charAt(i);
		  				}
		  			}
		  			else
		  			{
		  				if(input.charAt(i)=='[')
		  				{
			  				start=true;
			  			}
		  			}
			  	}
		  	}
		  	
		  	for(;i<length;i++)
		  	{
		  		boolean cont = false;
		  		char curr = input.charAt(i);
		  		Iterator<String> it = del.iterator();
		  		while(it.hasNext())
		  		{
		  			String del_curr = it.next();
		  			boolean del_found = true;
					int j=0
		  			for(;j<del_curr.length() && (i+j)<input.length();j++)
		  			{
		  				if(del_curr.charAt(j)!=input.charAt(i+j))
		  				{
		  					del_found=false;
		  				}
		  			}
					
		  			if(del_found)
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
			  	  		else if(a<=1000)
			  	  		{
				  	  		sum = sum + a;
			  	  		}
						temp = "";
			  	  		cont = true;
						break;
						i=i+j;
			  		}
		  		}
	         	if(!cont)
  			{
  				temp = temp + curr;
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
		  	else if(a<=1000)
		  	{
		  		sum = sum + a;
	  	  		temp = "";	
		  	}
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
						return "negatives not allowed"+exc;
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