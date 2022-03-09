package quoridor.quoridor.entities;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

	private static final int DEFAULT_ROWS = 7;

	private static final int DEFAULT_COLUMNS = 7;

	private Map<Coordinates, AbstractCell> boardRepresentation;

	public GameBoard() {
		this.boardRepresentation = buildBoardRepresentation(DEFAULT_ROWS, DEFAULT_COLUMNS);
	}

	private Map<Coordinates, AbstractCell> buildBoardRepresentation(int rows, int columns) {
		Map<Coordinates, AbstractCell> boardRepresentation = new HashMap<>();
		
		int totalRowNumber = rows * 2 + 1;
		int totalColumnNumber = columns * 2 + 1;

		for (int i = 0; i < totalRowNumber; i++) {
			for (int j = 0; j < totalColumnNumber; j++) {
				Coordinates coordinates = new Coordinates(i, j);
				AbstractCell cell = buildCell(i, j, totalRowNumber, totalColumnNumber);
				boardRepresentation.put(coordinates, cell);
			}
		}

		return boardRepresentation;
	}

	private AbstractCell buildCell(int row, int column, int totalRowNumber, int totalColumnNumber) {
		AbstractCell cell = null;

		if (row == 0 || column == 0 || row == totalRowNumber - 1 || column == totalColumnNumber - 1) {
			cell = new BorderCell();
		} else if (row % 2 != 0 && column % 2 != 0) {
			cell = new PawnCell();
		} else {
			cell = new WallCell();
		}

		return cell;
	}

	@Override
	public String toString() {

		Integer minRowIndex = this.boardRepresentation.keySet().stream().map(Coordinates::getRow).min(Integer::compareTo)
				.get();
		Integer maxRowIndex = this.boardRepresentation.keySet().stream().map(Coordinates::getRow).max(Integer::compareTo)
				.get();
		Integer minColumnIndex = this.boardRepresentation.keySet().stream().map(Coordinates::getColumn)
				.min(Integer::compareTo).get();
		Integer maxColumnIndex = this.boardRepresentation.keySet().stream().map(Coordinates::getColumn)
				.max(Integer::compareTo).get();

		String result = "";

		result += "ROWS=" + (maxRowIndex - minRowIndex) + "\n COLUMNS=" + (maxColumnIndex - minColumnIndex) + "\n";

		for (int i = minRowIndex; i <= maxRowIndex; i++) {
			for (int j = minColumnIndex; j <= maxColumnIndex; j++) {
				result += this.boardRepresentation.get(new Coordinates(i, j)).getDrawSymbol();
				result += " ";
			}
			result += "\n";
		}

		return result;
	}

}
