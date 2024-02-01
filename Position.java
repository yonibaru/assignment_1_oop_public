import java.util.HashSet;
import java.util.Set;

public class Position {
    private final int x;
    private final int y;
    Set<ConcretePiece> previousPieces = new HashSet<>();  //I've decided to use Sets since they fit they handle unique items in the desired functionality.


    public Set<ConcretePiece> getPreviousPieces() {
        return previousPieces;
    }

    public void addPreviousPiece(ConcretePiece piece){
        if(piece != null){
            this.previousPieces.add(piece);
        }
    }

    public int getPreviousPiecesAmount(){
        if(previousPieces != null){
            return this.previousPieces.size();
        } else{
            return 0;
        }
    }


    //constructor
    public Position(int x,int y) {
        if (isValidCoordinate(x) && isValidCoordinate(y)){
            this.x = x;
            this.y = y;
        } else{
            throw new IllegalArgumentException("Invalid coordinates given to position object.");
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    private boolean isValidCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate <= 11;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
