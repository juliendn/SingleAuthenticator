package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Random;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.models.Authenticator;

/**
 * Created by Julien De Nadai on 9/17/2015.
 */
public class DisplayViewHolder extends RecyclerView.ViewHolder {

    private final ViewSwitcher mSwitcher;
    private final ImageView mImage;
    private final TextView mText;
    private final ImageView mImage2;
    private final TextView mText2;

    public DisplayViewHolder(View itemView) {
        super(itemView);
        mSwitcher = (ViewSwitcher) itemView.findViewById(R.id.switcher);
        mImage = (ImageView) itemView.findViewById(R.id.imageView1);
        mText = (TextView) itemView.findViewById(android.R.id.text1);
        mImage2 = (ImageView) itemView.findViewById(R.id.imageView2);
        mText2 = (TextView) itemView.findViewById(android.R.id.text2);

        itemView.setBackgroundColor(Color.rgb(new Random().nextInt(256),
                new Random().nextInt(256),
                new Random().nextInt(256)));
    }

    public void bind(Authenticator item) {
        mText.setText(item.getLabelAlt());
        mText2.setText(new String(item.getSecret()));
    }
}
