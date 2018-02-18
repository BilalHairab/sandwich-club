package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject parentObject = new JSONObject(json);
        JSONObject sandwichObject = parentObject.getJSONObject(SandwichJsonContract.NAME_JSON_KEY);
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(sandwichObject.getString(SandwichJsonContract.MAIN_NAME_JSON_KEY));
        List<String> knownAsList = new ArrayList<>();
        JSONArray knownAsJsonArray = sandwichObject.getJSONArray(SandwichJsonContract.ALSO_KNOWN_JSON_KEY);
        for (int i = 0; i < knownAsJsonArray.length(); i++)
            knownAsList.add(knownAsJsonArray.getString(i));
        sandwich.setAlsoKnownAs(knownAsList);
        sandwich.setPlaceOfOrigin(parentObject.getString(SandwichJsonContract.PLACE_OF_ORIGIN_JSON_KEY));
        sandwich.setDescription(parentObject.getString(SandwichJsonContract.DESCRIPTION_JSON_KEY));
        sandwich.setImage(parentObject.getString(SandwichJsonContract.IMAGE_JSON_KEY));
        List<String> ingredientsList = new ArrayList<>();
        JSONArray ingredientsJsonArray = parentObject.getJSONArray(SandwichJsonContract.INGREDIENTS_JSON_KEY);
        for (int i = 0; i < ingredientsJsonArray.length(); i++)
            ingredientsList.add(ingredientsJsonArray.getString(i));
        sandwich.setIngredients(ingredientsList);
        return sandwich;
    }
}
