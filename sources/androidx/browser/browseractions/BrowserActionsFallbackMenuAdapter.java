package androidx.browser.browseractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.C0139R;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;

class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    static class ViewHolderItem {
        ImageView mIcon;
        TextView mText;

        ViewHolderItem() {
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    public int getCount() {
        return this.mMenuItems.size();
    }

    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = (BrowserActionItem) this.mMenuItems.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(C0139R.layout.browser_actions_context_menu_row, null);
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.mIcon = (ImageView) view.findViewById(C0139R.C0141id.browser_actions_menu_item_icon);
            viewHolderItem.mText = (TextView) view.findViewById(C0139R.C0141id.browser_actions_menu_item_text);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        viewHolderItem.mText.setText(browserActionItem.getTitle());
        if (browserActionItem.getIconId() != 0) {
            viewHolderItem.mIcon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), null));
        } else {
            viewHolderItem.mIcon.setImageDrawable(null);
        }
        return view;
    }
}
