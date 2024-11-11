package semana07.enumerados;

public enum Weekday {

	MONDAY("2F"), TUESDAY("3F"), WEDNESDAY("4F"), 
	THURSDAY("5F"), FRIDAY("6F"), SATURDAY("SAB"), SUNDAY("DOM");
	
	private String descPT;
	
	private Weekday(String descPT) {
		this.descPT = descPT;
	}
	
	public String getDescPT() {
		return descPT;
	}
	
	public boolean isWeekend() {
		
		if ( this.equals(SUNDAY) || this.equals(SATURDAY))
			return true;
		
		return false;
		
	}
	
	public Weekday next() {	
		return values()[(ordinal() + 1) % 7];
		
//      Alternativa:
//		
//		if (this.equals(SUNDAY))
//			return MONDAY;
//		
//		Weekday[] allWeekdays = values();
//		return allWeekdays[ordinal()+1];	
	}	
}
