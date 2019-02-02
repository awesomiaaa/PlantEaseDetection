package com.example.deguzman.pne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment3 extends Fragment {
    TextView tab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment3, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);



        tab = (TextView) view.findViewById(R.id.textView3);
        tab.setText(diagnosis);
        //   tab.setText(diagnosis);
        if(condition.equalsIgnoreCase("unhealthy")) {
            if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
                tab.setText("> When selecting fruit trees, choose resistant varieties if possible.\n" +
                        "\n" +
                        "> Keep the soil under the tree clean and rake up fallen fruit.\n" +
                        "\n" +
                        "> Use a thick layer of mulch to cover the soil after you have raked and cleaned it well. Mulch will reduce weeds and prevent the disease pathogen from splashing back up onto the leaves.\n" +
                        "\n" +
                        "> Prune or stake plants to improve air circulation. Make sure to disinfect your pruning equipment (one part bleach to 4 parts water) after each cut.\n" +
                        "\n" +
                        "> Leaf spot among vegetables is most often introduced through infected seed or transplants. Make sure your seeds and transplants are from leaf spot-free stock.");
            } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
                tab.setText("> Choose plants that are resistant or tolerant to powdery mildew. Many mildew-resistant varieties of cucurbits (melons, cucumbers, squash, etc.) have been developed and can be bought from major seed suppliers.\n" +
                        "\n" +
                        "> Avoid watering plants from overhead in order to reduce relative humidity.\n" +
                        "\n" +
                        "> Selectively prune overcrowded areas to increase air circulation; this also helps to reduce humidity around your plants.\n" +
                        "\n" +
                        "> Spray your plants with the fungicides mentioned above according to the directions included with the products.\n" +
                        "\n" +
                        "If you don't want to use fungicides, try spraying your plants with a bicarbonate solution:\n" +
                        "Mix 1 teaspoon baking soda in 1 quart of water. Spray plants thoroughly, as the solution will only kill fungus that it comes into contact with.\n");
            } else if (disease.equalsIgnoreCase("Anthracnose") || disease.equalsIgnoreCase("antracnose' ")) {
                tab.setText("Plant resistant plants, or buy healthy transplants.\n" +
                        "Plant your plants in well-drained soil. You can also enrich the soil with compost in order to help plants resist diseases.\n" +
                        "Water your plants with a drip sprinkler, as opposed to an overhead sprinkler. Don’t touch the plants when they are wet.\n" +
                        "Keep ripening fruits from touching the soil.\n" +
                        "Remember to rotate your plants every 2 to 3 years.");
            } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("lateblight")) {
                tab.setText("Use less susceptible varieties as well as healthy seeds from certified source. \n" +
                        "Avoid tight plantings to promote aeration of canopy. \n" +
                        "Inspect the orchard regularly to detect the first signs of the diseases. \n" +
                        "Manage weeds on the orchard floor. \n" +
                        "Cut and burn the affected parts as soon as the first symptoms are visible. \n" +
                        "Avoid irrigation by sprinkling especially during fruit ripening. \n" +
                        "Above all, do now compost these plant parts as they will carry over the disease to another season. ");
            } else if (disease.equalsIgnoreCase("not a plant") || disease.equalsIgnoreCase("object")) {
                tab.setText("None");
            }
        }
        else if(condition.equalsIgnoreCase("object")) {
            tab.setText("Not a Plant");
        }
        else if(condition.equalsIgnoreCase("healthy")|| disease.equalsIgnoreCase("HEALTHY")){
            tab.setText("No Disease Detected");
        }
        return view;


    }
}
