package com.example.waka_waka

class User {

    var id: String = ""
    var pw: String = ""
    var name: String = ""
    var age: Int = 0
    var phone: String = ""
    var gender: String = ""
    var position: String = ""
    var played_year : String = ""
    var address : String = ""

    constructor()

    constructor(id:String, pw:String, name: String, age: Int, phone: String,
                gender: String, position: String, played_year : String, address : String){
        this.id = id
        this.name = name
        this.pw = pw
        this. age = age
        this.phone = phone
        this.gender = gender
        this.position = position
        this.played_year = played_year
        this. address = address
    }
}