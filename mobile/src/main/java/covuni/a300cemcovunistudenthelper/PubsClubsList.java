package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 06/11/2017.
 */

public class PubsClubsList {
    String name;
    String address;
    String body;
    int image;

    public static final  PubsClubsList[] pubBuildings = {
            new PubsClubsList("Cosmos", R.drawable.cosmos,"Stylish, modern chain dining room with Pan-Asian cooking stations and global banquet options.", "36-42 Corporation St, Coventry CV1 1GF"),
            new PubsClubsList("Slug and Lettuce",R.drawable.slug_lettuce,"Smart bar chain with a cocktail list, a menu of global classics, and uncluttered contemporary decor.","The Old County Hall, Bayley Ln, Coventry CV1 5RN"),
            new PubsClubsList("Flying Standard", R.drawable.the_flying_standard,"Large chain pub known for its beer selection offering a British menu and a calm atmosphere","2-10 Trinity St, Coventry CV1 1FL"),
            new PubsClubsList("Nandos",R.drawable.nandos,"Afro-Portuguese chain restaurant serving flame-grilled chicken in spicy chilli sauce.","1-6, Ribbon Factory, Trinity St, Coventry CV1 1FE"),
            new PubsClubsList("Hans Dyansty",R.drawable.hans_dyansty,"Serving up amazing food, Han Dynasty - 汉朝sits in the heart of Coventry City Centre. With dishes you're guaranteed to love.","Priory Place, 1 Fairfax St, Coventry CV1 2TT"),
            new PubsClubsList("The Earl of Mercia", R.drawable.the_earl_of_mercia," The pub offers a range of real ales, craft beers and freshly ground Lavazza coffee.","18 High St, Coventry CV1 5RE"),
            new PubsClubsList("Drapers Bar and Kitchen", R.drawable.drapers,"Part of the Higgins Trust, Drapers Bar serve great food, a good selection of drinks and only a few yards from popular tourist attractions, it is the perfect place to have a drink, lunch or a sit down meal with friends and family.","Earl St, Coventry CV1 5RU"),
            new PubsClubsList("Ivy House", R.drawable.ivy_house,"Cocktail Bar | Underground Club | Kitchen - All in one truly unique venue.","44 Jordan Well, Coventry CV1 5RW"),
            new PubsClubsList("Pheonix Bar", R.drawable.phoenix_bar,"Bar with exposed-brick walls and banquettes, menu with pub grub and burgers plus live TV sport.","122 Gosford St, Coventry CV1 5DL"),
            new PubsClubsList("Quidds inn", R.drawable.quidds_inn,"Coventry's Best Student Venue. Student Only bar.","117 Gosford St, Coventry CV1 5DL"),
            new PubsClubsList("Kasbah Nightclub",R.drawable.kasbah,"Atmospheric venue for live music and club nights, with a beer garden and barbecue.","Primrose Hill St, Coventry CV1 5LY"),
            new PubsClubsList("Town Wall Tavern",R.drawable.town_wall_tavern,"Hostelry close to the local theatre with a selection of real ales plus traditional pub food.","Bond St, Coventry CV1 4AH"),
            new PubsClubsList("The Artisian Bar and Grill", R.drawable.artisan,"Bright, casual bar/restaurant with exposed beams and a beer garden, serving a British grill menu.","1-3 Ryley St, Coventry CV1 4AJ"),
            new PubsClubsList("The Town Crier", R.drawable.town_crier,"The Town Crier is ideally located and has an extensive food menu with your usual pub grub but all home made.We have an outside seating area on both sides of the pub. Fresh machine coffee, loose leaf teas, a minimum of 4 real ales, wines, lagers and cocktails are among the offerings of liquid refreshments to accompany our delicious pub food menu.","Corporation Street, Coventry CV1 1PB"),
            new PubsClubsList("The Oak Inn", R.drawable.theoak,"The Oak Inn is one of Coventry's latest opening main venues with food served daily. Fri/Sat 5am bar, with plenty of student discounts and karaoke Sundays.","119 Gosford St, Coventry CV1 5DL")

    };

   public PubsClubsList(String name, int image,String body, String address ){
        this.image = image;
        this.name = name;
        this.body = body;
        this.address = address;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getBody(){
        return body;
    }
    public int getImage(){
        return image;
    }
}
