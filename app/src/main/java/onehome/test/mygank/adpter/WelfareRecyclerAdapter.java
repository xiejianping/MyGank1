package onehome.test.mygank.adpter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import onehome.test.mygank.R;
import onehome.test.mygank.activity.PhotoViewActivity;
import onehome.test.mygank.mode.entity.WelfareBean;

/**
 * Created by Administrator on 2017/9/8.
 */

public class WelfareRecyclerAdapter extends RecyclerView.Adapter<WelfareRecyclerAdapter.WelfareHolder> implements View.OnClickListener {
    private List<WelfareBean> list;
    private Context context;

    public WelfareRecyclerAdapter(Context context, List<WelfareBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public WelfareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.welfare_recycler_item, parent, false);
        return new WelfareHolder(view);
    }

    @Override
    public void onBindViewHolder(WelfareHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrl()).into(holder.imageView);
        holder.imageView.setTag(R.id.iv, list.get(position));
        holder.imageView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        WelfareBean tag = (WelfareBean) v.getTag(R.id.iv);
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putExtra("uu", tag.getUrl());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(((Activity) context), Pair.create(v, "photo_iv")).toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    class WelfareHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public WelfareHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.welfare_iv);
        }
    }
}
