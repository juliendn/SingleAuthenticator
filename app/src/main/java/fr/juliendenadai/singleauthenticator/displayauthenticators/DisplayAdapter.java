package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.models.Authenticator;

/**
 * Created by Julien De Nadai on 9/17/2015.
 */
public class DisplayAdapter extends RecyclerView.Adapter<DisplayViewHolder> {

    private static final int TYPE_STANDARD = 0;

    private final LinkedList<Authenticator> mAuthenticators;

    private Context mContext;

    public DisplayAdapter(Context context) {
        mContext = context;
        mAuthenticators = new LinkedList<>();
    }

    @Override
    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = null;
        DisplayViewHolder holder = null;

        switch (viewType) {
            case TYPE_STANDARD:
                view = inflater.inflate(R.layout.displayauthenticators_itemlist, parent, false);
                holder = new DisplayViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(DisplayViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mAuthenticators.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        final Authenticator authenticator = getItem(position);
        switch (authenticator.getType()) {
            case HOTP:
            case TOTP:
            case BATTLENET:
                type = TYPE_STANDARD;
                break;
        }
        return type;
    }

    public Authenticator getItem(int position) {
        return mAuthenticators.get(position);
    }

    public void addAuthenticator(Authenticator authenticator) {
        mAuthenticators.add(authenticator);
    }
}
