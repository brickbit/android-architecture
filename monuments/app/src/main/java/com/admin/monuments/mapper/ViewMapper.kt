package com.admin.monuments.mapper

import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainItemDomain
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentView


fun MonumentMainItemDomain.toView(): MonumentListItemView = MonumentListItemView(id,title,geocoordinates)

fun MonumentDetailDomain.toView(): MonumentView = MonumentView(id,title,address,transport,email,geocoordinates,description,phone)