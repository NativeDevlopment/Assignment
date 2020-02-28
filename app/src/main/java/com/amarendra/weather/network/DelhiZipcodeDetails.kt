package com.amarendra.weather.network

import com.google.gson.annotations.SerializedName

data class DelhiZipcodeDetails(val Message:String,val Status:String,
                               @SerializedName("PostOffice")
                               val postOffice :List<PostOffice>){

}

 data class PostOffice (

     @SerializedName("Name")
     val name: String,
     @SerializedName("Pincode")
     val pincode:String
     ){

}
