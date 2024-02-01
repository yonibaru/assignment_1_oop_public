public class Pawn extends ConcretePiece{
    //Pawn has access to all of ConcretePiece's methods.

    private int enemyKills;

    public Pawn(ConcretePlayer player,int id,int x,int y){
        this.owner = player;
        this.enemyKills = 0;
        super.id = id;
        super.updatePathway(x,y);
    }

    public int getKills(){
        return this.enemyKills;
    }

    public void increaseKills(){
        this.enemyKills++;
    }

    @Override
    public String getType() {
        //this is used for rendering the proper icon.
        return this.owner.isPlayerOne() ? "♙" : "♟";
    }
}
