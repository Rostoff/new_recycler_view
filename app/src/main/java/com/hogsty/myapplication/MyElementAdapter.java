package com.hogsty.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyElementAdapter extends RecyclerView.Adapter<MyElementAdapter.MyViewHolder> {

    List<Element> myElements;

    public MyElementAdapter(List<Element> myElements) {
        this.myElements = myElements;
    }

    @NonNull
    @Override
    public MyElementAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_element, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyElementAdapter.MyViewHolder holder, int position) {
        holder.display(myElements.get(position));
    }

    @Override
    public int getItemCount() {
        return myElements.size();
    }






    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mDescription;
        private ImageView mImage;
        private ImageView mArrowRight;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = (TextView)itemView.findViewById(R.id.name);
            mDescription = (TextView)itemView.findViewById(R.id.description);
            mImage = (ImageView)itemView.findViewById(R.id.image);
            mArrowRight = (ImageView)itemView.findViewById(R.id.arrow_right);
        }

        public void display(Element element){
            mName.setText(element.getName());
            mDescription.setText(element.getDescription());
            mImage.setImageResource(element.getImage());
            mArrowRight.setImageResource(element.getArrow());
        }
    }
}
