package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.models.Authenticator;

/**
 * Created by Julien De Nadai on 9/17/2015.
 */
public class DisplayViewHolder extends RecyclerView.ViewHolder {

    private DisplayLayout mLayout;

    public DisplayViewHolder(View itemView) {
        super(itemView);

        mLayout = (DisplayLayout) itemView.findViewById(R.id.displaylayout);
    }

    public void bind(Authenticator authenticator) {
        mLayout.bindAuthenticator(authenticator);
    }
}
