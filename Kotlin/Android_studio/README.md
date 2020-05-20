```kotlin
package com.example.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
      //class를 정의할때 oncreate라는 함수를 사용해야한다.
      //main 함수이다.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // xml 과 매칭 시켜주는 코드이다.
    }
}
```

