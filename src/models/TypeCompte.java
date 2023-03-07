package models;

public enum TypeCompte {
	
	PEL(3), LIVRET_A(1), LIVRET_JEUNESSE(2);
	private int x;
	
	TypeCompte(int x){
		this.x = x;
	}
	
	public static TypeCompte fromInteger(int x) {
		return switch(x) {
			case 1 -> LIVRET_A;
			case 2 -> LIVRET_JEUNESSE;
			case 3 -> PEL;
			default -> null;
		};
	}
	
	public int getValue() {
		return this.x;
	}
}
