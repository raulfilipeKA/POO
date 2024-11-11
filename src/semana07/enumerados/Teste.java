package semana07.enumerados;

public class Teste {

	public static void main(String[] args) {
		
		Weekday day = Weekday.SUNDAY;
		showMessages(day);
		
		System.out.println("========================");
				
		day = Weekday.WEDNESDAY;
		showMessages(day);
		
	}
	
	static void showMessages(Weekday day) {
		System.out.println("Current day is: " + day + " ("+ day.getDescPT() + ")");
		System.out.println("Is it weekend? " + day.isWeekend());
		System.out.println("Tomorrow is " +  day.next());
	}
}
