package com.initialxy.cordova.themeablebrowser;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.res.Resources;
import android.app.Dialog;
import android.widget.LinearLayout;

public class LoadingDialog {

    Context context;

    public LoadingDialog(Context context) {
        
        this.context = context;

    }


    public static Dialog createLoadingDialog(Context context) {

        // this.context = context;

        LayoutInflater inflater = LayoutInflater.from(context);
        Resources resources = context.getResources();

        int RLayout = resources.getIdentifier("dialog_loading","layout",context.getPackageName());
        View v = inflater.inflate(RLayout, null);// 得到加载view

        int LinearLayoutID = resources.getIdentifier("dialog_loading_view","id",context.getPackageName());
        LinearLayout layout = (LinearLayout) v.findViewById(LinearLayoutID);// 加载布局

        int DialogStyle = resources.getIdentifier("MyDialogStyle","style",context.getPackageName());
        Dialog loadingDialog = new Dialog(context, DialogStyle);// 创建自定义样式dialog

        loadingDialog.setCancelable(true); // 是否可以按“返回键”消失
        loadingDialog.setCanceledOnTouchOutside(true); // 点击加载框以外的区域
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局

        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);

//        loadingDialog.show();

        return loadingDialog;

    }

    public static void closeDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
        }
    }

    public static void showDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null ) {
            mDialogUtils.show();
        }
    }
    




}
