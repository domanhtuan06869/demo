package com.cao.nang.baithi;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class studentAdapter  extends RecyclerView.Adapter<studentAdapter.studentAdapterHolder> {
    public  listviewsv context;
    public List<Student>studentList;
    public studentAdapter(listviewsv context,List<Student>studentList){
        this.context=context;
        this.studentList=studentList;
    }

    @NonNull
    @Override
    public studentAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_itemsvadt,viewGroup,false);
        return new studentAdapterHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull studentAdapterHolder holder, int i) {
        final int position=i;
        final Student student=studentList.get(i);

        holder.tvMasv.setText("mã sv : "+student.masv);
        holder.tvTensv.setText("tensv :"+student.tensv);
        holder.TvTuoi.setText("tuổi :"+student.tuoi);
        holder.TvEmail.setText("email :"+student.tensv);
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            context.removestudent(student.masv,position);
            }
        });
        holder.imgfix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, fixstudent.class);
                Bundle b = new Bundle();
                b.putString("Masv", student.masv);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public  class studentAdapterHolder extends RecyclerView.ViewHolder{
        TextView tvMasv, tvTensv,TvTuoi,TvEmail;
        ImageView imgfix,imgdelete;
        public studentAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imgfix=itemView.findViewById(R.id.imgfix);
            imgdelete=itemView.findViewById(R.id.imgdelete);
            tvMasv=itemView.findViewById(R.id.tvmasv);
            tvTensv=itemView.findViewById(R.id.tvtensv);
            TvTuoi=itemView.findViewById(R.id.tvtuoi);
            TvEmail=itemView.findViewById(R.id.tvemaill);
        }
    }
}
