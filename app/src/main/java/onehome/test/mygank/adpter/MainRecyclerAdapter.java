package onehome.test.mygank.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import onehome.test.mygank.R;
import onehome.test.mygank.activity.WebViewActivity;
import onehome.test.mygank.global.Constant;
import onehome.test.mygank.mode.entity.AllDataBean;

/**
 * Created by Administrator on 2017/9/8.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainHolder> implements View.OnClickListener {
    private List<AllDataBean> list;
    private Context context;

    public MainRecyclerAdapter(Context context, List<AllDataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_recycler_item, parent, false);
        view.setOnClickListener(this);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        holder.title.setText(list.get(position).getDesc());
        holder.classify.setText(list.get(position).getType());
        holder.who.setText(list.get(position).getWho());
        List<String> images = list.get(position).getImages();
        if (images != null) {
            Glide.with(context).load(images.get(0)+"?imageView2/0/w/100").into(holder.iv);
            holder.iv.setVisibility(View.VISIBLE);
        } else {
            holder.iv.setVisibility(View.GONE);
        }
        holder.itemView.setTag(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        AllDataBean tag = (AllDataBean) v.getTag();
        String url = tag.getUrl();
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(Constant.WV_URL, url);
        context.startActivity(intent);
    }

    class MainHolder extends RecyclerView.ViewHolder {
        TextView title, classify, who;
        ImageView iv;

        public MainHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            classify = (TextView) itemView.findViewById(R.id.tv_classify);
            who = (TextView) itemView.findViewById(R.id.tv_who);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
