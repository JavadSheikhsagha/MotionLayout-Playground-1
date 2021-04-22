package jvd.ir.motionlayout_playground1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import jvd.ir.motionlayout_playground1.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {

    private var visualCounter = 1

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.constTestFragmentBottom.setOnClickListener {
            moveCards()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun moveCards() {

        when {
            visualCounter % 4 == 1 -> {
                binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_to2)
                binding.motionLayoutTestFragmentParent.transitionToEnd()
                visualCounter++
                doMotion()
            }
            visualCounter % 4 == 2 -> {
                binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_to3)
                binding.motionLayoutTestFragmentParent.transitionToEnd()
                visualCounter++
                doMotion()
            }
            visualCounter % 4 == 3 -> {
                binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_to4)
                binding.motionLayoutTestFragmentParent.transitionToEnd()
                visualCounter++
                doMotion()
            }
            visualCounter % 4 == 0 -> {
                binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_to1)
                binding.motionLayoutTestFragmentParent.transitionToEnd()
                visualCounter++
                doMotion()
            }
        }
    }

    private fun doMotion() {

        binding.motionLayoutTestFragmentParent.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {

                if (p1 == R.id.motion_testFragment_two) {
                    binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_reseter1)
                    binding.motionLayoutTestFragmentParent.transitionToEnd()
                    Log.i("LOG2", "onTransitionCompleted: toEnd")
                } else if (p1 == R.id.motion_testFragment_three) {
                    binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_reseter2)
                    binding.motionLayoutTestFragmentParent.transitionToEnd()
                } else if (p1 == R.id.motion_testFragment_four) {
                    binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_reseter3)
                    binding.motionLayoutTestFragmentParent.transitionToEnd()
                } else if (p1 == R.id.motion_testFragment_one) {
                    binding.motionLayoutTestFragmentParent.setTransition(R.id.tran_testFragment_reseter4)
                    binding.motionLayoutTestFragmentParent.transitionToEnd()
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })
    }
}