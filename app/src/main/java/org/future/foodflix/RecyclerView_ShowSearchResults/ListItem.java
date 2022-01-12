package org.future.foodflix.RecyclerView_ShowSearchResults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ListItem implements Serializable {
    private String Title;
    private float calories;
    private ArrayList<String> ingredients;
    private String imageURL;

}
