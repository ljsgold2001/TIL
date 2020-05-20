package cs.smu.ac.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imgRes = intArrayOf(R.drawable.dog_alaskan_malamute,
        R.drawable.dog_breed_pomeranian,R.drawable.dog_chow_chow,R.drawable.dog_alaskan_malamute,
        R.drawable.dog_pug,R.drawable.dog_golden_retriever,R.drawable.dog_shih_tzu,R.drawable.dog_yorkshire_terrier)

    var data_name = arrayOf("Alasakn Malamute", "Breed Pomeranian","차우차우","말라뮤트","퍼그","골든리트리버","시추","요크셔")

    var data_age = arrayOf("1","2","3","4","5","6","7","8")

    var data_sex = arrayOf("F","F","F","F","F","F","F","F")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list  = ArrayList<HashMap<String,Any>>()

        var idx = 0
        while(idx<data_name.size){
            var map = HashMap<String,Any>()

            map.put("photo", imgRes[idx])
            map.put("name", data_name[idx])
            map.put("age", data_age[idx])
            map.put("sex", data_sex[idx])

            list.add(map)
            idx++


        }
        var keys = arrayOf("photo","name","age","sex")

        var ids = intArrayOf(R.id.imageView, R.id.textView,R.id.textView2,R.id.textView3)

        var adapter = SimpleAdapter(this,list,R.layout.row1,keys,ids)
        listView.adapter = adapter


        listView.setOnItemClickListener { parent, view, position, id ->
            textView4.text = data_name[position]+"이 선택됨"
        }
    }
}
