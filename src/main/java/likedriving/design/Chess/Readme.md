

Algorithm to implement checkmate -
 Get the Kings position
 Check each of the opponents pieces - can they move to this position in a single step (including opponents king)
 if it is true for any of the pieces then -
    check what all positions the king can move to
        check if moving to all of these possible king's positions, the king would still be under attack from the opponent
            if no - move the king to this safe position
            if yes - that means there are no positions left where king can move to safely on its own.
        check by moving any of my pieces, can I protect the king
            if yes - move that piece
            if no - declare checkmate



A simple algorithm to decide which move to play
    * Define significance order for each piece
    * Check if opponent can kill any of your piece in his next move.
    * Move to save your piece in the order of significance specified
    * Kill opponents piece to in order of significance and check if your move is not exposing any of your more significant piece to your opponent
    * Make a random move


