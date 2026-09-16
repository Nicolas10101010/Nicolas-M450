package ch.tbz.recipe.planner;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.mapper.IngredientEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import java.util.UUID;

class IngredientMapperTests
{
    private IngredientEntityMapper ingredientEntityMapper;

    private UUID ingredientId;

    @BeforeEach
    void init(){
        ingredientEntityMapper = Mappers.getMapper(IngredientEntityMapper.class);
    }

    @Test
    void mapIngredientEntityToIngredientDto(){
        Ingredient ingredient = new Ingredient();
        ingredientId = UUID.randomUUID();

        ingredient.setId(ingredientId);
        ingredient.setName("Milk");
        ingredient.setComment("Cow Milk");
        ingredient.setUnit(Unit.LITRE);
        ingredient.setAmount(1);

        IngredientEntity domain = ingredientEntityMapper.domainToEntity(ingredient);

        assertSoftly(softly -> {
            softly.assertThat(domain.getId()).isEqualTo(ingredientId);
            softly.assertThat(domain.getName()).isEqualTo("Milk");
            softly.assertThat(domain.getComment()).isEqualTo("Cow Milk");
            softly.assertThat(domain.getUnit()).isEqualTo(Unit.LITRE);
            softly.assertThat(domain.getAmount()).isEqualTo(1);
        });
    }

    @Test
    void mapIngredientDtoToIngredientEntity(){
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientId = UUID.randomUUID();
        ingredientEntity.setId(ingredientId);
        ingredientEntity.setName("Water");
        ingredientEntity.setComment("Normal Water");
        ingredientEntity.setUnit(Unit.LITRE);
        ingredientEntity.setAmount(2);

        Ingredient entity = ingredientEntityMapper.entityToDomain(ingredientEntity);

        assertSoftly(softly -> {
            softly.assertThat(entity.getId()).isEqualTo(ingredientId);
            softly.assertThat(entity.getName()).isEqualTo("Water");
            softly.assertThat(entity.getComment()).isEqualTo("Normal Water");
            softly.assertThat(entity.getUnit()).isEqualTo(Unit.LITRE);
            softly.assertThat(entity.getAmount()).isEqualTo(2);
        });
    }
}
