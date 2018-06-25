package com.example.shipra.fragment_example_kotlin

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

        internal lateinit var tab_Layout: TabLayout
       // internal lateinit var frame_Layout: FrameLayout
        internal var fragment: Fragment? = null
        internal lateinit var fragmentManager: FragmentManager
        internal lateinit var fragmentTransaction: FragmentTransaction

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //tab_Layout = findViewById(R.id.tabLayout) as TabLayout
           // frame_Layout = findViewById(R.id.frameLayout) as FrameLayout

            fragment = HomeFragment()
            fragmentManager = getFragmentManager()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            fragmentTransaction.commit()

            tab_Layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    // Fragment fragment = null;
                    when (tab.position) {
                        0 -> fragment = HomeFragment()
                        1 -> fragment = AboutUsFragment()
                        2 -> fragment = ContactUs()
                    }
                    val fm = getFragmentManager()
                    val ft = fm.beginTransaction()
                   // ft.replace(R.id.frameLayout, fragment)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ft.commit()
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {

                }

                override fun onTabReselected(tab: TabLayout.Tab) {

                }
            })

        }
    }



