package uz.unzosoft.demofirst.extensions

import android.view.View


/**
 * Created by Abdurashidov Shahzod on 14/10/22 01:47.
 * company QQBank
 * shahzod9933@gmail.com
 */

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.showOrVisible(visible: Boolean) {
    if (visible) setVisible() else setGone()
}