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

    interface Listener{
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;

        public ViewHolder(CardView view){
            super(view);
            cardView = view;
        }

    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public RecylerViewAdapter(String[] name, int[] image){
        this.name = name;
        this.image = image;
    }

    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view,parent,false);
        return new ViewHolder(cardView);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        CardView cardView = holder.cardView;
        imageView = (ImageView)cardView.findViewById(R.id.image);
        drawable = ContextCompat.getDrawable(cardView.getContext(), image[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(name[position]);

        textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(name[position]);


        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (listener !=null){
                    listener.onClick(position);
                }
            }
        });
    }




@Override
    public int getItemCount(){
        return name.length;
}






}
