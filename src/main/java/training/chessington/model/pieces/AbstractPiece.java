package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected Integer moveCount;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
        moveCount = 0;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public Integer getMoveCount() {
        return moveCount;
    }

    @Override
    public void setMoveCount(Integer i) { moveCount = i; }

    public List<Move> CutOverlapMoves(List<Move> moves, Board board) {

        moves.removeIf(m -> board.get(m.getTo()) != null);

        return moves;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
