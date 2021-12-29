package org.future.foodflix;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    String titles[], desc[];
    int images[] = {R.drawable.food3,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food2,
            R.drawable.food3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.RV1);

        titles = getResources().getStringArray(R.array.Titles);
        desc = getResources().getStringArray(R.array.Descriptions);

        myAdapter = new MyAdapter(this,titles,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        //String name= getIntent().getExtras().getString("name");
//        //Log.d("APP",name);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        //String name= getIntent().getExtras().getString("name");
//        //Log.d("APP",name);
//    }
//
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(SecondActivity.this,"Do you want to go back?",Toast.LENGTH_SHORT).show();
//        setResult(RESULT_OK);
//        SecondActivity.this.finish();
//    }
}