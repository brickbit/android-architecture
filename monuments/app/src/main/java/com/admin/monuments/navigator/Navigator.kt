package com.admin.monuments.navigator

import android.content.Context
import android.content.Intent
import com.admin.monuments.view.activity.DetailActivity

/**
 * Navigator.
 */

fun navigateToDetailActivity(context: Context, categoryId: String) {
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra(DetailActivity.CATEGORY_ID_KEY, categoryId)
    context.startActivity(intent)
}