package com.example.deguzman.pne;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public static final String result = "result";

    public static final String postition = "";

    public static final String KEY_DISEASE = "disease";

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                Model model1 = modellist.get(postition);
                if (model1.getTitle().equals("Downy Mildew")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Downy mildew (Bremia lactucae) is a common disease of lettuce in cooler growing environments, where temperatures are low and there are long periods of leaf wetness caused by overnight dew. These conditions are common in late-fall and in cool season greenhouses, and this fall we have seen downy mildew in field lettuce and in a heated winter greenhouse. Symptoms can include white sporulation on leaf surfaces and growers may see the white growth on leaves and assume they have powdery mildew. Importantly, downy mildew requires cool weather and leaf wetness while powdery mildew occurs during warm weather and under dry conditions. Downy mildew is caused by an oomycete like late blight and powdery mildew is caused by a fungus, so fungicides used to control one may not control the other. Be sure to properly identify the pathogen or submit a sample to the diagnostic lab." +
                            "Symptoms\n" +
                            "\n" +
                            "The disease causes leaf yellowing in angular patches, as the spots are vein-limited. On red varieties the initial spots may appear more grayish and water-soaked. Under humid conditions, white crusty sporulation forms when sporangiophores emerge from stomata and produce sporangia in distinct white projections, as with brassica downy mildew. Sporulation usually forms on the underside of the leaf but may also be seen on the upper leaf surface. Later, lesions turn tan or brown and papery as the tissue is killed. Older leaves close to the ground usually are the first to show symptoms.");
                    intent.putExtra("iconTv", R.drawable.downey_mildew);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Late Blight")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle",  model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Late blight has been referred to as a ‘community disease’, due to its ability to spread rapidly from field to field under the right weather conditions.  Asexual spores travel easily on the wind when the weather is cool and moist, and can rapidly infect neighboring fields.  As such, understanding the symptoms of the disease and what to do when it is detected are essential to preventing an outbreak from rapidly turning into an epidemic.");
                    intent.putExtra("iconTv", R.drawable.late_blight);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Viral Diseases")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Viruses are intracellular (inside cells) pathogenic particles that infect other living organisms. Human diseases caused by viruses include chickenpox, herpes, influenza, rabies, small pox and AIDS (acquired immunodeficiency syndrome). Although these are the viruses most of us are familiar with, the first virus ever described and from which the term was eventually derived was tobacco mosaic virus or TMV (the term virus was derived from the original description of the causal agent of TMV—“contagium vivum fluidum” or contagious living fluid). TMV was discovered by Martinus W. Beijerinck, a Dutch microbiologist, in 1898. Virus particles are extremely small and can be seen only with an electron microscope. Most plant viruses are either rod-shaped or isometric (polyhedral). TMV, potato virus Y (PVY), and cucumber mosaic virus (CMV) are examples of a short rigid rod-shaped, a long flexuous rod-shaped, and an isometric virus, respectively. Viruses consist of an inner core of nucleic acid (either ribonucleic acid [RNA] or deoxyribonucleic acid [DNA]) surrounded by an outer sheath or coat of protein (referred to as the capsid). The capsid is further enclosed by a membrane in most human and animal viruses that helps the virus pass through the cell membrane in these types of cells. Since the cell membrane in plants is surrounded by a rigid cell wall, plant viruses require a wound for their initial entrance into a plant cell. Wounds in plants can occur naturally, such as in the branching of lateral roots. They may also be the result of agronomic or horticultural practices, or other mechanical means; fungal, nematode, or parasitic plant infections; or by insects.");
                    intent.putExtra("iconTv", R.drawable.yellow_leaf);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bacterial spots")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Bacterial leaf spots are caused by the Xanthomonas and Pseudomonas families of bacteria. These bacteria overwinter in plant debris, but cannot survive for long in soil or water alone. Bacteria infect foliage, fruit, and stems, but require openings such as lesions to get inside the plant because they are relatively weak pathogens. Commonly, insects create lesions from feeding on plants, which the bacteria take advantage of. The pathogen itself is seedborne, which can then spread to other nearby plants after the seedling begins to grow through splashing water and overhead irrigation. Spread of the disease is moderately fast if water splashing is highly prevalent. However, this pathogen is highly dependent on cool and wet conditions, so if these conditions are not met, the pathogen’s distribution will be highly deterred.");
                    intent.putExtra("iconTv", R.drawable.bacterial_spots);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Gray Mold")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "A fungus that is pathogenic on many plants. This organism can survive on many hosts or on plant debris. It is an opportunistic pathogen and its spores (conidia) easily invade weak, damaged, or senescing tissue when wet. Conidia are produced throughout the growing season under a wide range of temperatures and humidity but cool temperatures, high humidity, and free water on plant surfaces favor the disease, as do close plant spacing and irrigation practices that keep plants wet for a long time. Downy mildew infection of leaves or Pythium infection of lower leaves or stems will make tissues susceptible to gray mold.");
                    intent.putExtra("iconTv", R.drawable.gray_mold);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Soft Rot")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Bacterial soft rots are caused by several types of bacteria, but most commonly by species of gram-negative bacteria, Erwinia, Pectobacterium, and Pseudomonas. It is a destructive disease of fruits, vegetables, and ornamentals found worldwide, and effects genera from nearly all the plant families. The bacteria mainly attack the fleshy storage organs of their hosts (tubers, corms, bulbs, and rhizomes), but they also affect succulent buds, stems, and petiole tissues. With the aid of special enzymes, the plant is turned into a liquidy mush in order for the bacteria to consume the plant cell's nutrients. Disease spread can be caused by simple physical interaction between infected and healthy tissues during storage or transit. The disease can also be spread by insects. Control of the disease is not always very effective, but sanitary practices in production, storing, and processing are something that can be done in order to slow the spread of the disease and protect yields. ");
                    intent.putExtra("iconTv", R.drawable.soft_rot);
                    view.getContext().startActivity(intent);
                }

            }

        });



        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}