import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GameLogic implements PlayableLogic {


    public static ConcretePiece[][] board; //represents the board
    public static Position[][] previousPieces;
    public static ConcretePiece[] attackerPieces;
    public static ConcretePiece[] defenderPieces;

    private ConcretePlayer player1; //the defender
    private ConcretePlayer player2; //the attacker
    public boolean attackerTurn; //starts as true because attacker goes first
    public boolean attackerWin;
    public boolean gameFinished;



    //Additional game logic functions
    public void nextTurn(){
        this.attackerTurn = !attackerTurn;
    }
    public void resetBoard(){

        ConcretePiece[][] newBoard = new ConcretePiece[11][11];
        Position[][] newPreviousPieces = new Position[11][11];

        ConcretePiece[] newAttackerPieces = new ConcretePiece[24];
        ConcretePiece[] newDefenderPieces = new ConcretePiece[13];

        //initializing attacker pawns
        Pawn a_pawn_1 = new Pawn(this.player2,1,3,0);
        Pawn a_pawn_2 = new Pawn(this.player2,2,4,0);
        Pawn a_pawn_3 = new Pawn(this.player2,3,5,0);
        Pawn a_pawn_4 = new Pawn(this.player2,4,6,0);
        Pawn a_pawn_5 = new Pawn(this.player2,5,7,0);
        Pawn a_pawn_6 = new Pawn(this.player2,6,5,1);

        Pawn a_pawn_7 = new Pawn(this.player2,7,0,3);
        Pawn a_pawn_8 = new Pawn(this.player2,8,10,3);
        Pawn a_pawn_9 = new Pawn(this.player2,9,0,4);
        Pawn a_pawn_10 = new Pawn(this.player2,10,10,4);
        Pawn a_pawn_11 = new Pawn(this.player2,11,0,5);
        Pawn a_pawn_12 = new Pawn(this.player2,12,1,5);

        Pawn a_pawn_13 = new Pawn(this.player2,13,9,5);
        Pawn a_pawn_14 = new Pawn(this.player2,14,10,5);
        Pawn a_pawn_15 = new Pawn(this.player2,15,0,6);
        Pawn a_pawn_16 = new Pawn(this.player2,16,10,6);
        Pawn a_pawn_17 = new Pawn(this.player2,17,0,7);
        Pawn a_pawn_18 = new Pawn(this.player2,18,10,7);

        Pawn a_pawn_19 = new Pawn(this.player2,19,5,9);
        Pawn a_pawn_20 = new Pawn(this.player2,20,3,10);
        Pawn a_pawn_21 = new Pawn(this.player2,21,4,10);
        Pawn a_pawn_22 = new Pawn(this.player2,22,5,10);
        Pawn a_pawn_23 = new Pawn(this.player2,23,6,10);
        Pawn a_pawn_24 = new Pawn(this.player2,24,7,10);

        //initializing defender pawns and a king
        Pawn d_pawn_1 = new Pawn(this.player1,1,5,3);

        Pawn d_pawn_2 = new Pawn(this.player1,2,4,4);
        Pawn d_pawn_3 = new Pawn(this.player1,3,5,4);
        Pawn d_pawn_4 = new Pawn(this.player1,4,6,4);

        Pawn d_pawn_5 = new Pawn(this.player1,5,3,5);
        Pawn d_pawn_6 = new Pawn(this.player1,6,4,5);
        King d_king_7 = new King(this.player1,5,5);
        Pawn d_pawn_8 = new Pawn(this.player1,8,6,5);
        Pawn d_pawn_9 = new Pawn(this.player1,9,7,5);

        Pawn d_pawn_10 = new Pawn(this.player1,10,4,6);
        Pawn d_pawn_11 = new Pawn(this.player1,11,5,6);
        Pawn d_pawn_12 = new Pawn(this.player1,12,6,6);

        Pawn d_pawn_13 = new Pawn(this.player1,13,5,7);

        //setting the attacker pawns of the top corner
        newBoard[3][0] = a_pawn_1;
        newBoard[4][0] = a_pawn_2;
        newBoard[5][0] = a_pawn_3;
        newBoard[6][0] = a_pawn_4;
        newBoard[7][0] = a_pawn_5;
        newBoard[5][1] = a_pawn_6;

        //setting the attacker pawns of the left corner
        newBoard[0][3] = a_pawn_7;
        newBoard[0][4] = a_pawn_9;
        newBoard[0][5] = a_pawn_11;
        newBoard[0][6] = a_pawn_15;
        newBoard[0][7] = a_pawn_17;
        newBoard[1][5] = a_pawn_12;

        //setting the attacker pawns of the right corner
        newBoard[3][10] = a_pawn_8;
        newBoard[4][10] = a_pawn_21;
        newBoard[5][10] = a_pawn_22;
        newBoard[6][10] = a_pawn_23;
        newBoard[7][10] = a_pawn_18;
        newBoard[5][9] = a_pawn_19;

        //setting the attacker pawns of the bottom corner
        newBoard[10][3] = a_pawn_20;
        newBoard[10][4] = a_pawn_10;
        newBoard[10][5] = a_pawn_14;
        newBoard[10][6] = a_pawn_16;
        newBoard[10][7] = a_pawn_24;
        newBoard[9][5] = a_pawn_13;

        //setting the defender pawns and king
        newBoard[3][5] = d_pawn_1;
        newBoard[4][4] = d_pawn_2;
        newBoard[4][5] = d_pawn_3;
        newBoard[4][6] = d_pawn_10;
        newBoard[5][3] = d_pawn_5;
        newBoard[5][4] = d_pawn_6;
        newBoard[5][5] = d_king_7;
        newBoard[5][6] = d_pawn_11;
        newBoard[5][7] = d_pawn_13;
        newBoard[6][4] = d_pawn_4;
        newBoard[6][5] = d_pawn_8;
        newBoard[6][6] = d_pawn_12;
        newBoard[7][5] = d_pawn_9;

        board = newBoard; //overwrite the previous board with the new board.


        //Adding the initial pieces to our position history.
        for(int i = 0; i < 11; i++){
            for(int j = 0; j <11; j++){
                newPreviousPieces[i][j] = new Position(i,j);
                if(board[i][j] != null){

                    newPreviousPieces[i][j].addPreviousPiece(board[i][j]);

                    if (board[i][j].getOwner().isPlayerOne()) {
                        newDefenderPieces[board[i][j].getId() - 1] = board[i][j];
                    } else {
                        newAttackerPieces[board[i][j].getId() - 1] = board[i][j];
                    }
                }
            }
        }

        attackerPieces = newAttackerPieces;
        defenderPieces = newDefenderPieces;
        previousPieces = newPreviousPieces; //overwrite the previous position history with the new one.
    }
    public boolean isOutOfBounds(int piece_x, int piece_y){
        return piece_x < 0 || piece_x >= 11 || piece_y < 0 || piece_y >= 11;
    }
    public boolean isCornerTile(int piece_x, int piece_y){
        if(piece_x == 0 && piece_y == 0){
            return true;
        } else if(piece_x == 10 && piece_y == 0){
            return true;
        } else if(piece_x == 0 && piece_y == 10){
            return true;
        }else if(piece_x == 10 && piece_y == 10){
            return true;
        } else{
            return false;
        }
    }
    public boolean isPathBlocked(int source_x,int source_y,int dest_x,int dest_y){
        if(dest_x > source_x){
            for(int i = source_x + 1 ;i <= dest_x;i++){
                if(board[i][source_y] != null){
                    return true;
                }
            }
        } else if(dest_x < source_x){
            for(int i = dest_x;i < source_x;i++){
                if(board[i][source_y] != null){
                    return true;
                }
            }
        } else if(dest_y > source_y ){
            for(int i = source_y + 1;i <= dest_y;i++){
                if(board[source_x][i] != null){
                    return true;
                }
            }
        } else {
            for(int i = dest_y;i < source_y;i++){
                if(board[source_x][i] != null){
                    return true;
                }
            }
        }
        return false;
    }
    public void attemptCapturePiece(boolean horizontal,int aggressor_x, int aggressor_y,int piece_x,int piece_y){
        // aggressorPiece - piece that initiated the capture attempt.
        // endangeredPiece - the piece attempted to be captured.
        // adjPiece - adjacent piece is exactly next to the endangeredPiece from the other side.

        if(isOutOfBounds(piece_x,piece_y)) {return;} // endangeredPiece is out of bounds.

        ConcretePiece adjPiece = null; //This could be a corner or a wall, we assume it's an empty tile at this current point.
        ConcretePiece aggressorPiece = board[aggressor_x][aggressor_y];
        ConcretePiece endangeredPiece = board[piece_x][piece_y];

        if(endangeredPiece instanceof King){
            checkAttackerVictory(piece_x,piece_y);
            return;
        }
        if(endangeredPiece == null || aggressorPiece instanceof King){return;}
        if(aggressorPiece.getOwner() == endangeredPiece.getOwner()){ return;} //You can't attempt to capture yourself.

        Position adjPos;
        //Determining adjPiece
        if(horizontal){ //Horizontal
            if(piece_x + 1 >= 11 || piece_x - 1 < 0  ){ //Horizontal walls.
                board[piece_x][piece_y] = null; //Successful capture.
                ((Pawn) board[aggressor_x][aggressor_y]).increaseKills(); //Increase the kills of the aggressor.
                return;

            } else if(piece_x + 1 == aggressor_x){
                adjPiece = board[piece_x-1][piece_y];
                adjPos = new Position(piece_x-1,piece_y);
            } else{
                adjPiece = board[piece_x+1][piece_y];
                adjPos = new Position(piece_x+1,piece_y);
            }

        }else{ //Vertical
            if(piece_y + 1 >= 11 || piece_y - 1 < 0){ //Vertical walls.
                board[piece_x][piece_y] = null; //Successful capture.
                ((Pawn) board[aggressor_x][aggressor_y]).increaseKills(); //Increase the kills of the aggressor.
                return;
            } else if(piece_y + 1 == aggressor_y){
                adjPiece = board[piece_x][piece_y-1];
                adjPos = new Position(piece_x,piece_y-1);
            }else{
                adjPiece = board[piece_x][piece_y+1];
                adjPos = new Position(piece_x,piece_y+1);
            }
        }
        if(isCornerTile(adjPos.getX(),adjPos.getY())){ //if adjPiece is a corner, it's a valid capture.
            board[piece_x][piece_y] = null;
            ((Pawn) board[aggressor_x][aggressor_y]).increaseKills(); //Increase the kills of the aggressor.
            return;
        }
        if(adjPiece == null){return;} //If adjPiece is an empty tile, nothing to capture.
        if(adjPiece.getOwner() == aggressorPiece.getOwner()){
            board[piece_x][piece_y] = null; //Successful capture.
            ((Pawn) board[aggressor_x][aggressor_y]).increaseKills(); //Increase the kills of the aggressor.
            return;
        }

    }
    public void checkSurroundingPieces(int source_x,int source_y,int dest_x,int dest_y){
        if(dest_x > source_x){
            //Path going right
            attemptCapturePiece(true,dest_x,dest_y,dest_x + 1,dest_y);
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y - 1);
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y + 1);
        } else if(dest_x < source_x){
            //Path going left
            attemptCapturePiece(true,dest_x,dest_y,dest_x - 1,dest_y);
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y + 1);
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y - 1);
        } else if(dest_y > source_y){
            //Path going down
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y + 1);
            attemptCapturePiece(true,dest_x,dest_y,dest_x - 1,dest_y);
            attemptCapturePiece(true,dest_x,dest_y,dest_x + 1,dest_y);
        } else {
            //Path going up
            attemptCapturePiece(false,dest_x,dest_y,dest_x,dest_y - 1);
            attemptCapturePiece(true,dest_x,dest_y,dest_x - 1,dest_y);
            attemptCapturePiece(true,dest_x,dest_y,dest_x + 1,dest_y);
        }
    }
    public void checkAttackerVictory(int king_x, int king_y){

        int captureScore = 0;

        if(!isOutOfBounds(king_x + 1, king_y)){
            ConcretePiece rightPiece = board[king_x + 1][king_y];
            if(rightPiece instanceof Pawn && !rightPiece.getOwner().isPlayerOne()){
                captureScore++;
            }
        } else{
            captureScore++;
        }
        if(!isOutOfBounds(king_x - 1, king_y)){
            ConcretePiece leftPiece = board[king_x - 1][king_y];
            if(leftPiece instanceof Pawn && !leftPiece.getOwner().isPlayerOne()){
                captureScore++;
            }
        } else{
            captureScore++;
        }
        if(!isOutOfBounds(king_x, king_y + 1)){
            ConcretePiece bottomPiece = board[king_x][king_y + 1];
            if(bottomPiece instanceof Pawn && !bottomPiece.getOwner().isPlayerOne()){
                captureScore++;
            }
        } else{
            captureScore++;
        }
        if(!isOutOfBounds(king_x, king_y - 1)){
            ConcretePiece upperPiece = board[king_x][king_y - 1];
            if(upperPiece instanceof Pawn && !upperPiece.getOwner().isPlayerOne()){
                captureScore++;
            }
        } else{
            captureScore++;
        }
        if(captureScore >= 4){
            player2.increaseWins();
            gameFinished = true;
            attackerWin = true;
            reset();
        }
    }
    public void declareDefenderVictory(){
        player1.increaseWins();
        gameFinished = true;
        attackerWin = false;
        reset();
    }
    public void handleStatistics(){
    //FIRST PART: PRINT THE WINNING TEAMS PIECE'S PATHWAYS BY ASCENDING ORDER, AND THEN THE LOSING TEAM BY ASCENDING ORDER.
        Comparator<ConcretePiece> moveHistoryComp = new moveHistoryComparator();
        Arrays.sort(attackerPieces, moveHistoryComp);
        Arrays.sort(defenderPieces, moveHistoryComp);

        for (ConcretePiece piece : (attackerWin ? attackerPieces : defenderPieces)) {
            if (piece != null) {
                if(piece.getPathwayLength() >= 2){
                    System.out.println((piece.getOwner().isPlayerOne() ? (piece instanceof King ? "K" : "D") : "A") + piece.getId() + ": " + piece.getPathway());
                }
            }
        }
        for (ConcretePiece piece : (attackerWin ? defenderPieces : attackerPieces)) {
            if (piece != null) {
                if(piece.getPathwayLength() >= 2){
                    System.out.println((piece.getOwner().isPlayerOne() ? (piece instanceof King ? "K" : "D") : "A") + piece.getId() + ": " + piece.getPathway());
                }
            }
        }

        for (int i = 0; i < 75; i++){
            System.out.print("*");
        }
        System.out.println();
        //SECOND PART:

        Comparator<ConcretePiece> killComp = new killComparator(attackerWin);
        ConcretePiece[] allPieces = new ConcretePiece[attackerPieces.length + defenderPieces.length];
        System.arraycopy(attackerPieces, 0, allPieces, 0, attackerPieces.length);
        System.arraycopy(defenderPieces, 0, allPieces, attackerPieces.length, defenderPieces.length);

        Arrays.sort(allPieces,killComp);
        for(ConcretePiece piece: allPieces){
            if(piece instanceof Pawn){
                if(((Pawn) piece).getKills() == 0) {continue;}
                System.out.println((piece.getOwner().isPlayerOne() ? "D" : "A") + piece.getId() + ": " + ((Pawn) piece).getKills() + " kills");
            }
        }

        for (int i = 0; i < 75; i++){
            System.out.print("*");
        }
        System.out.println();

        //PART 3:

        Comparator<ConcretePiece> distanceComp = new distanceComparator(attackerWin).reversed();
        Arrays.sort(allPieces,distanceComp);

        for(ConcretePiece piece: allPieces){
                if(piece.tilesTraversed() < 1) {continue;}
                System.out.println((piece.getOwner().isPlayerOne() ? (piece instanceof King ? "K" : "D") : "A") + piece.getId() + ": " + (piece.tilesTraversed()) + " squares");
        }

        for (int i = 0; i < 75; i++){
            System.out.print("*");
        }
        System.out.println();

        Comparator<Position> posComp = new positionComparator().reversed();
        ArrayList<Position> posArray = new ArrayList<>();
        for(int i = 0;i < 11; i++ ){
            for(int j = 0;j < 11;j++){
                posArray.add(previousPieces[i][j]);
            }
        }
        posArray.sort(posComp);

        for(Position position: posArray){
            if(position.getPreviousPiecesAmount() >= 2){
                System.out.println(position + "" + (position.getPreviousPiecesAmount()) + " pieces");
            }
        }

        for (int i = 0; i < 75; i++){
            System.out.print("*");
        }
        System.out.println();

    }


    // The code inside is run when the game is first initialized.
    public GameLogic(){
        this.player2 = new ConcretePlayer(true);
        this.player1 = new ConcretePlayer(false);
        gameFinished = false;
        attackerTurn = true;
        resetBoard();
    }

    @Override
    public boolean move(Position a, Position b) {

        int source_x = a.getX(), source_y = a.getY();
        int dest_x = b.getX(), dest_y = b.getY();

        if(board[source_x][source_y] == null){return false;} //Case: No piece exists on the chosen tile.

        boolean checkNotCurrentTurn = board[source_x][source_y].getOwner().isPlayerOne() == attackerTurn;
        if(checkNotCurrentTurn) {return false;} //Case: Attempting to move a piece in an invalid turn.

        boolean checkSamePosition = source_x == dest_x && source_y == dest_y;
        if(checkSamePosition){return false;}  // Case: Piece attempting to move into the same position.

        boolean checkDiagonalPath = source_x != dest_x && source_y != dest_y;
        if(checkDiagonalPath){return false;} //Case: Piece attempting to move diagonally.

        boolean checkBlockedPath = isPathBlocked(source_x,source_y,dest_x,dest_y);
        if(checkBlockedPath){return false;} //Case: Piece's way is blocked by some other Piece (including the destination square!)

        boolean isPawn = board[source_x][source_y] instanceof Pawn;

        if(isPawn){
            boolean checkIllegalTile = isCornerTile(dest_x,dest_y);
            if(checkIllegalTile){return false;} //Case: Pawn attempts to step on a corner tile.
        }

        //If we reached this part, we allow movement. After that, we determine if anyone achieved victory with this move.

        board[source_x][source_y].updatePathway(b);

        board[dest_x][dest_y] = board[source_x][source_y];
        board[source_x][source_y] = null;

        previousPieces[dest_x][dest_y].addPreviousPiece(board[dest_x][dest_y]); // position history

        if(board[dest_x][dest_y] instanceof King && isCornerTile(dest_x,dest_y)) {
            defenderPieces[board[dest_x][dest_y].getId() - 1]= board[dest_x][dest_y];
            declareDefenderVictory();
            return true;
        }

        checkSurroundingPieces(source_x,source_y,dest_x,dest_y);

        if(gameFinished){
            return true;
        }

        if(board[dest_x][dest_y] != null) {
            if(board[dest_x][dest_y].getOwner().isPlayerOne()){
                defenderPieces[board[dest_x][dest_y].getId() - 1]= board[dest_x][dest_y];
            } else{
                attackerPieces[board[dest_x][dest_y].getId() - 1]= board[dest_x][dest_y];
            }
        }

        nextTurn();
        return true;
    }


    @Override
    public Piece getPieceAtPosition(Position position) throws IllegalArgumentException{
        if(position == null) {
        throw new IllegalArgumentException("getPieceAtPosition was given a null position as an argument.");}
        return board[position.getX()][position.getY()];
    }

    @Override
    public Player getFirstPlayer() {
        //get the defender
        return this.player1;
    }

    @Override
    public Player getSecondPlayer() {
        //get the attacker
        return this.player2;
    }

    @Override
    public boolean isGameFinished() {
        return this.gameFinished;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return attackerTurn;
    }

    @Override
    public void reset() {
        handleStatistics();
        attackerTurn = true;
        gameFinished = false;
        resetBoard();
    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
