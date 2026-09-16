package ch.tbz.recipe.planner;
import ch.tbz.recipe.planner.controller.RecipeController;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.mapper.*;
import ch.tbz.recipe.planner.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @MockBean
    private RecipeEntityMapper entityMapper;

    private Recipe recipe;
    private UUID recipeId;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
        recipeId = UUID.randomUUID();
        recipe.setId(recipeId);
    }

    @Test
    void getsRecipes() throws Exception {
        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk());
    }

    @Test
    void getsRecipeById() throws Exception {
        service.addRecipe(recipe);
        mockMvc.perform(get("/api/recipes/recipe/" + recipeId))
                .andExpect(status().isOk());
    }

    @Test
    void addRecipe() throws Exception {
        mockMvc.perform(post("/api/recipes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipe))).andExpect(status().isOk());
    }
}
