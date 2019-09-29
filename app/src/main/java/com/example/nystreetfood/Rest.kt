package com.example.nystreetfood

import com.opencsv.CSVReader
import org.json.JSONArray
import java.io.FileReader
import java.io.IOException

class Rest (
    var restName:String?,
    var subIndus: String?,
    var subSub:String? ,
    var address:String? ,
    var phone:String?,
    var website:String?,
    var postcode:String?,
    var rating:Int?
){
    companion object {
        fun readRestData(file:String):ArrayList<Rest>{
            var listOfRest = ArrayList<Rest>()
            try {
                val reader = CSVReader(FileReader(file))
                var nextLine: Array<String>? = null
                while (nextLine != null) {
                    // nextLine[] is an array of values from the line
                    println(nextLine[0] + nextLine[1] + "etc...")
                    nextLine[0]
                    listOfRest.add(
                        Rest(
                            nextLine[0],
                            nextLine[1],
                            nextLine[2],
                            nextLine[3],
                            nextLine[4],
                            nextLine[5],
                            nextLine[6],
                            0

                        )
                    )
                    nextLine = reader.readNext()
                }
            } catch (e: IOException) {
            }
            return listOfRest
        }
    }
}

/*

    constructor(restName:String,subIndus: String,subSub:String,address:String,phone:String,
                website:String,postcode:String,rating:Int){
        this.restName=restName
        this.subIndus=subIndus
        this.subSub=subSub
        this.address=address
        this.phone=phone
        this.website=website
        this.postcode=postcode
        this.rating=rating
    }
}

 */