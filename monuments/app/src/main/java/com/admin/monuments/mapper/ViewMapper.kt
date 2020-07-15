package com.admin.monuments.mapper

import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListItemDomain
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentView


fun MonumentListItemDomain.toView(): MonumentListItemView = MonumentListItemView(id,title,geocoordinates)

fun MonumentItemDomain.toView(): MonumentView = MonumentView(id,title,address,transport,email,geocoordinates,description,phone)