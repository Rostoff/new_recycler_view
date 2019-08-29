package com.hogsty.myapplication;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class MyElementAdapter extends RecyclerView.Adapter<MyElementAdapter.MyViewHolder> {

    List<Element> myElements;
    private OnNoteListener mOnNoteListener;

    public MyElementAdapter(List<Element> myElements, OnNoteListener onNoteListener) {
        this.myElements = myElements;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyElementAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_element, parent, false);
        return new MyViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyElementAdapter.MyViewHolder holder, int position) {
        holder.display(myElements.get(position));
    }

    @Override
    public int getItemCount() {
        return myElements.size();
    }






    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        OnNoteListener onNoteListener;

        private TextView mName;
        private TextView mPname;
        //private TextView mBirthDate;
        private TextView mDescription;
        private ImageView mImage;
        //private ImageView mArrowRight;

        public MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            mName = (TextView)itemView.findViewById(R.id.name);
            mPname = (TextView)itemView.findViewById(R.id.pname);
            //mBirthDate = (TextView)itemView.findViewById(R.id.birthdate);
            mDescription = (TextView)itemView.findViewById(R.id.description);
            mImage = (ImageView)itemView.findViewById(R.id.image);

            //mArrowRight = (ImageView)itemView.findViewById(R.id.arrow_right);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        public void display(Element element){
            mName.setText(element.getName());
            mPname.setText(element.getPname());
            //mBirthDate.setText(element.getBirthDate());
            mDescription.setText(element.getDescription());
            mImage.setImageResource(element.getImage());

            //mArrowRight.setImageResource(element.getArrow());
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

}

