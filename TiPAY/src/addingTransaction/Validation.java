package addingTransaction;
import java.util.Arrays;

public class Validation {
	public Validation() {
		super.getClass();
	}
	
	public boolean regValidation(String fname, String mname, String lname, String day, String month, String year, String gender, String address, String email, String mobile, String password) {
		
		if (fname!=""&&mname!=""&&lname!=""&&checkCal(day, month, year)&&gender!=""&&address!=""&&mobile!=""&&password!="")
			return true;		
		return false;
	}
	
	public boolean checkCal(String day, String month, String year) {
		
		int[] mon = {1, 3, 5, 7, 8, 10, 12};
		int d = Integer.parseInt(day);
		int m = Integer.parseInt(month);
		int y = Integer.parseInt(year);
		if ((m>=1 && m<=12) && (d>=1&&d<=31) && year.length()==4) {
		if(Arrays.binarySearch(mon, m)>=0)
			return true;
		else if (m==2 && (d>=1&&d<=29) && ((y%4 == 0)&&(y%400 == 0)))
				return true;
		else if (m==2 && (d>=1&&d<=28))
			return true;
		}
		return false;
	}

}
