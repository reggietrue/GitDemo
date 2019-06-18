import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		exceltest data=new exceltest();
		ArrayList  dd=data.getData("dd");
		
		System.out.println("This is the size array--> "+dd.size());
		int  sizeofarray=dd.size();
		
		for (int  i=0; i<sizeofarray; i++ )
		{
			System.out.println(dd.get(i));
		}
//System.out.println(dd.get(0));
	}

}



