public class King extends ConcretePiece{
    //King has access to all of ConcretePiece's methods.

    public King(ConcretePlayer player,int x,int y) {
        //Checks if the argument player is indeed a defender, otherwise he should not be able to create a king.
        if(player.isPlayerOne()){
            this.owner = player;
            super.id = 7;
            super.updatePathway(x,y);
        }else{
            throw new IllegalArgumentException("Attempted to create a king for an attacker / incorrect player arugment.");
        }
    }
    @Override
    public String getType() {
        return "♔";
    }
}
