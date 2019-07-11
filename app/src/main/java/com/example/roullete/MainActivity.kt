package com.example.roullete

import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import kotlin.math.nextUp
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
      val sectors = arrayOf("32 red","15 black","19 red","4 black","21 red","2 black","25 red","17 black","34 red","6 black","27 red","13 black","36 red","11 black","30 red","8 black","23 red","10 black","5 red","24 black","16 red","33 black","1 red","20 black","14 red","31 black","9 red","22 black","18 red","29 black","7 red","28 black","12 red","35 black","3 red","26 black","zero")
       // val random = random()
    var deegre: Int = 0
    var deegreOld: Int = 0
    var halfSector: Float = 370f / 37f / 2f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun go(v: View){
        deegre = deegreOld % 360
        deegre = Random.nextInt(360) + 720
         val rotate = RotateAnimation(deegreOld.toFloat(),
            deegre.toFloat(),RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f)
        rotate.fillAfter = true
        rotate.duration = 3600
        //val lal = DecelerateInterpolator()
        //rotate.setInterpolator(DecelerateInterpolator())
        rotate.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                tvRezultat.setText("")

            }

            override fun onAnimationEnd(animation: Animation?) {
                tvRezultat.setText(getSector(360 - (deegre % 360)));
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    ivRuletka.startAnimation(rotate)
    }

    fun getSector(deegre: Int): String? {

        var i:Int = 0
        var text: String? = null
        do {
        val start: Float = halfSector*(i*2+1)
        val stop: Float = halfSector *(i*2 +3)

            if (deegre >= start && deegre < stop) {
                // degrees is in [start;end[
                // so text is equals to sectors[i];
                text = sectors[i]
            }

            i++
        }while( text == null &&  i < sectors.size)
        return text
    }
}
