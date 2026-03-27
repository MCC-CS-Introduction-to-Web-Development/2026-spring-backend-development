package edu.mcc.codeschool.class22.controllers;

import edu.mcc.codeschool.class22.services.GameService;
import edu.mcc.codeschool.class22.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@DisplayName("Game Controller Test")
public class GameControllerTest {
    @InjectMocks
    private GameController subject;

    @Mock
    private GameService gameService;

    private MockMvc mockMvc;
    private HttpHeaders httpHeaders;
    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ReflectionTestUtils.setField(this, "httpHeaders", httpHeaders);
        ReflectionTestUtils.setField(this, "mapper", new ObjectMapper());
    }

    @Test
    @DisplayName("Create Game - Success")
    public void createGame() throws Exception {

        when(gameService.createGame()).thenReturn(new Game());

        Game input = new Game();
        input.setId(UUID.randomUUID());
        input.setTies(5);

        MockHttpServletResponse resp = mockMvc
                                      .perform(post("/api/v1/games")
                                              .headers(httpHeaders)
                                              .content(mapper.writeValueAsString(input))
                                      )
                                      .andReturn()
                                      .getResponse();

        assertThat(resp).isNotNull();
        assertThat(resp.getStatus()).isEqualTo(HttpStatus.OK.value());

        Game game = mapper.readValue(resp.getContentAsString(), Game.class);
        assertThat(game).isNotNull();
        assertThat(game.getId()).isNotNull();
        assertThat(game.getStatus()).isEqualTo("In-Progress");
        assertThat(game.getTies()).isEqualTo(0);
    }

    @Test
    @DisplayName("Get Game by ID - Success")
    public void getGameById() throws Exception {
        UUID testId = UUID.randomUUID();
        Game input = new Game();
        input.setId(testId);
        when(gameService.getGameById(testId.toString())).thenReturn(Optional.of(input));

        MockHttpServletResponse resp = mockMvc
                .perform(get("/api/v1/games/{id}", testId.toString())
                        .headers(httpHeaders)
                )
                .andReturn()
                .getResponse();

        assertThat(resp).isNotNull();
        assertThat(resp.getStatus()).isEqualTo(HttpStatus.OK.value());

        Game game = mapper.readValue(resp.getContentAsString(), Game.class);
        assertThat(game).isNotNull();
        assertThat(game.getId()).isNotNull();
        assertThat(game.getId()).isEqualTo(testId);
        assertThat(game.getStatus()).isEqualTo("In-Progress");
        assertThat(game.getTies()).isEqualTo(0);
    }

    @Test
    @DisplayName("Get Game by ID - Not Found")
    public void getGameByIdNotFound() throws Exception {
        UUID testId = UUID.randomUUID();

        MockHttpServletResponse resp = mockMvc
                .perform(get("/api/v1/games/{id}", testId.toString())
                        .headers(httpHeaders)
                )
                .andReturn()
                .getResponse();

        assertThat(resp).isNotNull();
        assertThat(resp.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}
