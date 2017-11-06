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
            new PubsClubsList("Cosmos", R.drawable.alan_berry),
            new PubsClubsList("Slug and Lettuce",R.drawable.alan_berry),
            new PubsClubsList("Flying Standard", R.drawable.alan_berry),
            new PubsClubsList("Nandos",R.drawable.alan_berry),
            new PubsClubsList("Hans Dyansty",R.drawable.alan_berry),
            new PubsClubsList("The Earl of Mercia", R.drawable.alan_berry),
            new PubsClubsList("Drapers Bar and Kitchen", R.drawable.alan_berry),
            new PubsClubsList("Ivy House", R.drawable.alan_berry),
            new PubsClubsList("Pheonix Bar", R.drawable.alan_berry),
            new PubsClubsList("Quidds inn", R.drawable.alan_berry),
            new PubsClubsList("Kasbah Nightclub",R.drawable.alan_berry),
            new PubsClubsList("Town Wall Tavern",R.drawable.alan_berry),
            new PubsClubsList("The Artisian Bar and Grill", R.drawable.alan_berry),
            new PubsClubsList("The Town Crier", R.drawable.alan_berry),
            new PubsClubsList("The Oak Inn", R.drawable.alan_berry)

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
