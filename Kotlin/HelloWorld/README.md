```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="Hello World!"
        android:textColor="@android:color/holo_blue_dark"
        android:textSize="30sp"
        android:background="@android:color/holo_blue_bright"
        android:gravity="center"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    //layout_gravity = 부모를 기준으로 내위치가 어디다 ex)left_bottom

</androidx.constraintlayout.widget.ConstraintLayout>
```

### 실행결과화면

<img width="349" alt="스크린샷 2019-10-14 오후 11 09 51" src="https://user-images.githubusercontent.com/48313074/66757813-ec384200-eed7-11e9-8ae7-884548c733e2.png">

