package com.example.waka_waka

class Match {

     var dataId : String = ""
     var field : String = ""
     var gameDate : String = ""
     var memberNum : String = ""
     var comment : String = ""

    constructor()
    constructor(dataId : String, field: String, gameDate: String, memberNum: String, comment: String) {
        this.dataId = dataId
        this.field = field
        this.gameDate = gameDate
        this.memberNum = memberNum
        this.comment = comment
    }
}