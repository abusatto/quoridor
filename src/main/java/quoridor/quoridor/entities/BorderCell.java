package quoridor.quoridor.entities;

public class BorderCell extends AbstractCell {

	@Override
	boolean canHoldPawn() {
		return false;
	}

	@Override
	boolean canHoldWall() {
		return false;
	}

	@Override
	String getDrawSymbol() {
		return "X";
	}

}
