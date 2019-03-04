package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

//https://www.youtube.com/watch?v=QQa6Pt9AtRE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val is immutable var is not
        val initialTextViewTranslationY = txtViewProgress.translationY

        this.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtViewProgress.text = progress.toString();

                val translationDistance = (initialTextViewTranslationY + progress * 5 * -1);
//                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1);

                txtViewProgress.animate().translationY(translationDistance);



            }
        })

        resetBtn.setOnClickListener {view ->
            seekBar.progress = 0
            txtViewProgress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)

        }
    }


    fun buttonClick(v: View) {
        val nextActivity = Intent(this, SecondActivity::class.java);
        startActivity(nextActivity)
    }
}
