package com.yusufadhika.appchat.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yusufadhika.appchat.MainActivity
import com.yusufadhika.appchat.fragments.ChatFragment
import com.yusufadhika.appchat.fragments.StatusListFragment
import com.yusufadhika.appchat.fragments.StatusUpdateFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val chatsFragment = ChatFragment()
    private val statusUpdateFragment = StatusUpdateFragment()
    private val statusFragment = StatusListFragment()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> statusUpdateFragment
            1 -> chatsFragment
            2 -> statusFragment
            else -> chatsFragment
        }
    }

    override fun getCount(): Int {
        return 3

    }
}