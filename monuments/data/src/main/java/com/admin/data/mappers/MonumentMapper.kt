package com.admin.data.mappers

import com.admin.data.model.dto.MonumentItemData
import com.admin.data.model.dto.MonumentListData
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto

fun dataToDomain (data: MonumentListData) : MonumentListDto =
        MonumentListDto(convertItemDataToDomain(data.list))

private fun convertItemDataToDomain(data : List<MonumentItemData>): List<MonumentItemDto> =
        data.mapIndexed { _, monumentItemData ->
            MonumentItemDto(monumentItemData.id,monumentItemData.title,monumentItemData.address,monumentItemData.transport,monumentItemData.email,monumentItemData.geocoordinates,monumentItemData.description,monumentItemData.phone)
        }