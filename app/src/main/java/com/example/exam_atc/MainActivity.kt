package com.example.exam_atc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.view.View

class MainActivity : AppCompatActivity() {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentFragment = First()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, currentFragment!!)
            .commit()
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
        currentFragment = fragment
    }

    private fun changeToFragment2() {
        val fragment2 = Second()
        changeFragment(fragment2)
    }

    private fun changeToFragment3() {
        val fragment3 = Third()
        changeFragment(fragment3)
    }

    private fun changeToFragment4() {
        val fragment4 = Four()
        changeFragment(fragment4)
    }

    private fun changeToFragment1() {
        val fragment1 = First()
        changeFragment(fragment1)
    }

    fun onClickScreen(view: View) {
        when (currentFragment) {
            is First -> changeToFragment2()
            is Second -> changeToFragment3()
            is Third -> changeToFragment4()
            is Four -> changeToFragment1()
        }
    }
}
