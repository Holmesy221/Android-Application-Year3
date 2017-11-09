package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 06/11/2017.
 */

public class PubsClubsList {
    String name;
    String address;
    String body;
    int image;

    public static final PubsClubsList[] pubBuildings = {
            new PubsClubsList("Cosmos", R.drawable.cosmos),
            new PubsClubsList("Slug and Lettuce",R.drawable.slug_lettuce),
            new PubsClubsList("Flying Standard", R.drawable.the_flying_standard),
            new PubsClubsList("Nandos",R.drawable.nandos),
            new PubsClubsList("Hans Dyansty",R.drawable.hans_dyansty),
            new PubsClubsList("The Earl of Mercia", R.drawable.the_earl_of_mercia),
            new PubsClubsList("Drapers Bar and Kitchen", R.drawable.drapers),
            new PubsClubsList("Ivy House", R.drawable.ivy_house),
            new PubsClubsList("Pheonix Bar", R.drawable.phoenix_bar),
            new PubsClubsList("Quidds inn", R.drawable.quidds_inn),
            new PubsClubsList("Kasbah Nightclub",R.drawable.kasbah),
            new PubsClubsList("Town Wall Tavern",R.drawable.town_wall_tavern),
            new PubsClubsList("The Artisian Bar and Grill", R.drawable.artisan),
            new PubsClubsList("The Town Crier", R.drawable.town_crier),
            new PubsClubsList("The Oak Inn", R.drawable.theoak)

    };

    PubsClubsList(String name, int image){
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
