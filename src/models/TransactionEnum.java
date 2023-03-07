package models;

public enum TransactionEnum {
	DEPOT("DEPOT"), 
	RETRAIT("RETRAIT");
	
	private String type;
	
	TransactionEnum(String type){
		this.type = type;
	}
	
	public String getTypeTransaction() {
		return this.type;
	}
}
