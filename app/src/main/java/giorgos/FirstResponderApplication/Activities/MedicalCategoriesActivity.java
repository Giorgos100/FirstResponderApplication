package giorgos.FirstResponderApplication.Activities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.AppCompatActivity;

import giorgos.FirstResponderApplication.JsonParserJavaFiles.Download_data;
import giorgos.FirstResponderApplication.JsonParserJavaFiles.Download_data.download_complete;

import android.os.Bundle;
import android.widget.ListView;

import giorgos.FirstResponderApplication.JsonParserJavaFiles.ListAdapter;
import giorgos.FirstResponderApplication.JsonParserJavaFiles.MedicalCtgrs;
import giorgos.FirstResponderApplication.R;


public class MedicalCategoriesActivity extends AppCompatActivity implements download_complete
{

  public ListView MedicaCategorieListView;
    public ArrayList<MedicalCtgrs> MedicalCategories = new ArrayList<MedicalCtgrs>();
    public ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_categories);
        android.support.v7.app.ActionBar ab = getSupportActionBar();

        MedicaCategorieListView = (ListView) findViewById(R.id.MedicaCategorieListView);
        adapter = new ListAdapter(this);
        MedicaCategorieListView.setAdapter(adapter);

        Download_data download_data = new Download_data((download_complete) this);
       download_data.download_data_from_link("https://firstresponderapplication.azurewebsites.net/tables/MedicalCategories?ZUMO-API-VERSION=2.0.0");

     //   MedicaCategorieListView.setOnClickListener(new adapter.)

    }
/*
    MedicaCategorieListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
    public void onItemClick(AdapterView<?> parent, View view,
    int position, long id)

    {
        if (position == 0) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 1) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 2) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 3) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 4) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 5) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 6) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 7) {
            Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
            startActivityForResult(myIntent, 0);
        }
    }
});

*/


    public void get_data(String data)
    {

        try {
            JSONArray data_array=new JSONArray(data);

            for (int i = 0 ; i < data_array.length() ; i++)
            {
                JSONObject obj=new JSONObject(data_array.get(i).toString());

                MedicalCtgrs add=new MedicalCtgrs();
                add.name = obj.getString("medical_category_name");
                //add.code = obj.getString("code");

                MedicalCategories.add(add);

            }

            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}


