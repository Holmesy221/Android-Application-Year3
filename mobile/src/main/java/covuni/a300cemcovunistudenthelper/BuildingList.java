package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 29/10/2017.
 */

public class BuildingList {

    String name;
    int image;

    public static final BuildingList[] buildings = {
            new BuildingList("Alan Berry", R.drawable.alan_berry),
            new BuildingList("Alan Berry", R.drawable.alan_berry)

    };

    BuildingList(String name, int image){
    this.image = image;
    this.name = name;

    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }
}
