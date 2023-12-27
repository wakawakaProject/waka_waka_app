package com.example.waka_waka

class User {

     var dataId: String = ""
     var userId : String = ""
     var name: String = ""
     var age: Int = 0
     var phone: String = ""
     var gender: String = ""
     var position: String = ""
     var played_year : String = ""
     var address : String = ""

    constructor()

    constructor(dataId : String, userId : String, name: String, age: Int, phone: String,
                gender: String, position: String, played_year : String, address : String){
        this.dataId = dataId
        this.userId = userId
        this.name = name
        this. age = age
        this.phone = phone
        this.gender = gender
        this.position = position
        this.played_year = played_year
        this. address = address
    }


}