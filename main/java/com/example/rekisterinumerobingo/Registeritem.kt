package com.example.rekisterinumerobingo



import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Registeritem(
    @PrimaryKey var id: Int = 0,
    var nahty : Boolean =false

) : RealmObject() {

}