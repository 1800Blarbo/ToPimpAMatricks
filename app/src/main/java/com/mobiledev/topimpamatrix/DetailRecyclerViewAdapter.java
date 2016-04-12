package com.mobiledev.topimpamatrix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by larspmayrand on 4/11/16.
 */
public class DetailRecyclerViewAdapter extends RecyclerView.Adapter<DetailRecyclerViewAdapter.DetailViewHolder> {

    private Detail[] mDetails;
    private DetailRowOnClickListener mListener;

    public interface DetailRowOnClickListener {
        void onDetailRowClick(Detail detail);
    }

    public DetailRecyclerViewAdapter(Detail[] details, DetailRowOnClickListener listener) {
        mDetails = details;
        mListener = listener;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.detail_row, parent, false);
        return new DetailViewHolder(row);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        final Detail detail = mDetails[position];

        holder.mTextView.setText(detail.getDescription());
        WebSettings webSettings = holder.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String js = MatrixFormatter.makeLatexString(detail.getLatex());
        holder.mWebView.loadDataWithBaseURL("file:///android_asset/", js, "text/html", "UTF-8", null);


        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDetailRowClick(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDetails.length;
    }

    static class DetailViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.detail_row_textview)
        TextView mTextView;

        @Bind(R.id.detail_row_webview)
        WebView mWebView;

        public View mItemView;

        public DetailViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView); // I THINK THIS IS BAD
            try {
                ButterKnife.bind(this, itemView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mItemView = itemView;
        }
    }

}


