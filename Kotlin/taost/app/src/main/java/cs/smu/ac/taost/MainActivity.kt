package cs.smu.ac.taost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{ view->
            var toast1 = Toast.makeText(this,"짧은 메시지,",Toast.LENGTH_SHORT)
            toast1.show()
        }
        button2.setOnClickListener{ view->
            var toast2 = Toast.makeText(this,"긴 메시지,",Toast.LENGTH_LONG)
            toast2.show()
        }
        button3.setOnClickListener{ view->
            var view1= layoutInflater.inflate(R.layout.custom_toast,null)

            var toast3 = Toast(this)
            toast3.view = view1

            toast3.setGravity(Gravity.BOTTOM,0,0)
            toast3.show()
        }
    }
}
