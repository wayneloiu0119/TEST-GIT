package tset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testReader {

	public static void main(String[] args) {
		 try {
			   InputStreamReader isr = new InputStreamReader(new FileInputStream("D://T14-03-1-2_20200714_上傳檔案測試資料.csv"));//檔案讀取路徑
			   BufferedReader reader = new BufferedReader(isr);
			   BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter("D://file_output.csv"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}//檔案輸出路徑
			   String line = null;
			   List<Map> allpput = new ArrayList();
			   try {
				   //讀取一整列的資料
				   int lineNumber = 0; 
				while((line=reader.readLine()+1)!=null){
					if(lineNumber == 0 ) {
						 lineNumber++; 
				          continue; 
					 }
					//利用資料間的逗點區分，放入陣列
					Map ggbbc = new HashMap();
				      String item[] = line.split(",");
				      System.out.println(line);
				      System.out.println(line.toString());
				      if(item[0].trim().equals("2020/6/24")){
				    	  String[] gg = new String[13];
				    	  String  data1= item[0].trim();
					      String  data2= item[1].trim();
					      String  data3= item[2].trim();
					      System.out.println(gg.length); 
					      ggbbc.put("data1",data1);	
					      ggbbc.put("data2",data2);	
					      ggbbc.put("data3",data3);	
					      
					      for(int i=0;i<item.length-3;i++){
					    	 
					    	  gg[i] = item[i+3].trim();	  
					      }
					      ggbbc.put("data4",gg); 	  
				      }
				      
				      allpput.add(ggbbc);
				      
//				      /** 讀取 **/
//				      String  data1= item[0].trim();
//				      String  data2= item[1].trim();
//				      String  data3= item[2].trim();
//				      System.out.print(data1+"\t"+ data2+"\t"+ data3+"\n"); 

				      //可自行變化成存入陣列或arrayList方便之後存取
		}
				
				//
				Object v0 = allpput.get(0).get("data4");
				String[] v1 = (String[]) allpput.get(1).get("data4");
				Object v2 = allpput.get(2).get("data4");
				Object v3 = allpput.get(3).get("data4");
				//String gggg = v0[1];
				//Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判斷小數點后2位的數字的正則表達式
				String cccc = v1[0];
				System.out.println(cccc);
				Pattern pattern = Pattern.compile("^[0-9](.[0-9]{8})?$");
				//Pattern pattern = Pattern.compile("\\d{1}.\\d{8}");
				
				Matcher matcher = pattern.matcher(cccc);
				
				System.out.println(matcher.matches());
				
				while (matcher.find()) {

		            System.out.println("matcher.group():\t"+matcher.group());

		       
				
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }

	}



}
