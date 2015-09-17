package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.models.Authenticator;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 17/09/15.
 */
public class DisplayLayout extends RelativeLayout {

    private ImageView mImage;
    private TextView mText;

    public DisplayLayout(Context context) {
        this(context, null);
    }

    public DisplayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext())
                .inflate(R.layout.displayauthenticators_layout, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // TODO get views

        mImage = (ImageView) findViewById(android.R.id.icon);
        mText = (TextView) findViewById(android.R.id.text1);

        this.setClickable(true);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showCode();
            }
        });

    }

    public void bindAuthenticator(Authenticator authenticator) {
        setImage(R.drawable.ic_google);
        setText(authenticator.getLabel());
    }

    private void showCode() {
        mImage.animate().alpha(0f);
        mText.setTypeface(Typeface.MONOSPACE);
        mText.setText("1234567");
    }

    private void setImage(int resource) {
        Picasso.with(getContext())
                .load(resource)
                .error(R.drawable.ic_error_outline_black_48dp)
                .into(mImage);
    }

    private void setText(String label) {
        mText.setText(label);
    }
}
