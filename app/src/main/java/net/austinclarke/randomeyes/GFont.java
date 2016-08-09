package net.austinclarke.randomeyes;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Austin on 11/5/2015.
 */

public class GFont {
    public static Typeface main;
    public static Typeface secondary;
    public static Typeface tertiary;
    public static Typeface droid;

    public GFont(Context context) {
        main = Typeface.DEFAULT;
        //secondary = Typeface.createFromAsset(context.getAssets(), "tek.ttf");
        //tertiary = Typeface.createFromAsset(context.getAssets(), "tek.ttf");
        droid = Typeface.DEFAULT;
    }
}