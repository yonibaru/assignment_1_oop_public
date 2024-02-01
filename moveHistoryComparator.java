import java.util.Comparator;

public class moveHistoryComparator implements Comparator<ConcretePiece> {


    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
            return Integer.compare(piece1.getPathwayLength(), piece2.getPathwayLength());
    }
}
