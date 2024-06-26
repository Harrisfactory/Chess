//
// Created by Harris Schrick on 5/9/24.
//

#include <iostream>


class Piece {
public:
    //virtual void movePiece() = 0;
    virtual std::string getPieceName() = 0;
};

class Pawn : public Piece {
private:
    //todo: implement attributes
    std::string pieceColor;
    std::string pieceType = "P";
    std::string pieceName;
public:


    //todo: implement constructor
    Pawn(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }
    //todo: implement check legal move

    //todo: implement move piece

    //todo: implement capture piece, might be uneccesary

    std::string getPieceName() {
        return this->pieceName;
    }
};

class Rook : public Piece {
private:
    std::string pieceColor;
    std::string pieceType = "R";
    std::string pieceName;

public:
    Rook(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }

    std::string getPieceName() {
        return this->pieceName;
    }

};

class Bishop : public Piece {
private:
    std::string pieceColor;
    std::string pieceType = "B";
    std::string pieceName;

public:
    Bishop(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }

    std::string getPieceName() {
        return this->pieceName;
    }

};

class Knight : public Piece {
private:
    std::string pieceColor;
    std::string pieceType = "K";
    std::string pieceName;

public:
    Knight(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }

    std::string getPieceName() {
        return this->pieceName;
    }

};

class Queen : public Piece {
private:
    std::string pieceColor;
    std::string pieceType = "Q";
    std::string pieceName;

public:
    Queen(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }

    std::string getPieceName() {
        return this->pieceName;
    }

};

class King : public Piece {
private:
    std::string pieceColor;
    std::string pieceType = "K";
    std::string pieceName;

public:
    King(std::string pieceColor) {
        this->pieceColor = pieceColor;
        this->pieceName = this->pieceColor + this->pieceType;
    }

    std::string getPieceName() {
        return this->pieceName;
    }

};

class Board {
private:
    Piece* board[8][8];
    std::string currentTurn = "white";

public:
    Board() {
        //init Board with nullptrs
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = nullptr;
            }
        }
    }

    void placePiece(int y, int x, Piece* piece) {
        board[y][x] = piece;
    }

    void displayBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++ ) {
                if (board[y][x] != nullptr) {
                    std::cout << "|" << board[y][x]->getPieceName() << "|";
                } else {
                    std::cout << "|__|";
                }
            }
            std::cout << std::endl;
        }
    }

    void changeTurn() {
        if (this->currentTurn == "white") {
            this->currentTurn = "black";
            return;
        }
        this->currentTurn = "white";
        return;
    }

    std::string getTurn() {
        return this->currentTurn;
    }

    //attempts to move a piece from one position of board to another
    void movePiece(int from_x, int from_y, int to_x, int to_y) {
        //todo: check piece legality
            //identify piece

            //piece operations map based on piece current location and type
            //find legal options based on map -><- current board

            //if legal move execute, if not legal just end the game for now
        //move piece
        board[to_y][to_x] = board[from_x][from_y];
        //disapear where piece moved
        board[from_x][from_y] = nullptr;
    }
};

int main(int argc, char* argv[]) {
    //create board
    Board chessBoard;
    //create white pawns
    chessBoard.placePiece(1, 0, new Pawn("W"));
    chessBoard.placePiece(1, 1, new Pawn("W"));
    chessBoard.placePiece(1, 2, new Pawn("W"));
    chessBoard.placePiece(1, 3, new Pawn("W"));
    chessBoard.placePiece(1, 4, new Pawn("W"));
    chessBoard.placePiece(1, 5, new Pawn("W"));
    chessBoard.placePiece(1, 6, new Pawn("W"));
    chessBoard.placePiece(1, 7, new Pawn("W"));
    //create white rooks
    chessBoard.placePiece(0, 0, new Rook("W"));
    chessBoard.placePiece(0, 7, new Rook("W"));
    //create white knights
    chessBoard.placePiece(0, 1, new Knight("W"));
    chessBoard.placePiece(0, 6, new Knight("W"));
    //create white bishops
    chessBoard.placePiece(0, 2, new Bishop("W"));
    chessBoard.placePiece(0, 5, new Bishop("W"));
    //create white queen
    chessBoard.placePiece(0, 4, new Queen("W"));
    //create white king
    chessBoard.placePiece(0, 3, new King("W"));

    //create black pawns
    chessBoard.placePiece(6, 0, new Pawn("B"));
    chessBoard.placePiece(6, 1, new Pawn("B"));
    chessBoard.placePiece(6, 2, new Pawn("B"));
    chessBoard.placePiece(6, 3, new Pawn("B"));
    chessBoard.placePiece(6, 4, new Pawn("B"));
    chessBoard.placePiece(6, 5, new Pawn("B"));
    chessBoard.placePiece(6, 6, new Pawn("B"));
    chessBoard.placePiece(6, 7, new Pawn("B"));
    //create black rooks
    chessBoard.placePiece(7, 0, new Rook("B"));
    chessBoard.placePiece(7, 7, new Rook("B"));
    //create black knights
    chessBoard.placePiece(7, 1, new Knight("B"));
    chessBoard.placePiece(7, 6, new Knight("B"));
    //create white bishops
    chessBoard.placePiece(7, 2, new Bishop("B"));
    chessBoard.placePiece(7, 5, new Bishop("B"));
    //create white queen
    chessBoard.placePiece(7, 4, new Queen("B"));
    //create white king
    chessBoard.placePiece(7, 3, new King("B"));

    chessBoard.displayBoard();

     
    //init gameloop
    bool live_game = true;
    int tst_ctr = 0;
    while (live_game) {
        //std::cout << chessBoard.getTurn();
        int from_x;
        int from_y;
        int to_x;
        int to_y;
        std::cout << "move from x: ";
        std::cin >> from_x;
        std::cout << "move from y: ";
        std::cin >> from_y;
        std::cout << "move to x: ";
        std::cin >> to_x;
        std::cout << "move to y: ";
        std::cin >> to_y;
        //std::cout << "-" << from_x << from_y << to_x << to_y; //remove this line after debug
        //attempt to place the piece
        chessBoard.movePiece(from_x, from_y, to_x, to_y);
        //display board
        chessBoard.displayBoard();
        //chessBoard.changeTurn();


        live_game = false;
    }
}
