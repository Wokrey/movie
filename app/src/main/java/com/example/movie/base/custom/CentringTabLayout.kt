package com.example.movie.base.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.google.android.material.tabs.TabLayout

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class CentringTabLayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
): TabLayout(context, attributeSet, defStyle) {

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        val firstTab = (getChildAt(0) as ViewGroup).getChildAt(0)
        val lastTab = (getChildAt(0) as ViewGroup).getChildAt((getChildAt(0) as ViewGroup).childCount - 1)
        firstTab ?: return
        ViewCompat.setPaddingRelative(
            getChildAt(0),
            width / 2 - firstTab.width / 2,
            0,
            width / 2 - lastTab.width / 2,
            0
        )
    }
}