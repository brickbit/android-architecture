package com.admin.data.mappers

import com.admin.data.model.dto.MonumentItemData
import com.admin.data.model.dto.MonumentListData
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain

fun dataToDomain (data: MonumentListData) : MonumentListDomain =
        MonumentListDomain(convertItemDataToDomain(data.list))

private fun convertItemDataToDomain(data : List<MonumentItemData>): List<MonumentItemDomain> =
        data.mapIndexed { _, monumentItemData ->
            MonumentItemDomain(monumentItemData.id,monumentItemData.title,monumentItemData.address,monumentItemData.transport,monumentItemData.email,monumentItemData.geocoordinates,monumentItemData.description,monumentItemData.phone)
        }