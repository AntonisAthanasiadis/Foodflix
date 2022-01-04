package org.future.foodflix.Network;

public class JsonFoodResponse {
    private String foodId;
    private String label;
    private JsonNutrientsResponse nutrients;
    private String category;
    private String categoryLabel;
    private String image;
    private double servingsPerContainer;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public JsonNutrientsResponse getNutrients() {
        return nutrients;
    }

    public void setNutrients(JsonNutrientsResponse nutrients) {
        this.nutrients = nutrients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "JsonFoodResponse{" +
                "foodId='" + foodId + '\'' +
                ", label='" + label + '\'' +
                ", nutrients=" + nutrients +
                ", category='" + category + '\'' +
                ", categoryLabel='" + categoryLabel + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
