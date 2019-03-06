package com.cao.nang.baithi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listviewsv extends AppCompatActivity {
    private RecyclerView recyvlerviewlist;
    private List<Student> list;
    private studentAdapter adapter;
    private StudentDAO studentDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewsv);
        recyvlerviewlist = (RecyclerView) findViewById(R.id.recyvlerviewlist);
        studentDAO=new StudentDAO(this);
        list=new ArrayList<>();
        list=studentDAO.getAllstudent();

       adapter=new studentAdapter(this,list);
        recyvlerviewlist.setLayoutManager(new LinearLayoutManager(this));
        recyvlerviewlist.setAdapter(adapter);

    }
    public void removestudent(String masv, int position){
        studentDAO.remove(masv);
        list.remove(position);
        adapter.notifyDataSetChanged();
      Toast.makeText(this,"Xóa sv thành công",Toast.LENGTH_LONG).show();
    }
}
