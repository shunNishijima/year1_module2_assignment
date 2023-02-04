package ss.tiktactoe.model;

/**
 * Represents a mark in the Tic Tac Toe game. There three possible values:
 * Mark.XX, Mark.OO and Mark.EMPTY.
 * Module 2 lab assignment
 */
public enum Mark {
    
    EMPTY, BLACK, OO;

    /**
     * Returns the other mark.
     * @return the other mark is this mark is not EMPTY or EMPTY
     */
    //@ ensures this == XX ==> \result == OO && this == OO ==> \result == XX;
    public Mark other() {
        if (this == BLACK) {
            return OO;
        } else if (this == OO) {
            return BLACK;
        } else {
            return EMPTY;
        }
    }
}
