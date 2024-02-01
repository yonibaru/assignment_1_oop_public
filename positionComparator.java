import java.util.Comparator;

public class positionComparator implements Comparator<Position> {

    @Override
    public int compare(Position pos1, Position pos2) {
        if(pos1.getPreviousPiecesAmount() == pos2.getPreviousPiecesAmount()){
            if(pos1.getX() == pos2.getX()){
                return Integer.compare(pos2.getY(),pos1.getY());
            } else {
                return Integer.compare(pos2.getX(),pos1.getX());
            }
        }
        return Integer.compare(pos1.getPreviousPiecesAmount(), pos2.getPreviousPiecesAmount());
    }
}
