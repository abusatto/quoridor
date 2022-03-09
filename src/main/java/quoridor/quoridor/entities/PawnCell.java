package quoridor.quoridor.entities;

public class PawnCell extends AbstractCell {

	@Override
	boolean canHoldPawn() {
		return true;
	}

	@Override
	boolean canHoldWall() {
		return false;
	}

	@Override
	String getDrawSymbol() {
		return "O";
	}
	
}
