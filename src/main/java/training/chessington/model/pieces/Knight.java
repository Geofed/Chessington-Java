package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {

    private List<Coordinates> attackVectors = new ArrayList<>();

    public Knight(PlayerColour colour) {

        super(PieceType.KNIGHT, colour);

        attackVectors = new AttackBuilder().Knight(attackVectors);

    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        for (Coordinates c : attackVectors) {
            allowedMoves.add(CreateMove(from, c));
        }

        allowedMoves = this.CutOutOfBoundsMoves(allowedMoves, board);
        allowedMoves = this.CutOverlapMoves(allowedMoves, board);
        allowedMoves = this.AddAttackMoves(allowedMoves, attackVectors, board, from);

        return allowedMoves;

    }
}
