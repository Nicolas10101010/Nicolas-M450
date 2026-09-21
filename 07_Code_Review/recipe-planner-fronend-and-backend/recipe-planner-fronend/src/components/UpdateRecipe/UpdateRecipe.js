import React, { useState } from "react";
import "./UpdateRecipe.css";
import { useForm } from "react-hook-form";
import { Form, Button, Col, Row } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";

import axios from "axios";
import AddIngredient from "../AddIngredient/AddIngredient";

function UpdateRecipe() {
  const { recipeId } = useParams();

  const [recipe, setRecipe] = useState([]);
  const [formData, setFormData] = useState({
    name: "",
    description: "",
    imageUrl: "",
    ingredients: [],
    id: null,
  });

  const [listId, setListId] = useState(1);

  const { handleSubmit } = useForm();

  const addIngredient = () => {
    setFormData({
      ...formData,
      ingredients: [
        ...formData.ingredients,
        {
          listId: listId,
          ingredient: "",
          unit: "PIECE",
          quantity: "",
        },
      ],
    });
    setListId(listId + 1);
  };

  const updateIngredient = (ingredientObj) => {
    const updatedIngredients = formData.ingredients.map((ingredient) => {
      if (ingredient.listId === ingredientObj.listId) {
        return ingredientObj;
      }
      return ingredient;
    });
    setFormData({ ...formData, ingredients: updatedIngredients });
  };

  const removeIngredient = (ingredientObj) => {
    const updatedIngredients = formData.ingredients.filter(
      (ingredient) => ingredient.listId !== ingredientObj.listId,
    );
    setFormData({ ...formData, ingredients: updatedIngredients });
  };

  const renderIngredients = formData.ingredients.map((ingredient) => (
    <AddIngredient
      key={ingredient.listId}
      ingredient={ingredient}
      recipe={recipe}
      listId={listId - 1}
      updateIngredient={updateIngredient}
      removeIngredient={removeIngredient}
    />
  ));

  const handleChange = (e) =>
    setFormData({ ...formData, [e.target.name]: e.target.value });

  const navigate = useNavigate();

  React.useEffect(() => {
    axios
      .get("http://localhost:8080/api/recipes/recipe/" + recipeId)
      .then((response) => {
        setFormData(response.data);
      });
  }, [recipeId]);

  return (
    <>
      <div className="bg">
        <div className="m-3">
          <h1 className="h3 bg-dark text-bg-primary mt-2">Update Recipe</h1>
          <Form.Group className="mb-1" controlId="formBasicName">
            <Form.Label>Recipe Name:</Form.Label>
            <Form.Control
              placeholder="Name"
              value={formData.name}
              onChange={handleChange}
              name="name"
            />
          </Form.Group>
          <Form.Group className="mb-1" controlId="formBasicDescription">
            <Form.Label>Description:</Form.Label>
            <Form.Control
              placeholder="Description"
              value={formData.description}
              onChange={handleChange}
              name="description"
            />
          </Form.Group>
          <Form.Group className="mb-1 mb-5" controlId="formBasicImageUrl">
            <Form.Label>Image URL:</Form.Label>
            <Form.Control
              placeholder="URL"
              value={formData.imageUrl}
              onChange={handleChange}
              name="imageUrl"
            />
          </Form.Group>
          <Row>
            <Col>Ingredient</Col>
            <Col>Unit</Col>
            <Col>Quanity</Col>
            <Col xs={1}></Col>
          </Row>
          <hr />
          <Row>
            <br></br>
          </Row>
          {renderIngredients}
          <Row>
            <br></br>
            <Button variant="warning" onClick={addIngredient} className="mt-1">
              Add Ingredient
            </Button>
          </Row>
          <Button
            variant="primary"
            type="submit"
            className="mb-5"
            onClick={handleSubmit((data) => {
              console.log(data);
              axios
                .put(
                  "http://localhost:8080/api/recipes/recipe/" + recipeId,
                  formData,
                )
                .then((response) => {
                  console.log(response.data);
                })
                .catch((error) => {
                  console.error(error);
                });
              navigate("/");
            })}
          >
            Submit
          </Button>
        </div>
      </div>
    </>
  );
}

export default UpdateRecipe;
