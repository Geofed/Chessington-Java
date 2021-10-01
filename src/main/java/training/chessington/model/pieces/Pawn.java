package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

    private List<Coordinates> attackVectors = new ArrayList<>();

    public Pawn(PlayerColour colour) {

        super(Piece.PieceType.PAWN, colour);

        attackVectors = new AttackBuilder().Pawn(attackVectors);

    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> possibleMoves = new ArrayList<>();

        possibleMoves.add(CreateMove(from, new Coordinates(colour.equals(PlayerColour.BLACK) ? 1 : -1, 0)));

        if (this.moveCount.equals(0) && board.get(from.plus(colour.equals(PlayerColour.BLACK) ? 1 : -1, 0)) == null)
            possibleMoves.add(CreateMove(from, new Coordinates(colour.equals(PlayerColour.BLACK) ? 2 : -2, 0)));

        possibleMoves = this.CutOutOfBoundsMoves(possibleMoves, board);
        possibleMoves = this.CutOverlapMoves(possibleMoves, board);
        possibleMoves = this.AddAttackMoves(possibleMoves, attackVectors, board, from);

        return possibleMoves;

    }
}
