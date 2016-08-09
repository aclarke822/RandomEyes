package net.austinclarke.randomeyes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class aRandomGensHomeActivity extends AppCompatActivity implements View.OnTouchListener, AdapterView.OnItemClickListener {

    TextView textViewStrings;
    TextView textViewCustomStrings;
    TextView textViewIntegers;
    TextView textViewCards;
    TextView textViewCoins;
    TextView textViewDice;
    TextView textViewFloat;
    Toolbar myToolBar;
    TextView toolBarTitle;
    ImageView toolBarImageRight;
    Rect rect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_implementation);

        //Darken status bar for visibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        getWindow().clearFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

        //Provide context for fonts
        GFont font = new GFont(this);

        //Find XML views------------------------------
        textViewStrings = (TextView) findViewById(R.id.options_strings);
        textViewCustomStrings = (TextView) findViewById(R.id.options_custom_strings);
        textViewIntegers = (TextView) findViewById(R.id.options_integers);
        textViewCards = (TextView) findViewById(R.id.options_cards);
        textViewCoins = (TextView) findViewById(R.id.options_coins);
        textViewDice = (TextView) findViewById(R.id.options_dice);
        textViewFloat = (TextView) findViewById(R.id.options_float);
        myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        toolBarTitle = (TextView) myToolBar.findViewById(R.id.toolbar_title);
        toolBarImageRight = (ImageView) myToolBar.findViewById(R.id.toolbar_image_right);
        //--------------------------------------------

        //Toolbar
        setSupportActionBar(myToolBar);
        myToolBar.setNavigationIcon(R.mipmap.app2_launcher);
        toolBarTitle.setTextColor(ContextCompat.getColor(this, R.color.black));
        toolBarTitle.setText(R.string.app_name);
        toolBarImageRight.setImageResource(android.R.color.transparent);

        //Set fonts
        textViewStrings.setTypeface(GFont.main);
        textViewCustomStrings.setTypeface(GFont.main);
        textViewIntegers.setTypeface(GFont.main);
        textViewCards.setTypeface(GFont.main);
        textViewCoins.setTypeface(GFont.main);
        textViewDice.setTypeface(GFont.main);
        textViewFloat.setTypeface(GFont.main);
        toolBarTitle.setTypeface(GFont.main);

        // bind listeners
        textViewStrings.setOnTouchListener(this);
        textViewCustomStrings.setOnTouchListener(this);
        textViewIntegers.setOnTouchListener(this);
        textViewCards.setOnTouchListener(this);
        textViewCoins.setOnTouchListener(this);
        textViewDice.setOnTouchListener(this);
        textViewFloat.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Check which text view is clicked and launch appropriate activity
        Intent intent;
        View clickedView = findViewById(v.getId());
        int downViewId = v.getId();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.click_color));
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
                switch (downViewId) {
                    case R.id.options_strings:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        break;
                    case R.id.options_custom_strings:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        break;
                    case R.id.options_integers:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        break;
                    case R.id.options_cards:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        break;
                    case R.id.options_coins:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        break;
                    case R.id.options_dice:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        break;
                    case R.id.options_float:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        break;
                }
                break;
            case MotionEvent.ACTION_UP:
                switch (downViewId) {
                    case R.id.options_strings:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RStringsActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_custom_strings:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RCustomStringsActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_integers:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RIntegersActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_cards:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RCardsActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_coins:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RCoinsActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_dice:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.secondary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RDiceActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.options_float:
                        clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_color));
                        if (rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                            intent = new Intent(this, RFloatActivity.class);
                            startActivity(intent);
                        }
                        break;
                }


                break;
        }
        return true;
    }
/* Unused Menu Inflater/Listener
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu.
        // Adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_random_gens_home, menu);

        // Access the Share Item defined in menu XML
        MenuItem settingsItem = menu.findItem(R.id.menu_item_settings);
        settingsItem.setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
        return true;
    }
*/
    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Finish activity on back
        finish();
    }
}
