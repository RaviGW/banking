package guruBanking01;

import java.io.IOException;

public class countExcelData 
{
		public static void main(String[] args) throws IOException
		{
			String path = System.getProperty("user.dir")+"/src/test/java/com/EBanking/TestData/Student_Detail.xlsx";
			int rownum=XLUtils.getRowCount(path,"login_details"); 
			int cellnum=XLUtils.getCellCount(path,"login_details",2);
			System.out.println(rownum);
			System.out.println(cellnum);
		}
}


