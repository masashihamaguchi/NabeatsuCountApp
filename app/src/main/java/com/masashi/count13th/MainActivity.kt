package com.masashi.count13th

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

//        title = "せかいのナベアツ"

        var count = 0
        var textView: TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)

        textView.text = count.toString()


        val rotationList: MutableList<Animator> = mutableListOf()
        val scaleXList: MutableList<Animator> = mutableListOf()
        val scaleYList: MutableList<Animator> = mutableListOf()

        rotationList.add(ObjectAnimator.ofFloat(imageView, "rotation", 0f, 30f).setDuration(200))
        rotationList.add(ObjectAnimator.ofFloat(imageView, "rotation", 30f, -30f).setDuration(400))
        rotationList.add(ObjectAnimator.ofFloat(imageView, "rotation", -30f, 0f).setDuration(200))

        scaleXList.add(ObjectAnimator.ofFloat(imageView, "scaleX", 1.5f).setDuration(300))
        scaleXList.add(ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f).setDuration(300))

        scaleYList.add(ObjectAnimator.ofFloat(imageView, "scaleY", 1.5f).setDuration(300))
        scaleYList.add(ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f).setDuration(300))

        val animationSet = AnimatorSet()
        animationSet.playSequentially(rotationList)
        animationSet.playSequentially(scaleXList)
        animationSet.playSequentially(scaleYList)


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            count++
            textView.text = count.toString()

            if (count % 3 == 0) animationSet.start();
        }

    }

}