package com.admin.monuments.mapper

import android.util.Log
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListItemDto
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentView


fun MonumentListItemDto.toView(): MonumentListItemView = MonumentListItemView(id,title,geocoordinates)

fun MonumentItemDto.toView(): MonumentView = MonumentView(id,title,address,transport,email,geocoordinates,description,phone)