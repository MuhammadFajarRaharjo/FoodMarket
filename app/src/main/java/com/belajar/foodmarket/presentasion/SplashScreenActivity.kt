package com.belajar.foodmarket.presentasion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.utils.Consts
import com.belajar.foodmarket.presentasion.auth.AuthActivity
import com.belajar.foodmarket.presentasion.main.MainActivity
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.utils.DataStoreSharedPreference
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@ExperimentalPagerApi
@InternalCoroutinesApi
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var preference: DataStoreSharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference from datastore
        preference = DataStoreSharedPreference.getInstance(this)

        setContent {
            FoodMarketTheme {
                Surface(color = MaterialTheme.colors.primary) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_shop),
                            contentDescription = "Shop"
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.h4.copy(
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }

                    // next to other activity
                    LaunchedEffect(Unit) {
                        val status = preference.getPreference(Consts.AUTH)
                        delay(2000L)
                        Intent(
                            this@SplashScreenActivity,
                            if (status.first() == Consts.AUTHORIZED) MainActivity::class.java
                            else AuthActivity::class.java
                        ).run { startActivity(this) }
                        finishAffinity()
                    }
                }
            }
        }
    }
}