package com.itgenius.firstandroidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.itgenius.firstandroidapp.R

class MainActivity : AppCompatActivity() {

    // การสร้างตัวแปรสำหรับทำงานกับ View Binding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var mainDrawerLayout: DrawerLayout
    private lateinit var mainToolbar: Toolbar
    private lateinit var mainNavigationView: NavigationView
    private lateinit var mainBottomNavigationVeiw: BottomNavigationView
//    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainToolbar = findViewById(R.id.main_toolbar)
        mainDrawerLayout = findViewById(R.id.drawer_layout)
        mainNavigationView = findViewById(R.id.main_navigation_view)
        mainBottomNavigationVeiw = findViewById(R.id.main_bottom_navigation_veiw)
//        fab = findViewById(R.id.fab)

        // กำหนดค่าเริ่มต้นให้กับ navController
        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        // กำหนด Fragment ที่ไม่ต้องการให้แสดงปุ่ม Back
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.productFragment,
            R.id.addProductFragment,
            R.id.notificationFragment,
            R.id.accountFragment,
//            R.id.aboutFragment,
//            R.id.serviceFragment,
//            R.id.settingFragment
        ).setOpenableLayout(mainDrawerLayout).build()

        // เรียกทำงานกับ Toolbar
        setSupportActionBar(mainToolbar)

        // กำหนด Toolbar ให้แสดง icon เมนู
        setupActionBarWithNavController(navController, appBarConfiguration)

        // เรียกใช้งาน Drawer navigation
        mainNavigationView.setupWithNavController(navController)

        // เรียกใช้งาน Bottom navigation
        mainBottomNavigationVeiw.setupWithNavController(navController)

        // เรียก event คลิกปุ่ม fab
       // fab.setOnClickListener {
       //     findNavController(R.id.main_nav_host).navigate(R.id.addProductFragment)
            // mainBottomNavigationVeiw.visibility = View.GONE // ซ่อนเมนูด้านล่าง
            // mainNavigationView.visibility = View.VISIBLE // แสดงเมนูด้านข้าง
//            mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        // }

    }

     override fun onSupportNavigateUp(): Boolean {
//        mainBottomNavigationVeiw.visibility = View.VISIBLE
//        mainNavigationView.visibility = View.VISIBLE
//        mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
         return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

//    override fun onBackPressed() {
//        when { //If drawer layout is open close that on back pressed
//            mainDrawerLayout.isDrawerOpen(GravityCompat.START) -> {
//                mainDrawerLayout.closeDrawer(GravityCompat.START)
//            }
//            else -> {
//                super.onBackPressed() //If drawer is already in closed condition then go back
//            }
//        }
//    }
}