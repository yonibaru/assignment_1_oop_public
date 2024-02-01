import java.util.Comparator;

public class distanceComparator implements Comparator<ConcretePiece>{

    private final boolean attackerWin;

    public distanceComparator(boolean attackerWin){
        this.attackerWin = attackerWin;
    }

    @Override
    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        int piece1Distance = piece1.tilesTraversed();
        int piece2Distance = piece2.tilesTraversed();
        if(piece2Distance == piece1Distance){
            if(piece1.getId() < piece2.getId()){
                return 1;
            } else if(piece1.getId() > piece2.getId() ){
                return -1;
            } else{
                return attackerWin == !piece1.getOwner().isPlayerOne() ? 1 : -1;
            }
        }
        return Integer.compare(piece1Distance,piece2Distance);
    }
}
