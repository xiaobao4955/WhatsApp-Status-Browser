package com.theah64.whatsappstatusbrowser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.theah64.whatsappstatusbrowser.R;
import com.theah64.whatsappstatusbrowser.models.Status;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by theapache64 on 16/7/17.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private final List<Status> statusList;
    private final LayoutInflater inflater;

    public StatusAdapter(final Context context, List<Status> statusList) {
        this.statusList = statusList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View rowLayout = inflater.inflate(R.layout.status_row, parent, false);
        return new ViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Status status = statusList.get(position);
        ImageLoader.getInstance().displayImage(status.getThumbPath(), holder.civThumbnail);
        holder.tvTitle.setText(status.getTitle());
        holder.tvSubTitle.setText(status.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView civThumbnail;
        private final TextView tvTitle, tvSubTitle;

        ViewHolder(View itemView) {
            super(itemView);
            this.civThumbnail = (CircleImageView) itemView.findViewById(R.id.civThumbnail);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.tvSubTitle = (TextView) itemView.findViewById(R.id.tvSubTitle);
        }
    }
}