package com.cao.nang.baithi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fixstudent extends AppCompatActivity {

    private EditText edtfixTensv;
    private EditText edtfixTuoi;
    private EditText edtfixEmail;
    StudentDAO studentDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixstudent);
        init();
    }

    public void Capnhap(View view) {
        try{
            Intent intent=getIntent();
            Bundle b=intent.getExtras();
            String masv =b.getString("Masv");
            String tensv=edtfixTensv.getText().toString();
            int tuoi= Integer.parseInt(edtfixTuoi.getText().toString());
            String email=edtfixEmail.getText().toString();
            if(tensv.equals("")) {
                show("vui lòng ko để tróng tên sv");
            }

            else if(email.equals("")){
                show("vui lòng nhập email");
            } else if (studentDAO.update(new Student(masv, tensv, tuoi, email))==true) {
                show("cập nhập thành công");
            }
            else if  (studentDAO.update(new Student(masv, tensv, tuoi, email))==false){
                show("cập nhập thất bại");
            }
        }catch (NumberFormatException e){
            this. show("vui lòng nhập tuổi là số");
        }
    }

    public void huythem(View view) {
    }
    public void show(String dl){
        Toast.makeText(this,dl,Toast.LENGTH_LONG).show();
    }
    public  void init(){

        edtfixTensv = (EditText) findViewById(R.id.edtfixTensv);
        edtfixTuoi = (EditText) findViewById(R.id.edtfixTuoi);
        edtfixEmail = (EditText) findViewById(R.id.edtfixEmail);

        studentDAO =new StudentDAO(this);
    }
}
