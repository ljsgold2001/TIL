package cs.smu.ac.kr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Solution1
        var listener7 = BtnListener7()//이러한 일을 할수있는 클래스가 메인엑티비티안에 만들어 진것이다.
        var listener8 = BtnListener8()
        var listener9 = BtnListener9()

        button.setOnClickListener(listener7)
        button2.setOnClickListener(listener8)
        button3.setOnClickListener(listener9)
        */

        //solution2
        var listener = BtnListener()
        button.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)

    }
/*
    solution1
    inner class BtnListener7: View.OnClickListener{ //onclick listener에 상속을 받는데
        override fun onClick(v: View?) {// onClick함수를 오버라이드 시키고
            textView.text = "첫번째버튼이 선택되었습니다."//이런 기능을 수행하겠다.
        }

    }
    inner class BtnListener8 : View.OnClickListener{
        override fun onClick(v: View?) {
            textView.text="두번째 버튼이 선택되었습니다."
        }
    }

    inner class BtnListener9 : View.OnClickListener{
        override fun onClick(v: View?) {
            textView.text="리셋 버튼이 선택되었습니다."
        }
    }

 */
    //solution2

    inner class BtnListener: View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button ->textView.text = "첫번째 버튼이 선택되었습니다."
            R.id.button2 ->textView.text = "두번째 버튼이 선택되었습니다."
            R.id.button3 ->textView.text = "리셋 버튼이 선택되었습니다."


        }
    }
}

}
