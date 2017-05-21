package com.example.wseemann.listexample;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import wseemann.media.FFmpegMediaMetadataRetriever;

/**
 * Created by wseemann on 5/21/17.
 */

public class ImageRetrievalTask extends AsyncTask<Void, Void, Bitmap> {

    private String mUri;
    private Handler mHandler;
    private ImageView mImageView;

    public ImageRetrievalTask(String uri, Handler handler, ImageView imageView) {
        mUri = uri;
        mHandler = handler;
        mImageView = imageView;
    }

    @Override
    public Bitmap doInBackground(Void... Void) {

        Bitmap bitmap = null;

        FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever = new FFmpegMediaMetadataRetriever();
        fFmpegMediaMetadataRetriever.setDataSource(mUri);
        //Bitmap bitmap = fFmpegMediaMetadataRetriever.getFrameAtTime();

        Log.d("----->", fFmpegMediaMetadataRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_AUDIO_CODEC));

        byte [] bytes = fFmpegMediaMetadataRetriever.getEmbeddedPicture();

        if (bytes != null) {
            bitmap = BitmapUtils.decodeSampledBitmapFromResource(bytes, 50, 50);
        }

        fFmpegMediaMetadataRetriever.release();

        return bitmap;
    }

    @Override
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            HandlerHolder handlerHolder = new HandlerHolder();
            handlerHolder.imageView = mImageView;
            handlerHolder.bitmap = bitmap;

            Message message = new Message();
            message.obj = handlerHolder;

            mHandler.sendMessage(message);
        }
    }
}
