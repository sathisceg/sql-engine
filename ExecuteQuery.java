import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

public class ExecuteQuery<E> {
	
	
	
	public static void printColumn(ArrayList<ArrayList<String>> allcolumns,int r,int c)
	{
		for(int i=0;i<r;i++)
  		{
  			
  			for(int j=0;j<allcolumns.size();j++)
  			{
  				System.out.print(allcolumns.get(j).get(i)+"        ");
  			}
  			System.out.println();
  			
  		}
	}
	
	
	public static void findMax(ArrayList<String>al,String Choice) 
	{
		int max=0;
		int sum=0;
	  	int min=1000000;  	
		if(Choice.equals("max"))
		{				
	  	  for(int i=0;i<al.size();i++)
	  	  {
	  		 // System.out.println(alltables.get(tableName).get(tcol).get(i));
	  		  
	  		  if(max<Integer.parseInt((String) al.get(i)))
	  		  {
	  			  max =Integer.parseInt((String) al.get(i));
	  		  }	  		  
	  	  }	  	  	  	  
	  	  System.out.println("max :"+max);
		}
		else if(Choice.equals("min"))
		{
			 for(int i=0;i<al.size();i++)
		  	  {
		  		 // System.out.println(alltables.get(tableName).get(tcol).get(i));
		  		  
		  		  if(min>Integer.parseInt((String) al.get(i)))
		  		  {
		  			min =Integer.parseInt((String) al.get(i));
		  		  }	  		  
		  	  }	  	  	  	  
		  	  System.out.println("min :"+min);
		}
		else if(Choice.equals("sum"))
		{
			 for(int i=0;i<al.size();i++)
		  	  {
		  		 // System.out.println(alltables.get(tableName).get(tcol).get(i));
		  		  
		  		 sum+=Integer.parseInt((String) al.get(i));
		  		  
		  			
		  		 	  		  
		  	  }	  	  	  	  
		  	  System.out.println("Sum :"+sum);
		}
		
		else if(Choice.equals("avg"))
		{
			 for(int i=0;i<al.size();i++)
		  	  {
		  		 // System.out.println(alltables.get(tableName).get(tcol).get(i));
		  		  
		  		 sum+=Integer.parseInt((String) al.get(i));
		  		  
		  			
		  		 	  		  
		  	  }	  	  	  	  
		  	  System.out.println("avg :"+sum/al.size());
		}
	}
	
	public static void printParticularColumn(ArrayList<ArrayList<String>> allcolumns,String reqcol[],String Choice) 
	{
		
		if(Choice.equals("distinct"))
		{
			
			String temp="";
			
			ArrayList <String> al = new ArrayList<>();
			
			
			for(int i=0;i<allcolumns.get(0).size();i++)
	  		{
				temp="";
	  			for(int j=0;j<reqcol.length;j++)
	  			{	  					  				
	  				temp+=":"+allcolumns.get(j).get(i);
	  			}	  			
	  			al.add(temp);
	  			//al.add(temp);
	  			
	  			
	  		}
			
			//System.out.println(al);
			
		     Set<String> withoutduplicatesset = new LinkedHashSet<String>(al);  
		     //System.out.println(withoutduplicatesset);  
		     
		     
		     Iterator < String > ir2 = withoutduplicatesset.iterator();
			
			
				while(ir2.hasNext())	
				{						
					//System.out.println(ir2.next().toString().split(":"));	
					
					String stemp[] = ir2.next().toString().split(":");
					
					for(int i=0;i<stemp.length;i++)
					{
						System.out.print(stemp[i]+"   ");
					}
					
					System.out.println();
				}					
			
		     
		    
			
		}
		else
		{
			for(int i=0;i<allcolumns.get(0).size();i++)
	  		{
	  			
	  			for(int j=0;j<reqcol.length;j++)
	  			{
	  				System.out.print(allcolumns.get(j).get(i)+"         ");
	  			}
	  			System.out.println();
	  			
	  		}
		}
	}
	
