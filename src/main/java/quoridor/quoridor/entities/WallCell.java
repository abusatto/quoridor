package quoridor.quoridor.entities;

public class WallCell extends AbstractCell {

	@Override
	boolean canHoldPawn() {
		return false;
	}

	@Override
	boolean canHoldWall() {
		return true;
	}

	@Override
	String getDrawSymbol() {
		return "|";
	}
	
}
