package net.austinclarke.randomeyes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static net.austinclarke.randomeyes.RandomFactory.getRInteger;


/**
 * Created by Austin on 11/3/2015.
 */
public class RDiceActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    int listCopyIndex;
    int quantity;
    int sides;
    String rollResult = "";

    Button mainButton;
    EditText quantityEditText;
    EditText sidesEditText;
    ListView mainListView;
    Toolbar myToolBar;
    TextView toolBarTitle;
    ImageView toolBarImageRight;

    //Array adapter for ListView
    ArrayAdapter mArrayAdapter;
    ArrayList displayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdice_activity);

        //Darken status bar for visibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        getWindow().clearFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

        //Provide context for fonts
        GFont font = new GFont(this);

        //Access objects from XML---------------------
        quantityEditText = (EditText) findViewById(R.id.dice_quantity);
        sidesEditText = (EditText) findViewById(R.id.dice_sides);
        mainButton = (Button) findViewById(R.id.dice_button);
        mainListView = (ListView) findViewById(R.id.dice_list);
        myToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        toolBarTitle = (TextView) myToolBar.findViewById(R.id.toolbar_title);
        toolBarImageRight = (ImageView) myToolBar.findViewById(R.id.toolbar_image_right);
        //--------------------------------------------

        //Toolbar
        setSupportActionBar(myToolBar);
        myToolBar.setNavigationIcon(R.drawable.left_arrow);
        toolBarTitle.setTextColor(ContextCompat.getColor(this, R.color.black));
        toolBarTitle.setText(R.string.dice_name);
        toolBarImageRight.setImageResource(R.drawable.android_dice);

        //Set font
        mainButton.setTypeface(GFont.main);
        quantityEditText.setTypeface(GFont.main);
        toolBarTitle.setTypeface(GFont.main);

        //Setup a click listener for button
        mainButton.setOnClickListener(this);
        myToolBar.setNavigationOnClickListener(this);

        //Setup a long click listener for listview
        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listCopyIndex = position;
                return false;
            }
        });

        //Create an ArrayAdapter for the ListView
        mArrayAdapter = new getCustomListAdapter(this, R.layout.custom_list, displayList);
        //Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);
        //Register listview for contextmenu
        registerForContextMenu(mainListView);
    }

    @Override
    public void onClick(View v) {
        KeyboardUtility.hideKeyboard(this);
        displayList.clear();

        switch (v.getId()) {
            case R.id.dice_button:
                try {
                    quantity = quantityEditText.getText().toString().length() == 0 ? 1 : Integer.parseInt(quantityEditText.getText().toString());
                    sides = sidesEditText.getText().toString().length() == 0 ? 6 : Integer.parseInt(sidesEditText.getText().toString());
                    if (quantity > 100) {quantity = 100;
                        quantityEditText.setText("100");}
                    if (sides > 100) {sides = 100;
                        sidesEditText.setText("100");}
                } catch (NumberFormatException error1) {
                    quantityEditText.setText("");
                    sidesEditText.setText("");
                    displayList.add(0, "Too big!!");
                    break;
                }
                for (int i = 0; i < quantity; i++) {
                    rollResult = EnglishNumberToWords.convert(getRInteger(1, sides));
                    displayList.add(0, rollResult);
                }
                break;



            default:
                getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                Intent intent;
                intent = new Intent(this, aRandomGensHomeActivity.class);
                startActivity(intent);
                finish();
        }
        mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.dice_list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Actions");
            String[] menuItems = getResources().getStringArray(R.array.context_menu);
            for (int i = 0; i < menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        switch (menuItemIndex) {
            case 0:
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", displayList.get(listCopyIndex).toString());
                clipboard.setPrimaryClip(clip);
                break;
            case 1:
                break;
        }
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        //Finish activity on back
        getWindow().addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        Intent intent;
        intent = new Intent(this, aRandomGensHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
