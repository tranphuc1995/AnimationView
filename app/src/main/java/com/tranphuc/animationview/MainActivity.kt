package com.tranphuc.animationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mY: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        ViewAnimator.animate(vTest).translationY(1920.0F).duration(1).start()

        btnMoveDown.setOnClickListener {
            ViewAnimator.animate(vTest).translationY(1920.0F).duration(300).start()
        }

        btnMoveUp.setOnClickListener {
            ViewAnimator.animate(vTest).translationY(300.0F).duration(300).start()
        }

        //

        vTest.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.d("debug_phuc", "" + event?.rawY)
                mY = event!!.rawY
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> "asdasd"
                    MotionEvent.ACTION_UP ->
                        if (mY > 1200) {
                            ViewAnimator.animate(vTest).translationY(1920.0F).duration(300).start()
                        } else if (mY < 500) {
                            ViewAnimator.animate(vTest).translationY(0.0F).duration(300).start()
                        }
                    MotionEvent.ACTION_MOVE ->
                        v!!.animate()
                            .x(0.0F)
                            .y(mY)
                            .setDuration(0)
                            .start();
                    else -> {
                        return false;
                    }
                }

                return true
            }
        })

    }
}
