import java.util.Comparator;

public class killComparator implements Comparator<ConcretePiece> {
    private final boolean attackerWin;

    public killComparator(boolean attackerWin) {
        this.attackerWin = attackerWin;
    }

    public int compare(ConcretePiece piece1, ConcretePiece piece2) {
        if(piece1 instanceof King || piece2 instanceof King){
            return 0;
        }
        int piece1Kills = ((Pawn) piece1).getKills();
        int piece2Kills = ((Pawn) piece2).getKills();

        if(piece1Kills == piece2Kills && piece1.getOwner().isPlayerOne() != piece2.getOwner().isPlayerOne()){
            return attackerWin == !piece1.getOwner().isPlayerOne() ? -1 : 1;
        }
        return Integer.compare(piece1Kills, piece2Kills);
    }


}
