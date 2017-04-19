package com.six.animationplay.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.six.animationplay.R;

/**
 * Created by Administrator on 2017/4/13.
 */

public class CustomScanActivity extends AppCompatActivity
        implements DecoratedBarcodeView.TorchListener {

    private DecoratedBarcodeView mScanView;
    private CaptureManager mCaptureManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scan);

        initView();
        initCaptureManager(savedInstanceState);
    }

    private void initView() {
        mScanView = (DecoratedBarcodeView) findViewById(R.id.dbv_custom);
    }

    private void initCaptureManager(Bundle savedInstanceState) {
        mScanView.setTorchListener(this);
        mCaptureManager = new CaptureManager(this, mScanView);
        mCaptureManager.initializeFromIntent(getIntent(), savedInstanceState);
        mCaptureManager.decode();
    }

    @Override
    public void onTorchOn() {
    }

    @Override
    public void onTorchOff() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mScanView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCaptureManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCaptureManager.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCaptureManager.onDestroy();
    }
}
