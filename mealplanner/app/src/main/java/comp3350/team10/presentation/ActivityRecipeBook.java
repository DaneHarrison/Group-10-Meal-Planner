package comp3350.team10.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import comp3350.team10.R;
import comp3350.team10.business.MealDiaryOps;
import comp3350.team10.objects.*;
import comp3350.team10.persistence.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityRecipeBook extends AppCompatActivity implements FragToParent {
    private LinkedList<ListItem> data;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView mealRecyclerView;
    private MealDiaryLiveData mealDiaryData; //replace later
    private MealDiaryOps opExec;             //replace later
    private ListItem saved;
    private int savedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setActionBar(toolbar);
        toolbar.setTitle("MealPlanner");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setElevation(0);
        setTabListeners();
        init();
    }

    private void setTabListeners(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tab.getPosition();
                //pull data based on tab
                //recently used first, will update on search
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void init(){
        mealDiaryData = new ViewModelProvider(this).get(MealDiaryLiveData.class);
        opExec = new MealDiaryOps(mealDiaryData);
        data = opExec.getData();
        recyclerViewAdapter = new RecyclerViewAdapter(data);
        mealRecyclerView = (RecyclerView) findViewById(R.id.recipeRecyclerView);
        mealRecyclerView.setAdapter(recyclerViewAdapter);
        mealRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void showContextUI(int pos) { //do a thing here to take an object as well?
        System.out.println("clicked " + " " + pos);
        System.out.println("Size: " + data.size());
        System.out.println("Position: " + pos);
        if (pos != savedPos && saved != null) {
            data.remove(savedPos);
            data.add(savedPos, saved);
        }
        if (data.get(pos).getFragmentType() == ListItem.FragmentType.recipe) {
            saved = data.remove(pos);
            savedPos = pos;
            data.add(pos, new DiaryItem(0, ListItem.FragmentType.cardSelection, "null", 00, ListItem.Unit.g, 0, "noIcon"));
        } else {
            data.remove(pos);
            data.add(pos, saved);
            saved = null;
        }
        //mealRecyclerView.removeViewAt(pos);
        recyclerViewAdapter.notifyItemRemoved(pos);
        recyclerViewAdapter.notifyItemRangeChanged(pos, data.size());
        recyclerViewAdapter.notifyDataSetChanged();
    }

    public void navClick(){

    }
    public void hideContextUI(Fragment fragment){

    }
    public void setData(View view){

    }
    public void selectDate(){

    }
    public void prevDate(){

    }
    public void nextDate(){

    }
    public void setGoal(){

    }

    public void addDiaryItem(DiaryItem item) {
        System.out.println("calling the addDiary thing");
        opExec.addToDiary(item);
    }
}