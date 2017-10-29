package covuni.a300cemcovunistudenthelper;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Holmesy on 29/10/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>{

    private String[] mName;
    private int[] mImage;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView mCardView;

        public ViewHolder(CardView view){
            super(view);
            mCardView = view;
        }

    }

    public RecylerViewAdapter(String[] name, int[] image){
        mName = name;
        mImage = image;
    }

    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view,parent,false);
        return new ViewHolder(cardView);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.mCardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),mImage[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(mName[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(mName[position]);
    }


@Override
    public int getItemCount(){
        return mName.length;
}




}
