package covuni.a300cemcovunistudenthelper;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Holmesy on 29/10/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {

    // For my adapter I used https://developer.android.com/training/material/lists-cards.html

    private String[] name;
    private int[] image;
    private Listener listener;
    ImageView imageView;
    TextView textView;
    Drawable drawable;


    //interface listener to call its onclick method whenever a item is selected
    interface Listener{
        void onClick(int position);
    }


    /*
    here we provide reference to the views for each data item
    so viewholder conatins CardView
     */

    public static class ViewHolder extends RecyclerView.ViewHolder{


        //cardView
        CardView cardView;

        public ViewHolder(CardView view){
            super(view);
            cardView = view;
        }

    }

    ////method to register as a listener
    public void setListener(Listener listener){
        this.listener = listener;
    }


    //Constructor for the dataset (Building name and image)

    public RecylerViewAdapter(String[] name, int[] image){
        this.name = name;
        this.image = image;
    }

    //Here we create the views which are invoked by the layout manager
    //instiate the cardview

    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view,parent,false);
        return new ViewHolder(cardView);

    }




    //method called when recyclerview reuses/uses a view holder

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        CardView cardView = holder.cardView;
        imageView = (ImageView)cardView.findViewById(R.id.image);

        //display the image in the imageView
        drawable = ContextCompat.getDrawable(cardView.getContext(), image[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(name[position]);

        //dislpay the text in the textview
        textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(name[position]);

        // here we add the cardview to the onclick listener
        //when clicked (cardview) it calls the listener method
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (listener !=null){
                    listener.onClick(position);
                }
            }
        });
    }



//returns size of the dataset
@Override
    public int getItemCount(){
        return name.length;
}






}
