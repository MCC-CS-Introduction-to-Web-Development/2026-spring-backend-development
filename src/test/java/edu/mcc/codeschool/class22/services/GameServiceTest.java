package edu.mcc.codeschool.class22.services;

import edu.mcc.codeschool.class22.models.Game;
import edu.mcc.codeschool.class22.models.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Game Service Test")
public class GameServiceTest {
    @InjectMocks
    private GameService subject;
    private final String[][] default_board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    @Test
    @DisplayName("Test Create Game")
    public void testCreateGame() {
        Game game = subject.createGame();

        assertThat(game.getId()).isNotNull();
        assertThat(game.getStatus()).isEqualTo("In-Progress");
        assertThat(game.getBoard()).isEqualTo(default_board);
    }

    @Test
    @DisplayName("Make Moves")
    void testMakeMoves(){
        // given
        String[][] move1 = {{"X", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] move2 = {{"X", "X", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String[][] move3 = {{"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "}};
        Game game = subject.createGame();
        game.setBoard(move1);

        Game response = subject.updateGame(game);
        assertThat(response.getWinner()).isNull();
        assertThat(response.getBoard()).isNotEqualTo(default_board);
        assertThat(response.getBoard()).isEqualTo(move1);

        response.setBoard(move2);
        response = subject.updateGame(response);
        assertThat(response.getWinner()).isNull();
        assertThat(response.getBoard()).isNotEqualTo(default_board);
        assertThat(response.getBoard()).isEqualTo(move2);

        response.setBoard(move3);
        response.setWinner("X");
        response.setPlayerXWins(1);
        response = subject.updateGame(response);

        assertThat(response.getWinner()).isNotNull();
        assertThat(response.getWinner()).isEqualTo("X");
        assertThat(response.getBoard()).isNotEqualTo(default_board);
        assertThat(response.getBoard()).isEqualTo(move3);
        assertThat(response.getPlayerXWins()).isEqualTo(1);

    }

    @Test
    @DisplayName("Delete Game - Game Not Found")
    public void testDeleteGameNotFound() {
        boolean deletedGame = subject.deleteGame("123");
        assertThat(deletedGame).isFalse();
    }

    @Test
    @DisplayName("Delete Game - Game Found")
    public void testDeleteGameFound() {
        Game game = subject.createGame();
        assertThat(subject.listGames().size()).isEqualTo(1);

        boolean deletedGame = subject.deleteGame(game.getId().toString());

        assertThat(deletedGame).isTrue();
        assertThat(subject.listGames()).isEmpty();
    }
}
