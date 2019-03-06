package com.cao.nang.baithi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bai1 extends AppCompatActivity {
    private EditText edtMasv;
    private EditText edtTensv;
    private EditText edtTuoi;
    private EditText edtEmail;
    StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
      init();
    }

    public void Themsv(View view) {
        try{
           String masv =edtMasv.getText().toString();
           String tensv=edtTensv.getText().toString();
           int tuoi= Integer.parseInt(edtTuoi.getText().toString());
           String email=edtEmail.getText().toString();
           if (masv.equals("")){
               show(" vui lòng không để trống mã sv");
           }
           else if(tensv.equals("")) {
               show("vui lòng ko để tróng tên sv");
           }

           else if(email.equals("")){
               show("vui lòng nhập email");
           } else if (studentDAO.insert(new Student(masv, tensv, tuoi, email)) > 0) {
               show("thêm thành công");
           }
          else if  (studentDAO.insert(new Student(masv, tensv, tuoi, email)) <=0){
              show("thêm thất bại");
            }
        }catch (NumberFormatException e){
           this. show("vui lòng nhập tuổi là số");
        }
    }
    public  void init(){
        edtMasv = (EditText) findViewById(R.id.edtMasv);
        edtTensv = (EditText) findViewById(R.id.edtTensv);
        edtTuoi = (EditText) findViewById(R.id.edtTuoi);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        studentDAO =new StudentDAO(this);
    }
    public void show(String dl){
        Toast.makeText(this,dl,Toast.LENGTH_LONG).show();
    }

    public void xemds(View view) {
        Intent intent=new Intent(bai1.this,listviewsv.class);
        startActivity(intent);
    }

}
