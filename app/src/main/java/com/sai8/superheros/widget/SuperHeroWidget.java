package com.sai8.superheros.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import com.sai8.superheros.R;
import com.sai8.superheros.activity.Hero_Details;

/**
 * Implementation of App Widget functionality.
 */
public class SuperHeroWidget extends AppWidgetProvider {
    static SharedPreferences sharedPreferences;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        sharedPreferences = context.getSharedPreferences(Hero_Details.name, Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("name","no Data");
        String realname=sharedPreferences.getString("realname","no data");
        String publisher=sharedPreferences.getString("publisher","no data");
        String fappear=sharedPreferences.getString("firstappearence","no data");
        String fav=sharedPreferences.getString("favorites","no data");
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.super_hero_widget);
        views.setTextViewText(R.id.appwidget_name, name);
        views.setTextViewText(R.id.appwidget_realname,realname);
        views.setTextViewText(R.id.appwidget_publisher,publisher);
        views.setTextViewText(R.id.appwidget_fappearence,fappear);
        views.setTextViewText(R.id.appwidget_favorite,fav);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

