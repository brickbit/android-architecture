package com.admin.monuments.model

data class MonumentView(val id: Long,
                        val title: String,
                        val address: String,
                        val transport: String,
                        val email: String,
                        val geocoordinates: String,
                        val description: String,
                        val phone: String)