	public static <E> void printColumnsFromTwoTable(ArrayList<ArrayList<String>> allcolumns1,ArrayList<E> reqcol1,ArrayList<ArrayList<String>> allcolumns2,ArrayList reqcol2,char colname)
	{
		
		
//		System.out.println(allcolumns1);
//  		
//  		System.out.println(allcolumns2);
				String temp="";
		
				ArrayList <String> altable1 = new ArrayList<>();
				ArrayList <String> altable2 = new ArrayList<>();
				
				ArrayList <String> commonColumnValue = new ArrayList<>();

				ArrayList <String> alr = new ArrayList<>();
				
				HashMap<Integer, String> table2 = new HashMap<>();
				
				int numberIn1;
				
				for(int i=0;i<allcolumns1.get(0).size();i++)
		  		{
		  			temp="";
		  			for(int j=0;j<reqcol1.size();j++)
		  			{
		  				temp+=" "+allcolumns1.get(j).get(i);
		  				
		  				//System.out.println(reqcol1.get(j).equals(String.valueOf(colname)));
		  				
		  				if(reqcol1.get(j).equals(String.valueOf(colname)))
		  				{	  					
		  					commonColumnValue.add(allcolumns1.get(j).get(i));		  					
		  				}
		  				
		  			}	  			
		  			altable1.add(temp);
		  			
		  		}
				
				
				//System.out.println(commonColumnValue);
				//System.out.println(commonColumnValue.contains("1528"));
				
						
				int flag=0;
				int pos=0;
				for(int i=0;i<allcolumns2.get(0).size();i++)
		  		{
		  			temp="";
		  			
		  			for(int j=0;j<reqcol2.size();j++)
		  			{
		  				
		  				if(!(reqcol2.get(j).equals(String.valueOf(colname))))
		  				{
		  					temp+=" "+allcolumns2.get(j).get(i);
		  				}		  				
		  				//System.out.println(reqcol2.get(j).equals("B"));
		  				if(reqcol2.get(j).equals(String.valueOf(colname)))
		  				{
		  					//System.out.println(allcolumns2.get(j).get(i));	
		  					if(commonColumnValue.contains(allcolumns2.get(j).get(i)))
		  					{
		  						flag=1;		  						
		  						pos = commonColumnValue.indexOf(allcolumns2.get(j).get(i));		  								  								  						
		  						//System.out.println(pos);
		  					}
		  				}
		  			}	 
		  					  			
		  			if(flag==1)
		  			{
		  				table2.put(pos, temp);
		  			}
		  			
		  			flag=0;		  					  			
		  		}
								
				
				//System.out.println(table2);
				
				for(int i=0;i<altable1.size();i++)
				{
					
					if(table2.get(i)!=null)
					{
						System.out.print(altable1.get(i)+"  ");
						
						System.out.println(table2.get(i));
						
						System.out.println();
					}
					
				}
  		
		
	}
	
	
	public static ArrayList<String> convertAllColumnsToArrayList(ArrayList<ArrayList<String>> allcolumns,ArrayList<String> reqcol)
	{
		String temp="";
		
		ArrayList <String> altable = new ArrayList<>();
		
		
		for(int i=0;i<allcolumns.get(0).size();i++)
  		{
  			temp="";
  			for(int j=0;j<reqcol.size();j++)
  			{
  				temp+=reqcol.get(j)+" "+allcolumns.get(j).get(i)+" ";  				  				  				
  			}	  			
  			altable.add(temp);  			  			  			
  		}		
		//System.out.println(altable);		
		return altable;
	}
	
	
	public static void printColumnsforCrossJoinOfTwoTables(ArrayList<String> list1, ArrayList<String> list2) {
		String stemp = "";
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				// System.out.print(table1String.get(i));
				// System.out.print(table2String.get(j));
				stemp += list1.get(i) + list2.get(j);

				if (temp.contains(stemp)) {
					continue;
				}
				temp.add(stemp);
				stemp = "";
			}
		}

		for (int i = 0; i < temp.size(); i++) {
			// System.out.println(temp.get(i));
			String Split[] = temp.get(i).toString().split(" ");
			for (int j = 1; j < Split.length; j = j + 2) {
				System.out.print(" " + Split[j]);
			}
			System.out.println();
		}
	}
	
	public static <E> void crossJoinOfTable(ArrayList<ArrayList<String>> allcolumns1,ArrayList<String> reqcol1,ArrayList<ArrayList<String>> allcolumns2,ArrayList reqcol2,int condition,ArrayList givenCondition,String type)
	{
		
		
		ArrayList <String> table1String = convertAllColumnsToArrayList(allcolumns1,reqcol1);
		ArrayList <String> table2String = convertAllColumnsToArrayList(allcolumns2,reqcol2);
		
		if(condition==0)
		{			
			printColumnsforCrossJoinOfTwoTables(table1String,table2String);
		}
		else 
		{
			
		}				
		//System.out.println("inside cross join function");
						
	}
	
	public static ArrayList<Integer> getSelectedRowFromGivenCondition(HashMap<String, String> conditionMap,
			HashMap<String, ArrayList<String>> mapforTable1) {
		ArrayList<Integer> selectedRowsTable = new ArrayList<>();

		for (String key : conditionMap.keySet()) {

			if (mapforTable1.get(key) != null) {
				for (int j = 0; j < mapforTable1.get(key).size(); j++) {
					// System.out.println(mapforTable1.get(key).get(j));
					if (mapforTable1.get(key).get(j).equals(conditionMap.get(key))) {
						//System.out.println("j " + j);
						selectedRowsTable.add(j);
					}
				}
			}
		}

		return selectedRowsTable;
	}	
	
	
	public static HashMap<Integer, String> combineAllColumnsToFormRow(HashMap<String, ArrayList<String>> mapforTable) {

		HashMap<Integer, String> allRowsOfTable = new HashMap<>();

		String temp = "";

		int first = 1;

		for (String key : mapforTable.keySet()) {

			temp = "";
			for (int j = 0; j < mapforTable.get(key).size(); j++) {				
				if (first == 1) {
					//System.out.println(mapforTable.get(key).get(j));
					allRowsOfTable.put(j, mapforTable.get(key).get(j));
				} else {
					// System.out.println(mapforTable1.get(key).get(j));
					// temp+=allRowsTable1.get(j)+mapforTable1.get(key).get(j);
					// allRowsTable1.add(j, temp);
					temp = allRowsOfTable.get(j);
					String stemp = temp + " " + mapforTable.get(key).get(j);
					allRowsOfTable.put(j, stemp);
				}

			}

			first = 2;

		}

		return allRowsOfTable;
	}
	
	
	public static void printColumnsfromTwoTableCrossJoinANDCondition(HashMap<Integer,String>allRowsTable1,ArrayList <Integer> selectedRowsTable1 ,HashMap<Integer,String>allRowsTable2,ArrayList <Integer> selectedRowsTable2)
	{
		for(int i=0;i<selectedRowsTable1.size();i++)
		{
			System.out.print(allRowsTable1.get(selectedRowsTable1.get(i)));
			
			for(int j=0;j<selectedRowsTable2.size();j++)
			{
				System.out.print(" "+allRowsTable2.get(selectedRowsTable2.get(j)));
			}
			
			System.out.println();
		}
	}
	
	
	public static void printColumnsfromTwoTableCrossJoinORCondition(HashMap<Integer,String>allRowsTable1,ArrayList <Integer> selectedRowsTable1 ,HashMap<Integer,String>allRowsTable2,ArrayList <Integer> selectedRowsTable2,int order)
	{
		for(int i=0;i<selectedRowsTable2.size();i++)
		{
			
			
			for(int j=0;j<allRowsTable2.size();j++)
			{
				if(order==1)
				{
					System.out.print(allRowsTable1.get(selectedRowsTable1.get(i)));
					System.out.print(" "+allRowsTable2.get(j));
				}
				else
				{
					System.out.print(allRowsTable2.get(j));
					System.out.print(" "+allRowsTable1.get(selectedRowsTable1.get(i)));
				
				}
				

				System.out.println();
			}
			
		}
	}
	
	
	
	
	
	public static <E> void crossJoinOfTableWithGivenColumns(HashMap<String, ArrayList<String>> mapforTable1,
			ArrayList<String> reqcol1, HashMap<String, ArrayList<String>> mapforTable2, ArrayList reqcol2,
			int condition, HashMap<String, String> conditionMap, String type,String typeOfRelation)
	{
		
		//System.out.println("inside crossJoinOfTableWithGivenColumns");
					
		HashMap<Integer,String>allRowsTable1=combineAllColumnsToFormRow(mapforTable1);
		
		ArrayList <Integer> selectedRowsTable1 = getSelectedRowFromGivenCondition(conditionMap,mapforTable1);
		
		HashMap<Integer,String>allRowsTable2= combineAllColumnsToFormRow(mapforTable2);
		
		ArrayList <Integer> selectedRowsTable2 = getSelectedRowFromGivenCondition(conditionMap,mapforTable2);
		
				
		//System.out.println("before flag");
		//System.out.println(selectedRowsTable1);
		//System.out.println(selectedRowsTable2);
		
		int flag=0;
		
		if(type.equals("OR"))
		{
			if(selectedRowsTable1.size()==0&&selectedRowsTable2.size()==0)
			{
				System.out.println("OR Condition failed");
				
				
			}
			
			if(selectedRowsTable1.size()>0)
			{
				if (selectedRowsTable2.size() == 0) {
					// System.out.println("selectedRowsTable2 is empty");

					for (int key : allRowsTable2.keySet()) {
						for (int i = 0; i < selectedRowsTable1.size(); i++) {

							System.out.print(allRowsTable1.get(selectedRowsTable1.get(i)));
							System.out.print(" " + allRowsTable2.get(key));

						}
						System.out.println();

					}

				} else {
					printColumnsfromTwoTableCrossJoinORCondition(allRowsTable1, selectedRowsTable1, allRowsTable2,
							selectedRowsTable2,1);
				}
			}
			
			if(selectedRowsTable2.size()>0)
			{

				if (selectedRowsTable1.size() == 0) {
					// System.out.println("selectedRowsTable1 is empty");

					for (int key : allRowsTable1.keySet()) {
						for (int i = 0; i < selectedRowsTable2.size(); i++) {
							System.out.print(allRowsTable1.get(key));
							System.out.print(" " + allRowsTable2.get(selectedRowsTable2.get(i)));

						}
						System.out.println();

					}

				} else {
					printColumnsfromTwoTableCrossJoinORCondition(allRowsTable2, selectedRowsTable2, allRowsTable1,
							selectedRowsTable1,2);

				}

			}
			
			
		}
		else if(type.equals("AND"))
		{
			flag=1;
			
			if(selectedRowsTable1.size()>0&&selectedRowsTable2.size()>0)
			{
				printColumnsfromTwoTableCrossJoinANDCondition(allRowsTable1,selectedRowsTable1,allRowsTable2,selectedRowsTable2);
			}
			else
			{
				System.out.println("AND condition failed");
			}
		}
		
		
		
		
			
	}


	public static void main(String args[]) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("metadata.txt"));

		int flag = 0;
		String line = "";

		
		HashMap <String,Integer> numberOfColums = new HashMap<String,Integer>();
		
		HashMap<String, HashMap<String, ArrayList>> alltables = new HashMap<String, HashMap<String, ArrayList>>();
		
		String tableName = null;
		
		int count=0;

		while ((line = br.readLine()) != null) 
		{
			
			if (line.startsWith("<begin")) 
			{
				flag = 1;

			}
			else if (line.startsWith("<end")) 
			{

				flag = 0;
				
				numberOfColums.put(tableName,count);
				count=0;
			}

			if (flag == 1)
			{

				if (line.startsWith("<begin")) 
				{
					
					continue;
				} 
				else if (line.startsWith("table")) 
				{
				
					tableName = line;
					HashMap temp = new HashMap<String, ArrayList>();
					
					alltables.put(line, temp);
					
					numberOfColums.put(tableName, null);
					
				} 
				else 
				{
					
					ArrayList column = new ArrayList();

					
					alltables.get(tableName).put(line, column);
					
					count++;
				}

			}

		}
		
		
		
		//System.out.println(alltables.keySet());
		
		Set<String> listofTable = alltables.keySet();
		Iterator < String > ir1 = listofTable.iterator();
		
		
		
		while(ir1.hasNext())
		{
			
			tableName = ir1.next();
			String fileName = tableName+".csv";
						
			br = new BufferedReader(new FileReader(fileName));
						
			Set<String> columnsofTable = alltables.get(tableName).keySet();
					
			while((line=br.readLine())!=null)
			{
							
				String temp[] = line.split(",");
				
				Iterator < String > ir2 = columnsofTable.iterator();
				
				for(int i=0;i<temp.length;i++)
				{
					if(ir2.hasNext())	
					{						
						alltables.get(tableName).get(ir2.next()).add(temp[i]);						
						
					}					
				}
								
			}						
			
		}
		
			
				
		//System.out.println(alltables.get("table1"));
		//System.out.println(alltables.get("table2"));
		
		//System.out.println(alltables);
		
		
		//Scanner sc = new Scanner(System.in);
		
		//System.out.println(args[0]);
		String inputQuery = args[0];

		//System.out.println(inputQuery);
		
		//String inputQuery = "select * from table1, table2 where table1.B=table2.B;";
		
		String pattern1 = "(.*)(select)(\\s+)([*]|[a-z0-9A-Z\\s,]+)(\\s+)(from)(\\s+)(.*)";
		
		String pattern2 = "(.*)(select)(\\s+)([*]|[a-z0-9A-Z\\s,()]+)(\\s+)(from)(\\s+)(.*)";

		Pattern r1 = Pattern.compile(pattern1);
	      
        Matcher m1 = r1.matcher(inputQuery);
	      
        Pattern r2 = Pattern.compile(pattern2);
	      
        Matcher m2 = r2.matcher(inputQuery);
        
       // System.out.println(m1.matches());
        
       // System.out.println(m2.matches());
        
        
	      
	    if(m1.matches())
	    {
	    	//to display columns
	    		
	    	//	System.out.println();
	    	
	    	//	System.out.println(m1.groupCount());
		      
		      // for(int i=1;i<=m1.groupCount();i++)
		      // {
		    	 //  System.out.println("Found value: "+i + m1.group(i) );
		      // }
		      
		      
		      
		      int flagforWithoutJoin=1;
		      
		      int flagCrossJoin=0;
		      
		      //System.out.println("Found value: " + m1.group(8)) ;
		      
		      if(m1.group(8).contains(","))
		      {
		    	  //System.out.println("cross join");
	    		  flagCrossJoin=1;
		      }
		      
		      
		      String joinSplitArray[] = null;
		      if(m1.group(8).contains("="))
		      {
		    	  joinSplitArray  = m1.group(8).toString().split("where");
		    	  
		    	  for(int i=0;i<joinSplitArray.length;i++)
		    	  {
		    		  //System.out.println(i+"  "+joinSplitArray[i]);
		    		  
		    		  
		    	  }
		    	  
		    	  if(joinSplitArray[0].contains(",")&&joinSplitArray[1].contains("."))
		    	  {
		    		  flagforWithoutJoin=0;
		    	  }
		    	  else
		    	  {
		    		  //System.out.println("cross join");
		    		  flagCrossJoin=1;
		    	  }
		      }
		      
		      
		      
		      if(flagforWithoutJoin==0)
		      {
		    	  //System.out.println("join sql");
		    	  
		    	  
		    	  /*
		    	  
		    	  	block to do inner join on give tables
		    	  	select A,D from table1, table2 where table1.B=table2.B;
		    	  
		    	  */
		    	  //  System.out.println(m1.group(4));
		    	  
		    	  
		    	  	int requiredColumns=0;
	    	  		
	    	  		if(m1.group(4).contains("*"))
	    	  		{
	    	  			requiredColumns=0;
	    	  		}
	    	  		else
	    	  		{
	    	  			requiredColumns=1;
	    	  		}
			    	  
				    	  String twoTables[] = joinSplitArray[0].toString().split(",");		    	  
				    	  		    	  
				    	  
				    	  int positionofDot = joinSplitArray[1].toString().indexOf('.');
				    	  
				    	  char colname = joinSplitArray[1].toString().charAt(positionofDot+1);		    	  		    	
				    	  
				    	  Set<String> columnsofTable1 = alltables.get(twoTables[0].trim()).keySet();
				    	  
				    	  Set<String> columnsofTable2 = alltables.get(twoTables[1].trim()).keySet();
				    	  
				    	  Iterator < String > irt1 = columnsofTable1.iterator();
				    	  Iterator < String > irt2 = columnsofTable2.iterator();
							
				    	  ArrayList<ArrayList<String>> allcolumnsTable1 = new ArrayList<>();
				    	  ArrayList<ArrayList<String>> allcolumnsTable2 = new ArrayList<>();
				    	  
				    	  ArrayList<String> columnheader = new ArrayList<>();
				    	
				    	  ArrayList givenCondtion = new ArrayList<>();
			    	  
		    	  		int size1=0;
		    	  		int size2=0;
		    	  		
		    	  		ArrayList reqcolarray1 = new ArrayList<>();
		    	  		ArrayList reqcolarray2 = new ArrayList<>();
		    	  		
		    	  		
		    	  		
		    	  		
		    	  		if(requiredColumns==1)
		    	  		{
		    	  			
			    	  		int i=0;
			    	  		
			    	  		  String reqcol  = m1.group(4).substring(0, m1.group(4).length());
			   		    	  String reqcolarray[] = reqcol.split(",");
			   		    	  
			   		    	   i=0;							
			    	  		while(irt1.hasNext())	
							{			
			    	  			
			    	  			String temp =irt1.next();
			    	  			
			    	  			if(Arrays.asList(reqcolarray).contains(temp)||temp.equals(Character.toString(colname)))
			    	  			{
			    	  				
			    	  				columnheader.add(twoTables[0]+"."+temp);
			    	  				reqcolarray1.add(temp);
			    	  				//System.out.println(temp);
			    	  				if(alltables.get(twoTables[0].trim()).get(reqcolarray1.get(i))!=null)
				    	  			{
				    	  				allcolumnsTable1.add(alltables.get(twoTables[0].trim()).get(reqcolarray1.get(i)));
										size1 = allcolumnsTable1.get(0).size();																	
				    	  			}
			    	  			}			    	  						    	  						    	  						    	  			
			    	  			i++;
							}
			   		    	  
			    	  		i=0;
			    	  		
			    	  		while(irt2.hasNext())	
							{				
			    	  			String temp =irt2.next();
			    	  			
			    	  			if(Arrays.asList(reqcolarray).contains(temp)||temp.equals(Character.toString(colname)))
			    	  			{
			    	  				if(!columnheader.contains(twoTables[0]+"."+temp))
			    	  				{
			    	  					columnheader.add(twoTables[1].trim()+"."+temp);
			    	  				}
			    	  				
			    	  				reqcolarray2.add(temp);			    	  			
				    	  			if(alltables.get(twoTables[1].trim()).get(reqcolarray2.get(i))!=null)
				    	  			{	
				    	  				allcolumnsTable2.add(alltables.get(twoTables[1].trim()).get(reqcolarray2.get(i)));
				    	  				//size2 = allcolumnsTable2.get(0).size();	
				    	  				
				    	  			}
			    	  			}
			    	  			i++;
								
							}
			    	  		
		    	  		}
		    	  		else
		    	  		{

			    	  		int i=0;
							String temp;
			    	  		while(irt1.hasNext())	
							{		
			    	  			temp=irt1.next();
			    	  			columnheader.add(twoTables[0]+"."+temp);
			    	  			reqcolarray1.add(temp);
			    	  			
			    	  			
			    	  			allcolumnsTable1.add(alltables.get(twoTables[0].trim()).get(reqcolarray1.get(i)));
								size1 = allcolumnsTable1.get(0).size();							
								i++;
							}
			    	  
			    	  		i=0;
			    	  		
			    	  		while(irt2.hasNext())	
							{	
			    	  			temp=irt2.next();
			    	  			
			    	  			
			    	  			if(!columnheader.contains(twoTables[0]+"."+temp))
		    	  				{
		    	  					columnheader.add(twoTables[1].trim()+"."+temp);
		    	  				}
		    	  				
			    	  			
			    	  			
			    	  			reqcolarray2.add(temp);
			    	  			allcolumnsTable2.add(alltables.get(twoTables[1].trim()).get(reqcolarray2.get(i)));
								//size2 = allcolumnsTable2.get(0).size();	
								i++;
								
							}
		    	  		}
		    	  			
		    	  	System.out.println(columnheader);	
		    	  	//call for printColumnsFromTwoTable to inner join two tables
		    	  	printColumnsFromTwoTable(allcolumnsTable1, reqcolarray1, allcolumnsTable2, reqcolarray2, colname);//
		    	  		
		    	  
		      }	
		      else if(flagCrossJoin==1)
		      {
		    	  
		    	  //System.out.println("cross join implementation");
		    	  
		    	  
		    	  
		    	  if(m1.group(8).contains("where"))
		    	  {
		    		  
		    		 // System.out.println(m1.group(8));
		    		  
		    		 // System.out.println(m1.group(4));
		    		  
		    		 // System.out.println("cross join with condition");
		    		  
		    		  
		    		  joinSplitArray  = m1.group(8).toString().split("where");
			    	  
			    	  for(int i=0;i<joinSplitArray.length;i++)
			    	  {
			    		  //System.out.println(i+"  "+joinSplitArray[i]);
			    		  			    		  
			    	  }
			    	  
			    	  int type=0;
			    	  if(joinSplitArray[1].contains("OR"))
			    	  {
			    		  type=1;
			    	  }
		    		  
			    	  String twoTables[] = joinSplitArray[0].toString().split(",");
			    	  String inputCondition[];
			    	  if(type==1)
			    	  {			    		 
			    		   inputCondition = joinSplitArray[1].toString().split("OR");
			    	  }
			    	  else
			    	  {
			    		   inputCondition = joinSplitArray[1].toString().split("AND");
			    	  }
			    	  
			    	  
			    	  ArrayList<String> tableList = new ArrayList<>();
			    	  
			    	  
			    	  
			    	  HashMap<String, String> conditionMap = new HashMap<>();
		    		  
		    		  for(int i=0;i<twoTables.length;i++)
		    		  {
		    			  //System.out.println(twoTables[i]);
		    			  tableList.add(twoTables[i].trim());
		    		  }
		    		  
		    		  
		    		  for(int i=0;i<inputCondition.length;i++)
		    		  {
		    			 // System.out.println(inputCondition[i]);
		    			  
		    			  if(inputCondition.length-1==i)
		    			  {
		    				//  System.out.println(inputCondition[i].substring(0, inputCondition[i].length()-1).trim().split("=")[0]);
		    				  //conditonList.add(inputCondition[i].substring(0, inputCondition[i].length()-1));  
		    				  String temp[] = inputCondition[i].substring(0, inputCondition[i].length()-1).trim().split("=");
		    				  conditionMap.put(temp[0], temp[1]);
		    			  }
		    			  else
		    			  {
		    				  
		    				  String temp[] = inputCondition[i].trim().split("=");
		    				  conditionMap.put(temp[0], temp[1]);
		    				 /// System.out.println(inputCondition[i].trim().split("=")[0]);
		    				  //conditonList.add(inputCondition[i].trim().replace("=", " "));
		    			  }
		    		  }
		    		  
		    		 // System.out.println("conditionMap  "+conditionMap);
		    		  
		    		  
		    		  
		    		  //System.out.println(tableList);
		    		  
		    		 
		    		  
		    		  Set<String> columnsofTable1 = alltables.get(tableList.get(0)).keySet();
			    	  
			    	  Set<String> columnsofTable2 = alltables.get(tableList.get(1)).keySet();
			    	  
			    	  Iterator < String > irt1 = columnsofTable1.iterator();
			    	  Iterator < String > irt2 = columnsofTable2.iterator();
						
			    	  //ArrayList<ArrayList<String>> allcolumnsTable1 = new ArrayList<>();
			    	  //ArrayList<ArrayList<String>> allcolumnsTable2 = new ArrayList<>();
			    	  
			    	  HashMap<String,ArrayList<String>> mapforTable1 = new HashMap<>();
	   		    	  HashMap<String,ArrayList<String>> mapforTable2= new HashMap<>();
	   		    	  
	   		    	  ArrayList<String> columnHeader = new ArrayList<>();
	   		    	  
			    	
			    	  		
			    	  		int requiredColumns=0;
			    	  		
			    	  		if(m1.group(4).contains("*"))
			    	  		{
			    	  			requiredColumns=0;
			    	  		}
			    	  		else
			    	  		{
			    	  			requiredColumns=1;
			    	  		}
			    	  		
			    	  		ArrayList reqcolarray1 = new ArrayList<>();
			    	  		ArrayList reqcolarray2 = new ArrayList<>();
			    	  		
			    	  		if(requiredColumns==0)
			    	  		{
			    	  			
				    	  		int i=0;
				    	  		
				    	  		  String reqcol  = m2.group(4).substring(0, m2.group(4).length());
				   		    	  String reqcolarray[] = reqcol.split(",");
				   		    	  
				   		    	  //System.out.println("******"+reqcolarray.length);
				   		    	  String temp;
								
				    	  		while(irt1.hasNext())	
								{		
				    	  			temp =irt1.next();
				    	  			columnHeader.add(tableList.get(0)+"."+temp);
				    	  			reqcolarray1.add(temp);

				    	  			//allcolumnsTable1.add(alltables.get(tableList.get(0)).get(reqcolarray1.get(i)));
				    	  			
				    	  			mapforTable1.put(reqcolarray1.get(i).toString(), alltables.get(tableList.get(0)).get(reqcolarray1.get(i)));	
				    	  			
									//size1 = allcolumnsTable1.get(0).size();							
									i++;
								}
				    	  
				    	  		i=0;
				    	  		
				    	  		while(irt2.hasNext())	
								{		
				    	  			temp =irt2.next();
				    	  			columnHeader.add(tableList.get(1)+"."+temp);
				    	  			reqcolarray2.add(temp);
				    	  			
				    	  			mapforTable2.put(reqcolarray2.get(i).toString(), alltables.get(tableList.get(1)).get(reqcolarray2.get(i)));
				    	  			//allcolumnsTable2.add(alltables.get(tableList.get(1)).get(reqcolarray2.get(i)));
									//size2 = allcolumnsTable2.get(0).size();	
									i++;
									
								}
			    	  		}
			    	  		else
			    	  		{
			    	  		
			    	  		
			    	  			
					    	  		String reqcol  = m1.group(4).substring(0, m1.group(4).length());
					   		    	  
					   		    	  
					   		    	  
					   		    	  
					   		    	 // System.out.println(reqcol);
					   		    	  
					   		    	  String reqcolarray[] = reqcol.split(",");
					   		    	  
					   		    	//  System.out.println("******"+reqcolarray.length);
					   		    	  
					   		    	  
					   		    	  
					   		    	  
						   		    	  	int size=0;
						   		    	  	int i=0;	
						   		    	  	String temp;
						   		    	  	
						   	    	  		while(i<reqcolarray.length)	
						   					{			
						   	    	  			//sSystem.out.println(reqcolarray[i]);
						   	    	  			
						   	    	  			reqcolarray1.add(reqcolarray[i]);
						   	    	  			if(alltables.get(tableList.get(0)).get(reqcolarray[i].toString().trim())!=null)
						   	    	  			{
						   	    	  				columnHeader.add(tableList.get(0)+"."+reqcolarray[i].toString().trim());
						   	    	  				mapforTable1.put(reqcolarray[i].toString().trim(), alltables.get(tableList.get(0)).get(reqcolarray[i].toString().trim()));				   	    	  					
		//				   	    	  				System.out.println(alltables.get(tableList.get(0)).get(reqcolarray[i].toString().trim()));
						   	    	  			}
						   	    	  			
						   						
						   						
						   						//System.out.println(reqcolarray[i]);
						   						//System.out.println(alltables.get(tableList.get(0)).get(reqcolarray[i].toString().trim()));
						   						i++;
						   					}
					   	    	  		
							   	    	 	 size=0;
						   		    	  	 i=0;	
						   	    	  		while(i<reqcolarray.length)	
						   					{		
						   	    	  			
						   	    	  			reqcolarray2.add(reqcolarray[i]);
						   	    	  			if(alltables.get(tableList.get(1)).get(reqcolarray[i].toString().trim())!=null)
						   	    	  			{
						   	    	  				columnHeader.add(tableList.get(1)+"."+reqcolarray[i].toString().trim());
						   	    	  				mapforTable2.put(reqcolarray[i].toString().trim(), alltables.get(tableList.get(1)).get(reqcolarray[i].toString().trim()));	
						   	    	  				//System.out.println(alltables.get(tableList.get(1)).get(reqcolarray[i].toString().trim()));
						   	    	  			}
						   	    	  			
						   						//size = allcolumnsTable2.get(0).size();						
							   	    	  	
						   	    	  			//System.out.println(reqcolarray[i]);
						   						//System.out.println(alltables.get(tableList.get(1)).get(reqcolarray[i].toString().trim()));
						   						i++;
						   					}
				   	    	  		
			   	    	  		
			   	    	  		
			   	    	  		
			    	  		}
			    	  				
			    	  		
			    	  		System.out.println(columnHeader);
			    	  		
			    	  		//call crossJoinOfTable function  to make cross join of two tables  with or condition
			    	  		if(requiredColumns==0)
			    	  		{
			    	  			
			    	  			//System.out.println("* is in condition");
			    	  			if(type==1)
				    	  		{
				    	  			crossJoinOfTableWithGivenColumns(mapforTable1,reqcolarray1,mapforTable2,reqcolarray2,1,conditionMap,"OR",null);
				    	  		}
				    	  		else
				    	  		{
				    	  			crossJoinOfTableWithGivenColumns(mapforTable1,reqcolarray1,mapforTable2,reqcolarray2,1,conditionMap,"AND",null);
				    	  		}
			    	  		}
			    	  		else
			    	  		{
				    	  		if(type==1)
				    	  		{
				    	  			crossJoinOfTableWithGivenColumns(mapforTable1,reqcolarray1,mapforTable2,reqcolarray2,1,conditionMap,"OR",null);
				    	  		}
				    	  		else
				    	  		{
				    	  			crossJoinOfTableWithGivenColumns(mapforTable1,reqcolarray1,mapforTable2,reqcolarray2,1,conditionMap,"AND",null);
				    	  		}
			    	  		}

		    		  
		    		  
		    		  
		    	  }
		    	  else
		    	  {
		    		  String twoTables[] = m1.group(8).substring(0, m1.group(8).length()-1).toString().split(",");	
			    	  
			    	 // System.out.println(m1.group(8).substring(0, m1.group(8).length()-1));
			    	  
			    	  
			    	  Set<String> columnsofTable1 = alltables.get(twoTables[0].trim()).keySet();
			    	  
			    	  Set<String> columnsofTable2 = alltables.get(twoTables[1].trim()).keySet();
			    	  
			    	  Iterator < String > irt1 = columnsofTable1.iterator();
			    	  Iterator < String > irt2 = columnsofTable2.iterator();
						
			    	  ArrayList<ArrayList<String>> allcolumnsTable1 = new ArrayList<>();
			    	  ArrayList<ArrayList<String>> allcolumnsTable2 = new ArrayList<>();
			    	
			    	  ArrayList<String> columnHeader = new ArrayList<>();
			    	  
			    	  		int size1=0;
			    	  		int size2=0;
			    	  		
			    	  		ArrayList reqcolarray1 = new ArrayList<>();;
			    	  		ArrayList reqcolarray2 = new ArrayList<>();;
			    	  		int i=0;
			    	  		
			    	  		String temp;
							
			    	  		while(irt1.hasNext())	
							{		
			    	  			temp=irt1.next();
			    	  			
			    	  			columnHeader.add(twoTables[0].trim()+"."+temp);;
			    	  			reqcolarray1.add(temp);
			    	  			
			    	  			allcolumnsTable1.add(alltables.get(twoTables[0].trim()).get(reqcolarray1.get(i)));
								//size1 = allcolumnsTable1.get(0).size();							
								i++;
							}
			    	  
			    	  		i=0;
			    	  		
			    	  		while(irt2.hasNext())	
							{				
			    	  			temp=irt2.next();
			    	  			columnHeader.add(twoTables[1].trim()+"."+temp);
			    	  			reqcolarray2.add(temp);
			    	  			allcolumnsTable2.add(alltables.get(twoTables[1].trim()).get(reqcolarray2.get(i)));
								//size2 = allcolumnsTable2.get(0).size();	
								i++;
								
							}
			    	  
			    	  		//System.out.println("cross join with * and no condition");
			    	  		
			    	  		System.out.println(columnHeader);
			    	  		
			    	  		//call crossJoinOfTable function  to make cross join of two tables 
			    	  		crossJoinOfTable(allcolumnsTable1,reqcolarray1,allcolumnsTable2,reqcolarray2,0,null,null);
		    	  }
		    	  
		    	
		    	  
		      }
		      else if(m1.group(4).contains("*"))
		      {
		    	  
		    	  /*
		    	  	
		    	  	Select all records ​ : ​select * from table_name;
		    	  
		    	  */
		    	  
		    	  
		    	 // System.out.println(m1.group(8).substring(0, m1.group(8).length()-1));
		    	  
		    	  String tname = m1.group(8).substring(0, m1.group(8).length()-1);
		    	  
		    	  //System.out.println(alltables.get(tname).keySet());
		    	  
		    	  Set<String> columnsofTable = alltables.get(tname).keySet();
		    	  
		    	  Iterator < String > ir2 = columnsofTable.iterator();
					
		    	  ArrayList<ArrayList<String>> allcolumns = new ArrayList<>();
		    	  
		    	  
		    	  ArrayList<String> columnheader = new ArrayList<>();
		    	
		    	  String temp ;
		    	  
		    	  		int size=0;
						
		    	  		while(ir2.hasNext())	
						{	
		    	  			temp = ir2.next();		    	  			
		    	  			columnheader.add(tname+"."+temp);
							allcolumns.add(alltables.get(tname).get(temp));
							size = allcolumns.get(0).size();							
						}	
		    	  		
		    	  		
		    	  		System.out.println(columnheader);
		    	  				    	  				    	  				    	  		
		    	  		printColumn(allcolumns,size,allcolumns.size());						    	  
		      }
		      else if(m1.group(4).contains("distinct"))
		      {

		    	  /*
		    	  	
		    	  	Select/project with distinct from one table ​ : ​
		    	  	
		    	  	eg:select distinct col1, col2 from table_name;
		    	  
		    	  */
//			    	
//		    		System.out.println(m1.groupCount());
//			      
//			      for(int i=1;i<=m1.groupCount();i++)
//			      {
//			    	  System.out.println("Found value: " + m1.group(i) );
//			      }
//			      			      
		    	  String reqcol  = m1.group(4).substring(0, m1.group(4).length());
		    	  
		    	  
		    	  
		    	  String tname = m1.group(8).substring(0, m1.group(8).length()-1);
			      
			      
			      //System.out.println(tname);
			      
			     // System.out.println(reqcol.substring(9,reqcol.length()));

			      String reqcolarray[] = reqcol.substring(9,reqcol.length()).split(",");
			      
			      //System.out.println(reqcolarray.length);
			      
			      
			      ArrayList<ArrayList<String>> allcolumns = new ArrayList<>();
		    	  
		    	  
		    	  ArrayList<String> columnheader = new ArrayList<String>();
		    	  
		    	  	int i=0;	
	    	  		while(i<reqcolarray.length)	
					{				
						columnheader.add(reqcolarray[i]);															
						allcolumns.add(alltables.get(tname).get(reqcolarray[i]));
						i++;
					}
	    	  		
	    	  		System.out.println(columnheader);
	    	  		
	    	  		printParticularColumn(allcolumns,reqcolarray,"distinct");
			      
		      }		     
		      else
		      {
		    	  
		    	 // System.out.println("to display particular block ");		    	  
		    	  /*
		    	  	Block to display particualr colums from table
		    	  	
		    	  	eg:select D from table2;		    	  		    	  
		    	  */		    	  		    	 
		    	  //System.out.println(m1.group(4));
		    	  		    	  		    	  		    	  
		    	  String reqcol  = m1.group(4).substring(0, m1.group(4).length());
		    	  		    	 		    	  
		    	  String tname = m1.group(8).substring(0, m1.group(8).length()-1);
		    	  
		    	 // System.out.println(tname);		    	  
		    	 // System.out.println(reqcol);
		    	  
		    	  String reqcolarray[] = reqcol.split(",");
		    	  
		    	 // System.out.println(reqcolarray.length);
		    	  
		    	  ArrayList<ArrayList<String>> allcolumns = new ArrayList<>();
		    	  ArrayList<String> columnheader = new ArrayList<>();
		    	  		    	  		    	  
		    	  	int size=0;
		    	  	int i=0;	
	    	  		while(i<reqcolarray.length)	
					{		
	    	  			columnheader.add(tname+"."+reqcolarray[i]);
						allcolumns.add(alltables.get(tname).get(reqcolarray[i]));
						size = allcolumns.get(0).size();						
						i++;
					}	
	    	  		
	    	  		System.out.println(columnheader);
	    	  		printParticularColumn(allcolumns,reqcolarray,"nodistinct");
	    	  		//System.out.println(allcolumns);	    	  			    	  				    	  
		      }
		      
	    }
	    else if(m2.matches())
	    {	    		    	
			/*
			 * if block to find maximum value from particular column
			 * 
			 * eg:select max(D) from table2;
			 */
			
			String tname = m2.group(8).substring(0, m2.group(8).length() - 1);

			String function = null;
			String tcol = null;
			
			
			 System.out.println(m2.group(4));
			 
			 if(m2.group(4).contains("max"))
			 {
				 tcol = m2.group(4).substring(4, m2.group(4).length() - 1);
				 function="max";
			 }
			 else if(m2.group(4).contains("min"))
			 {
				  tcol = m2.group(4).substring(4, m2.group(4).length() - 1);
				 function="min";
			 }
			 else if(m2.group(4).contains("sum"))
			 {
				  tcol = m2.group(4).substring(4, m2.group(4).length() - 1);
				  function="sum";
			 }
			 else if(m2.group(4).contains("avg"))
			 {
				  tcol = m2.group(4).substring(4, m2.group(4).length() - 1);
				  function="avg";
			 }
			 
			 

			Set<String> columnsofTable = alltables.get(tname).keySet();

			Iterator<String> ir2 = columnsofTable.iterator();

			ArrayList<ArrayList<String>> allcolumns = new ArrayList<>();

			findMax(alltables.get(tname).get(tcol.trim()), function);
			// System.out.println(alltables.get(tableName).get(tcol));
	    	  
	    }
	    else
	     {
	    	  System.out.println("not matched");
	    	  
	    	  
	     }
		
		
		
				
		
	}



}
