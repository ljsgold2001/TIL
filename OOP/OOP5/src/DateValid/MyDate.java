package DateValid;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private boolean isValid = true;
	
	public MyDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
		
	}
	//////GET///////////////////////////////////////////////////
	public int getYear() {
		return year;
		
	}
	
	public int getMonth() {
		return month;
		
	}
	
	public int getDay() {
		return day;
		
	}
	///////SET///////////////////////////////////////////////

	
	public void setYear(int year) {
		this.year = year;
		
	}
	
	
	public void setMonth(int month) {
		if (month <1 || month >12) {
			isValid = false;
		}
		else {
			this.month = month;
		}
		
	}
	
	public void setDay(int day) {
		if(month ==1 && month ==3 && month ==5 && month ==8 && month ==10 && month ==12) {
			if (day <0 || day>31) {
				isValid = false;
			}
			else {
				this.day = day;
			}
		}
		
		else if(month ==4 && month ==6 && month ==9 && month ==11){
			if (day<0 || day>29) {
				isValid = false;
				
			}
			else {
				this.day = day;
				
			}
			
			
		}
		else {
			if (( ( year % 4 ==0 &&  year % 100 !=0 ) || year % 400 ==0)){  //윤년인 경우
				if (day <0 || day >29) {
					isValid = false;
				} 
				else {
					this.day = day;
				}
			}
			else {
				if (day <0 || day >28) {
					isValid = false;
				} 
				else {
					this.day = day;
				}
			}
			
		}
		
	}
	/////valid////////////////////////////////////////////////
	public String isValid() {
		if(isValid) {
			return "유효한 날짜입니다.";
		}
		else {
			return "유효하지 않은 날짜입니다.";
		}
	}

}
