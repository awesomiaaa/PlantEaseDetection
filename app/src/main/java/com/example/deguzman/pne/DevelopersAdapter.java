package com.example.deguzman.pne;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;

/**
 * Created by EKENE on 7/23/2017.
 */

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
    public static final String KEY_ID = "id";
    public static final String KEY_PLANT_NO = "plant_no";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_DISEASE = "disease";
    public static final String KEY_DIAGNOSIS = "diagnosis";
    public static final String KEY_IMAGE = "model_pic";
    public static final String A1 = "A1";

    public static TextView loc;
    public static TextView id;

    // we define a list from the DevelopersList java class

    private List<DevelopersList> developersLists;
    private Context context;

    public DevelopersAdapter(List<DevelopersList> developersLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.developersLists = developersLists;
        this.context = context;



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.developers_list, parent, false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final DevelopersList developersList = developersLists.get(position);
        holder.condition.setText(developersList.getCondition());
        holder.plant_no.setText(developersList.getPlant_no());
        if(developersList.getPlant_no().equals("1")) {

            holder.loc.setText("A1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("2")) {

            holder.loc.setText("A2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("3")) {

            holder.loc.setText("B1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("4")) {

            holder.loc.setText("B2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("5")) {

            holder.loc.setText("C1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("6")) {

            holder.loc.setText("C2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("7")) {

            holder.loc.setText("D1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("8")) {

            holder.loc.setText("D2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("9")) {

            holder.loc.setText("E1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("10")) {

            holder.loc.setText("E2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("11")) {

            holder.loc.setText("F1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("12")) {

            holder.loc.setText("F2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("13")) {

            holder.loc.setText("G1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("14")) {

            holder.loc.setText("G2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("15")) {

            holder.loc.setText("H1");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }
        if(developersList.getPlant_no().equals("16")) {

            holder.loc.setText("H2");
            if (developersList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (developersList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
        }

     //   holder.id.setText(developersList.getId());

/*
        holder.model_pic.setImageIcon(developersList.getModel_pic());*/
 /*       Glide.with(context)
                .load(developersList.getModel_pic())
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.model_pic);*/

/*        Picasso.with(context)
                .load(developersList.getModel_pic())
                .into(holder.model_pic);*/

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DevelopersList developersList1 = developersLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), DisplayActivity.class);
      //          skipIntent.putExtra(KEY_PLANT_TYPE, developersList1.getPlant_type());
                if (developersList.getCondition().equals("healthy")){
                    skipIntent.putExtra(KEY_PLANT_NO, developersList1.getPlant_no());
                    skipIntent.putExtra(KEY_ID, developersList1.getId());
                    skipIntent.putExtra(KEY_CONDITION, developersList1.getCondition());
                    skipIntent.putExtra(KEY_IMAGE, developersList1.getModel_pic());
                    v.getContext().startActivity(skipIntent);
                }
                else {
                    skipIntent.putExtra(KEY_PLANT_NO, developersList1.getPlant_no());
                    skipIntent.putExtra(KEY_ID, developersList1.getId());
                    skipIntent.putExtra(KEY_CONDITION, developersList1.getCondition());
                    skipIntent.putExtra(KEY_DISEASE, developersList1.getDisease());
                    skipIntent.putExtra(KEY_DIAGNOSIS, developersList1.getDiagnosis());
                    /*             skipIntent.putExtra(KEY_URL, developersList1.getHtml_url());*/
                    skipIntent.putExtra(KEY_IMAGE, developersList1.getModel_pic());


                    v.getContext().startActivity(skipIntent);

                }

            }
        });



    }

    @Override

    //return the size of the listItems (developersList)

    public int getItemCount() {
        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects
        public TextView id;
        public TextView plant_no;
        public TextView plant_type;
        public TextView condition;
        public TextView disease;
        public TextView diagnosis;
        public ImageView model_pic;
        public TextView loc;
        public CardView card;
        /*public TextView html_url;
*/        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View object
            card = (CardView) itemView.findViewById(R.id.card);
            loc = (TextView) itemView.findViewById(R.id.loc);
         //   id = (TextView) itemView.findViewById(R.id.id);
            plant_no = (TextView) itemView.findViewById(R.id.plant_no);
            condition = (TextView) itemView.findViewById(R.id.conditiontxt);
            disease = (TextView) itemView.findViewById(R.id.textView);
            diagnosis = (TextView) itemView.findViewById(R.id.textView2);
         //   model_pic = (ImageView) itemView.findViewById(R.id.imageView);
            /*html_url = (TextView) itemView.findViewById(R.id.htmUrl);*/
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

            /*if(KEY_PLANT_NO.equals("")){
                loc.setText("A1");
                loc.append("A1");
                loc.getResources().getColor(R.color.colorAccent);
            }*/




        }

    }
}
