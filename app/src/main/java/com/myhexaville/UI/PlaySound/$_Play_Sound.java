package com.myhexaville.UI.PlaySound;

import android.media.MediaPlayer;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.myhexaville.login.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.myhexaville.login.FourActivity.mPlayer;
import static com.myhexaville.login.FourActivity.wasPlaying;

public class $_Play_Sound {
    public $_Play_Sound(String mFileName, byte[] bytes, SeekBar seek_bar, ImageButton imageButton, TextView textView) {
        playSounds(mFileName, bytes, seek_bar, imageButton);
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setVisibility(View.VISIBLE);
                int x = (int) Math.ceil(progress / 1000f);

                if (x < 10)
                    textView.setText("0:0" + x);
                else
                    textView.setText("0:" + x);

                double percent = progress / (double) seekBar.getMax();
                int offset = seekBar.getThumbOffset();
                int seekWidth = seekBar.getWidth();
                int val = (int) Math.round(percent * (seekWidth - 2 * offset));
                int labelWidth = textView.getWidth();
                textView.setX(offset + seekBar.getX() + val
                        - Math.round(percent * offset)
                        - Math.round(percent * labelWidth / 2));

                if (progress > 0 && mPlayer != null && !mPlayer.isPlaying()) {
                    clearMediaPlayer();
                    imageButton.setImageResource(R.drawable.play_voice);
                    seekBar.setProgress(0);
                    mPlayer = null;

                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mPlayer != null && mPlayer.isPlaying()) {
                    mPlayer.seekTo(seekBar.getProgress());
                }
            }
        });

    }

    private void playSounds(String mFileName, byte[] bytes, SeekBar seek_bar, ImageButton imageButton) {
        try {
            if (mPlayer != null && mPlayer.isPlaying()) {
                clearMediaPlayer();
                imageButton.setImageResource(R.drawable.play_voice);
                //message_send_voice_seek_bar.setProgress(0);
                wasPlaying = true;
                System.out.println("AAAAAAAAAAA");
            }


            if (!wasPlaying) {
                if (mPlayer == null) {
                    mPlayer = new MediaPlayer();
                }


                //play voice
                FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + mFileName + ".3gp");
                fileOutputStream.write(bytes);


                try {
                    mPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + mFileName + ".3gp");
                } catch (IOException e) {
                }


                mPlayer.prepare();
                mPlayer.setVolume(0.5f, 0.5f);
                mPlayer.setLooping(false);
                seek_bar.setMax(mPlayer.getDuration());
                mPlayer.seekTo(seek_bar.getProgress());
                mPlayer.start();
                imageButton.setImageResource(R.drawable.pause_voice);
                MediaPlayer finalMPlayer = mPlayer;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int currentPosition = finalMPlayer.getCurrentPosition();
                        int total = finalMPlayer.getDuration();


                        while (finalMPlayer != null && finalMPlayer.isPlaying() && currentPosition < total) {
                            try {
                                Thread.sleep(1000);
                                currentPosition = finalMPlayer.getCurrentPosition();
                            } catch (InterruptedException e) {
                                return;
                            } catch (Exception e) {
                                return;
                            }

                            seek_bar.setProgress(currentPosition);

                        }
                    }
                }).start();

            }

            wasPlaying = false;
        } catch (Exception e) {
            e.printStackTrace();

        }
        new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + mFileName + ".3gp").delete();

    }

    private void clearMediaPlayer() {
        mPlayer.stop();
        mPlayer.release();
        mPlayer = null;
    }
}
