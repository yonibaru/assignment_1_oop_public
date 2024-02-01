
import java.util.ArrayList;
public abstract class ConcretePiece implements Piece{

    protected ConcretePlayer owner;
    protected int id;

    private final ArrayList<Position> pathway = new ArrayList<>();

    public ArrayList<Position> getPathway() {
        return this.pathway;
    }

    public int getPathwayLength(){
        return this.pathway.size();
    }

    public void updatePathway(Position position){
        this.pathway.add(position);
    }

    public void updatePathway(int x, int y){
        Position position = new Position(x,y);
        this.pathway.add(position);
    }

    public int tilesTraversed() {
        int totalDistance = 0;
        for (int i = 1; i < this.pathway.size(); i++) {
            Position position1 = this.pathway.get(i - 1);
            Position position2 = this.pathway.get(i);
            totalDistance += Math.abs(position2.getX() - position1.getX()) + Math.abs(position2.getY() - position1.getY());
        }
        return totalDistance;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public ConcretePlayer getOwner() {
        return this.owner;
    }
    public abstract String getType();

}
