package com.example.rekisterinumerobingo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager
import io.realm.Realm

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var registeritemlist: MutableList<Registeritem> = mutableListOf<Registeritem>()
    val realm = Realm.getDefaultInstance()

    private fun addItemToRealm() {
        var result = realm.where(Registeritem::class.java).findAll()
        Log.d("Kesä", result.size.toString())
        if (result.isEmpty()) {

            for (x in 1..100) {
                var registeritem = Registeritem(x)

                Log.d("Kesä", registeritem.id.toString())
                registeritemlist.add(registeritem)
                try {
                    realm.beginTransaction()
                    realm.copyToRealmOrUpdate(registeritem)
                    realm.commitTransaction()
                } catch (e: Exception) {
                    println(e)
                }
                finish()

            }

        } else {
            registeritemlist = realm.copyFromRealm(result)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar()
        addItemToRealm()
        //rv_animal_list.layoutManager = LinearLayoutManager(this)
        rv_number_list.layoutManager = GridLayoutManager(this, 5)
        rv_number_list.adapter = RegisterAdapter(registeritemlist) { partItem: Registeritem ->
            registerItemClicked(partItem)


        }


    }

    private fun registerItemClicked(registeritem: Registeritem) {
        Toast.makeText(this, "Clicked: ${registeritem.id}", Toast.LENGTH_LONG).show()


    }
}


