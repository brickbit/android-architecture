package com.admin.monuments.navigator

import android.content.Context
import android.content.Intent
import com.admin.monuments.view.activity.MonumentDetailActivity

/**
 * Navigator.
 */

fun navigateToDetailActivity(context: Context, categoryId: String) {
    val intent = Intent(context, MonumentDetailActivity::class.java)
    intent.putExtra(MonumentDetailActivity.CATEGORY_ID_KEY, categoryId)
    context.startActivity(intent)
}