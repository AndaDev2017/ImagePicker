package com.anda.imagepicker.ui.type;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.anda.imagepicker.ImagePicker;
import com.anda.imagepicker.R;
import com.anda.imagepicker.data.ImagePickType;

/**
 * "选择类型"的弹窗
 */
public class ImageTypeDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private ImagePicker mImagePicker;
    private int mRequestCode;

    public ImageTypeDialog(@NonNull Context context, int requestCode) {
        this(context, null, requestCode);
    }

    public ImageTypeDialog(@NonNull Context context, ImagePicker imagePicker, int requestCode) {
        super(context, R.style.TypeDialogStyle);
        mContext = context;
        mImagePicker = imagePicker != null ? imagePicker : new ImagePicker();
        mRequestCode = requestCode;
        initUI(context);
    }

    private void initUI(Context context) {
        setCancelable(true);
        setContentView(R.layout.layout_image_type);
        View view = findViewById(R.id.layout);
        view.setOnClickListener(this);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
        findViewById(R.id.tv_select_camera).setOnClickListener(this);
        findViewById(R.id.tv_select_photo).setOnClickListener(this);
        // 加载动画
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.imagepicker_pop_slide_in));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cancel
                || view.getId() == R.id.layout) { //取消
            dismiss();
        } else if (view.getId() == R.id.tv_select_camera) { //拍照
            selectFromCamera();
        } else if (view.getId() == R.id.tv_select_photo) { //从相册选择
            selectFromPhoto();
        }
    }

    /**
     * 拍照
     */
    private void selectFromCamera() {
        mImagePicker.pickType(ImagePickType.ONLY_CAMERA)
                .start((Activity) mContext, mRequestCode);
        dismiss();
    }

    /**
     * 从相册选择
     */
    private void selectFromPhoto() {
        mImagePicker.pickType(mImagePicker.getOptions().getMaxNum() > 1
                ? ImagePickType.MULTI
                : ImagePickType.SINGLE
        ).start((Activity) mContext, mRequestCode);
        dismiss();
    }

}
