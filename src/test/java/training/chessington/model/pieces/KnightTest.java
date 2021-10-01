package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void whiteKnightCanMoveLShape() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 1);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
    }

    @Test
    public void blackKnightCanMoveLShape() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 1);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
    }

    @Test
    public void whiteKnightCanTakePiece() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);
        board.placePiece(coords.plus(-2, 1), enemyPiece);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));

    }

    @Test
    public void BlackKnightCanTakePiece() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Piece enemyPiece = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 1);
        board.placePiece(coords, knight);
        board.placePiece(coords.plus(-2, 1), enemyPiece);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));

    }
}
