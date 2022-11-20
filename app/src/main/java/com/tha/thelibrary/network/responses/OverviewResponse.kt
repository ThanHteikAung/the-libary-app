package com.tha.thelibrary.network.responses

import com.google.gson.annotations.SerializedName
import com.tha.thelibrary.data.vos.ListVO
import com.tha.thelibrary.data.vos.ResultVO

data class OverviewResponse(

    @SerializedName("results")
    val results : ResultVO?

)
