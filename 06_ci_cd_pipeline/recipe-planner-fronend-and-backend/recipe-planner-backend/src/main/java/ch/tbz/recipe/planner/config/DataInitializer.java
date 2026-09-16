package ch.tbz.recipe.planner.config;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final static String DESCRIPTION = "Lorem ipsum dolor sit amet, ...";
    private final static List<String> IMAGES = List.of(/* deine URLs */);

    private final RecipeRepository recipeRepository;
    private final RecipeEntityMapper mapper;

    @Override
    public void run(String... args) {
        Random rand = new Random();
        Stream.of("Lasagne al Forno", "Spaghetti Bolognese", "Fried Rice", "Pommes Frites")
                .forEach(name -> {
                    Recipe recipe = new Recipe(UUID.randomUUID(), name, DESCRIPTION,
                            IMAGES.get(rand.nextInt(IMAGES.size())),
                            List.of(new Ingredient(UUID.randomUUID(), "Tomato", "The big ones", Unit.PIECE, 5)));
                    recipeRepository.save(mapper.domainToEntity(recipe));
                });
        recipeRepository.findAll().forEach(s -> log.info(s.toString()));
    }
}