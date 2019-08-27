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
        private TextView mDescription;
        private ImageView mImage;
        private ImageView mArrowRight;

        public MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            mName = (TextView)itemView.findViewById(R.id.name);
            mDescription = (TextView)itemView.findViewById(R.id.description);
            mImage = (ImageView)itemView.findViewById(R.id.image);
            mArrowRight = (ImageView)itemView.findViewById(R.id.arrow_right);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        public void display(Element element){
            mName.setText(element.getName());
            mDescription.setText(element.getDescription());
            mImage.setImageResource(element.getImage());
            mArrowRight.setImageResource(element.getArrow());
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


//    public class MyItemKeyProvider extends ItemKeyProvider {
//        private final List<Element> elementList;
//
//        public MyItemKeyProvider(int scope, List<Element> itemList) {
//            super(scope);
//            this.elementList = itemList;
//        }
//
//        @Nullable
//        @Override
//        public Object getKey(int position) {
//            return elementList.get(position);
//        }
//
//        @Override
//        public int getPosition(@NonNull Object key) {
//            return elementList.indexOf(key);
//        }
//    }
//
//
//    public class MyItemLookup extends ItemDetailsLookup {
//
//        private final RecyclerView recyclerView;
//
//        public MyItemLookup(RecyclerView recyclerView) {
//            this.recyclerView = recyclerView;
//        }
//
//        @Nullable
//        @Override
//        public ItemDetails getItemDetails(@NonNull MotionEvent e) {
//            View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
//            if (view != null) {
//                RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
//                if (viewHolder instanceof MyElementAdapter.MyViewHolder) {
//                    return ((MyElementAdapter.MyViewHolder) viewHolder).getItemDetails();
//                }
//            }
//
//            return null;
//        }
//    }



