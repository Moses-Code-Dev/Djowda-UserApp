package com.djowda.djowdamap.MapTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.djowda.djowdamap.MapTest.Utils.TileMap;
import com.djowda.djowdamap.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private final Context context;
    private final CellData cellData;
    private final int centerPosition;
    private ItemClickListener mItemClickListener;

    public GridAdapter(Context context) {
        this.context = context;
        this.cellData = new CellData();
        this.centerPosition = TileMap.getCenterPosition();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tile_item, parent, false);

        return new GridViewHolder(view, mItemClickListener, cellData);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {

        if (position == centerPosition) {
            holder.imageView.setImageResource(R.drawable.djowda_logo_02);
        } else if (cellData.hasData(position)) {
            holder.imageView.setImageResource(R.drawable.tile_test3);
        } else {
            holder.imageView.setImageResource(R.drawable.tile_test);
        }

//        if (position == centerPosition) {
//            Glide.with(holder.imageView.getContext())
//                    .load(R.drawable.djowda_logo_02)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(holder.imageView);
//        } else if (cellData.hasData(position)) {
//            Glide.with(holder.imageView.getContext())
//                    .load(R.drawable.tile_test3)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(holder.imageView);
//        } else {
//            Glide.with(holder.imageView.getContext())
//                    .load(R.drawable.tile_test)
////                    .load(R.drawable.tile_test3)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(holder.imageView);
//        }


//        holder.itemView.setOnClickListener(v -> {
//            if (mItemClickListener != null) {
//                long cellId = cellData.getCellIdForPosition(position);
//                mItemClickListener.onItemClick(v, position, cellId);
//            }
//        });
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        GridViewHolder(@NonNull View itemView, final ItemClickListener listener, final CellData cellData) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tileImageView);


            // --- SET THE LISTENER HERE, ONCE ---
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getBindingAdapterPosition(); // Get current position
                    if (position != RecyclerView.NO_POSITION) {
                        long cellId = cellData.getCellIdForPosition(position);
                        listener.onItemClick(v, position, cellId);
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return TileMap.getTotalItems();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    // Single cell update method - following the working pattern
    public void updateCell(int position, long cellId, Component component) {
        cellData.updateCell(position, cellId, component);
        notifyItemChanged(position);
    }

    // Clear all data when navigating to new location
    public void clearAllData() {
        cellData.clearAllData();
        notifyDataSetChanged(); // Refresh entire grid
    }

    // Alternative method to clear grid with range notification for better performance
    public void clearGridEfficient() {
        int itemCount = getItemCount();
        cellData.clearAllData();
        notifyItemRangeChanged(0, itemCount);
    }

    // Method to check if grid has any data
    public boolean hasAnyData() {
        return cellData.hasAnyData();
    }

    // Method to get total number of cells with data
    public int getDataCellCount() {
        return cellData.getDataCellCount();
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position, long cellId);
    }

    public void clearAll() {
        cellData.clear();
        notifyDataSetChanged();
    }
}
