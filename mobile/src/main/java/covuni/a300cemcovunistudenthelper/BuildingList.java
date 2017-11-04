package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 29/10/2017.
 */

public class BuildingList {

    String name;
    int image;
    String body;


    public static final BuildingList[] buildings = {
            new BuildingList("Alan Berry", R.drawable.alan_berry, "test"),
            new BuildingList("Alma ", R.drawable.alma_building,"test"),
            new BuildingList("Armstrong Siddeley", R.drawable.armstrong_siddeley,"test"),
            new BuildingList("Charles Ward", R.drawable.bugatti,"test"),
            new BuildingList("Engineering and Computing", R.drawable.ec_building,"test"),
            new BuildingList("Ellen Terry", R.drawable.ellen_terry,"test"),
            new BuildingList("Frederick Lancaster Library", R.drawable.lanchester_library,"test"),
            new BuildingList("George Eliot", R.drawable.george_eliot,"test"),
            new BuildingList("Graham Sutherland", R.drawable.graham_sutherland,"test"),
            new BuildingList("The Hub", R.drawable.the_hub,"test"),
            new BuildingList("Jaguar", R.drawable.jaguar_building,"test"),
            new BuildingList("James Starley", R.drawable.james_starley,"test"),
            new BuildingList("Maurice Foss", R.drawable.maurice_foss,"test"),
            new BuildingList("Multi Story CarPark", R.drawable.multi,"test"),
            new BuildingList("Priory Building", R.drawable.priory_building,"test"),
            new BuildingList("Richard Crossman", R.drawable.richard_crossman,"test"),
            new BuildingList("Sir John Laing", R.drawable.sir_john_laing,"test"),
            new BuildingList("Sir William Lyons", R.drawable.sir_william_lyons,"test"),
            new BuildingList("Sports Center", R.drawable.sport_centre,"test"),
            new BuildingList("Student Center", R.drawable.student_centre,"test")



    };

    BuildingList(String name, int image, String body){
    this.image = image;
    this.name = name;
    this.body = body;

    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }

    public String getBody(){
        return body;
    }
}
