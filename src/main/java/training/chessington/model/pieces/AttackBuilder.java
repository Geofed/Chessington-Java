package training.chessington.model.pieces;

import training.chessington.model.Coordinates;

import java.util.List;

public class AttackBuilder {

    public List<Coordinates> Knight(List<Coordinates> attackVectors)  {

        attackVectors.add(new Coordinates(2, 1));
        attackVectors.add(new Coordinates(2, -1));
        attackVectors.add(new Coordinates(-2, 1));
        attackVectors.add(new Coordinates(-2, -1));
        attackVectors.add(new Coordinates(1, 2));
        attackVectors.add(new Coordinates(1, -2));
        attackVectors.add(new Coordinates(-1, 2));
        attackVectors.add(new Coordinates(-1, -2));

        return attackVectors;

    }

    public List<Coordinates> Pawn(List<Coordinates> attackVectors) {

        attackVectors.add(new Coordinates(1, 1));
        attackVectors.add(new Coordinates(1, -1));
        attackVectors.add(new Coordinates(-1, -1));
        attackVectors.add(new Coordinates(-1, 1));

        return attackVectors;

    }

}
