package com.anda.imagepicker.ui.grid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anda.imagepicker.R;
import com.anda.imagepicker.base.adapter.IImagePickerItemView;
import com.anda.imagepicker.base.adapter.ImagePickerBaseAdapter;
import com.anda.imagepicker.base.adapter.ImagePickerViewHolder;
import com.anda.imagepicker.data.ImageDataModel;
import com.anda.imagepicker.data.ImageFloderBean;

/**
 * 文件夹适配器
 */
public class ImageFloderAdapter extends ImagePickerBaseAdapter<ImageFloderBean> {
    private int mCurfloderPosition;

    public ImageFloderAdapter(Context context, int position) {
        super(context, ImageDataModel.getInstance().getAllFloderList());
        this.mCurfloderPosition = position;
        addItemView(new ImageFloerItemView());
    }

    private class ImageFloerItemView implements IImagePickerItemView<ImageFloderBean> {

        @Override
        public int getItemViewLayoutId() {
            return R.layout.layout_image_floder_listitem;
        }

        @Override
        public boolean isForViewType(ImageFloderBean item, int position) {
            return true;
        }

        @Override
        public void setData(ImagePickerViewHolder holder, ImageFloderBean imageFloderBean, int position, ViewGroup parent) {
            ImageView imgFirst = holder.findView(R.id.img_floder_listitem_firstImg);

            if (imageFloderBean != null) {
                ImageDataModel.getInstance().getDisplayer().display(holder.getContext()
                        , imageFloderBean.getFirstImgPath(), imgFirst,
                        R.drawable.glide_default_picture, R.drawable.glide_default_picture,
                        300, 300);
                holder.setTvText(R.id.tv_floder_pop_listitem_name, imageFloderBean.getFloderName());
                holder.setTvText(R.id.tv_floder_pop_listitem_num,
                        holder.getContext().getResources().getString(R.string.imagepicker_floder_image_num
                                , String.valueOf(imageFloderBean.getNum())));
                if (position == mCurfloderPosition)
                    holder.setVisibility(R.id.img_floder_pop_listitem_selected, View.VISIBLE);
                else
                    holder.setVisibility(R.id.img_floder_pop_listitem_selected, View.GONE);
            }
        }
    }
}
