package onehome.test.mygank.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import onehome.test.mygank.R;
import onehome.test.mygank.mode.entity.WebsiteBean;

/**
 * Created by Administrator on 2017/9/7.
 */

public class RecentRecyclerAdapter extends RecyclerView.Adapter<RecentRecyclerAdapter.MyHolder> {
    private List<WebsiteBean> list;
    private Context context;

    public RecentRecyclerAdapter(Context context, List<WebsiteBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_recycler_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.webView.loadData(list.get(position).getContent(), "text/html", "UTF-8");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        WebView webView;
        TextView title;

        public MyHolder(View itemView) {
            super(itemView);
            webView = (WebView) itemView.findViewById(R.id.wv);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
