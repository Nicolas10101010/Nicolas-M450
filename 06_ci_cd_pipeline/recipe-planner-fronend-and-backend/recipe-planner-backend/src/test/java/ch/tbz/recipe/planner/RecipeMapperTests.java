package ch.tbz.recipe.planner;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.assertj.core.api.SoftAssertions.assertSoftly;


class RecipeMapperTests {

    private RecipeEntityMapper mapper;

    private UUID recipeId;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(RecipeEntityMapper.class);
    }

    @Test
    void entityToDomain_mapsAllFields() {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeId = UUID.randomUUID();
        recipeEntity.setId(recipeId);
        recipeEntity.setName("Test Recipe");
        recipeEntity.setDescription("Test description");
        recipeEntity.setImageUrl("http://img/carbonara.jpg");

        Recipe entity = mapper.entityToDomain(recipeEntity);

        assertSoftly(softly -> {
            softly.assertThat(entity.getId()).isEqualTo(recipeId);
            softly.assertThat(entity.getName()).isEqualTo("Test Recipe");
            softly.assertThat(entity.getDescription()).isEqualTo("Test description");
            softly.assertThat(entity.getImageUrl()).isEqualTo("http://img/carbonara.jpg");
        });
    }

    @Test
    void domainToEntity_mapsAllFields() {
        Recipe domain = new Recipe();
        recipeId = UUID.randomUUID();
        domain.setId(recipeId);
        domain.setName("Test Recipe");
        domain.setDescription("Test description");
        domain.setImageUrl("http://img/carbonara.jpg");

        RecipeEntity recipeEntity = mapper.domainToEntity(domain);

        assertSoftly(softly -> {
            softly.assertThat(recipeEntity.getId()).isEqualTo(recipeId);
            softly.assertThat(recipeEntity.getName()).isEqualTo("Test Recipe");
            softly.assertThat(recipeEntity.getDescription()).isEqualTo("Test description");
            softly.assertThat(recipeEntity.getImageUrl()).isEqualTo("http://img/carbonara.jpg");
        });

    }
}
