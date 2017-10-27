package com.anda.imagepicker.ui.grid.view;

import com.anda.imagepicker.base.activity.IImageBaseView;
import com.anda.imagepicker.data.ImageBean;
import com.anda.imagepicker.data.ImageFloderBean;
import com.anda.imagepicker.data.ImagePickerOptions;

import java.util.List;

/**
 * ImageDataActivity的View层接口
 */

public interface IImageDataView extends IImageBaseView {
    ImagePickerOptions getOptions();

    void startTakePhoto();

    void showLoading();

    void hideLoading();

    void onDataChanged(List<ImageBean> dataList);

    void onFloderChanged(ImageFloderBean floderBean);

    void onImageClicked(ImageBean imageBean, int position);

    void onSelectNumChanged(int curNum);

    void warningMaxNum();
}
