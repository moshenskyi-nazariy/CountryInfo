package com.nazarii_moshenskyi.countryinfo.ui.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CountryItemDecorator extends RecyclerView.ItemDecoration {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private final int spacing;

    public CountryItemDecorator(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildViewHolder(view).getAdapterPosition();
        int itemCount = state.getItemCount();
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        setSpacingForDirection(outRect, layoutManager, position, itemCount);
    }

    private void setSpacingForDirection(Rect outRect,
                                        RecyclerView.LayoutManager layoutManager,
                                        int position,
                                        int itemCount) {

        if (layoutManager.canScrollHorizontally()) {
            outRect.left = spacing;
            outRect.right = position == itemCount - 1 ? spacing : 0;
            outRect.top = spacing;
            outRect.bottom = spacing;
        } else {
            outRect.left = spacing;
            outRect.right = spacing;
            outRect.top = spacing;
            outRect.bottom = position == itemCount - 1 ? spacing : 0;
        }
    }


    private int resolveDisplayMode(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollHorizontally()) return HORIZONTAL;
        return VERTICAL;
    }
}