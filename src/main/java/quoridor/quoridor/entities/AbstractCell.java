package quoridor.quoridor.entities;

public abstract class AbstractCell {

	abstract boolean canHoldPawn();
	
	abstract boolean canHoldWall();
	
	abstract String getDrawSymbol();
	
}
