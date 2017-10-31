package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 29/10/2017.
 */

public class BuildingList {

    String name;
    int image;

    public static final BuildingList[] buildings = {
            new BuildingList("Alan Berry", R.drawable.alan_berry),
            new BuildingList("Alma ", R.drawable.alma_building),
            new BuildingList("Armstrong Siddeley", R.drawable.armstrong_siddeley),
            new BuildingList("Charles Ward", R.drawable.bugatti),
            new BuildingList("Engineering and Computing", R.drawable.ec_building),
            new BuildingList("Ellen Terry", R.drawable.ellen_terry),
            new BuildingList("Frederick Lancaster Library", R.drawable.lanchester_library),
            new BuildingList("George Eliot", R.drawable.george_eliot),
            new BuildingList("Graham Sutherland", R.drawable.graham_sutherland),
            new BuildingList("The Hub", R.drawable.the_hub),
            new BuildingList("Jaguar", R.drawable.jaguar_building),
            new BuildingList("James Starley", R.drawable.james_starley),
            new BuildingList("Maurice Foss", R.drawable.maurice_foss),
            new BuildingList("Multi Story CarPark", R.drawable.multi),
            new BuildingList("Priory Building", R.drawable.priory_building),
            new BuildingList("Richard Crossman", R.drawable.richard_crossman),
            new BuildingList("Sir John Laing", R.drawable.sir_john_laing),
            new BuildingList("Sir William Lyons", R.drawable.sir_william_lyons),
            new BuildingList("Sports Center", R.drawable.sport_centre),
            new BuildingList("Student Center", R.drawable.student_centre)



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
