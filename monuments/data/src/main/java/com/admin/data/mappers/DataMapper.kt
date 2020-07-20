package com.admin.data.mappers

import com.admin.data.model.database.MonumentMainItemRoom
import com.admin.data.model.network.MonumentMainItemData
import com.admin.data.model.network.MonumentMainListData
import com.admin.domain.model.MonumentMainItemDomain
import com.admin.domain.model.MonumentMainListDomain

fun MonumentMainListData.toDomain() = MonumentMainListDomain(list = this.list.map { it.toDomain() })

fun MonumentMainItemData.toDomain() = MonumentMainItemDomain(id, title, geocoordinates)

fun MonumentMainItemRoom.toDomain() = MonumentMainItemDomain(id, title, geocoordinates)