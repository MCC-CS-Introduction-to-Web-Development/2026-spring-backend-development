package edu.mcc.codeschool.class22.services;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class22.models.Move;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoveService {
    private final GameService gameService;

    public MoveService(GameService gameService) {
        this.gameService = gameService;
    }

    public Game makeMove(Move request){
        Optional<Game> foundGame = gameService.getGameById(request.getGameId().toString());
        if(foundGame.isPresent()){
            Game game = foundGame.get();
            if(game.getWinner() != null){
                throw new RuntimeException("Game has winner");
            }

            String[][] currentBoard = game.getBoard();
            // location comes in as "1,2"
            currentBoard[Integer.parseInt(request.getLocation().split(",")[0])][Integer.parseInt(request.getLocation().split(",")[1])] = request.getPlayer();
            game.setBoard(currentBoard);

            String winner = checkWinner(currentBoard);

            if(winner.equalsIgnoreCase("Player X wins!")){
                game.setPlayerXWins(game.getPlayerXWins()+1);
                game.setWinner("X");
                game.setStatus("Complete");
            } else if(winner.equalsIgnoreCase("Player O wins!")){
                game.setPlayerOWins(game.getPlayerOWins()+1);
                game.setWinner("O");
                game.setStatus("Complete");
            } else if(winner.equalsIgnoreCase("It's a tie!")){
                game.setTies(game.getTies()+1);
                game.setWinner("TIE");
                game.setStatus("Complete");
            }
            gameService.updateGame(game);
            return game;
        }
        return null;
    }

    private String checkWinner(String[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                return "Player " + board[i][0] + " wins!";
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" ")) {
                return "Player " + board[0][i] + " wins!";
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            return "Player " + board[0][0] + " wins!";
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            return "Player " + board[0][2] + " wins!";
        }

        // Check if the game is finished or still ongoing
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    full = false;
                    break;
                }
            }
            if (!full) {
                break;
            }
        }
        if (full) {
            return "It's a tie!";
        }

        // No winner yet
        return "No winner yet";
    }
}
