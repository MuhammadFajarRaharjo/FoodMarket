package com.belajar.foodmarket.presentasion.auth.sign_up

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.main.MainActivity
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.utils.Consts
import com.belajar.foodmarket.utils.DataStoreSharedPreference
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
@ExperimentalPagerApi
@Composable
fun SignUpSuccess() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_signup_success),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(id = R.string.sign_up_completed),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Normal),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = R.string.subtitle_sign_up_completed),
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
            color = Manatee,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Button continue
        ButtonCustom(
            text = stringResource(id = R.string.find_foods),
            modifier = Modifier.fillMaxWidth(0.6f),
            onClick = {
                val activity = context as Activity
                Intent(context, MainActivity::class.java).run {
                    context.startActivity(this)
                }
                activity.finishAffinity()

                val preference: DataStoreSharedPreference =
                    DataStoreSharedPreference.getInstance(context)
                scope.launch { preference.savePreference(Consts.AUTH, Consts.AUTHORIZED) }
            }
        )
    }

}

@InternalCoroutinesApi
@ExperimentalPagerApi
@Preview
@Composable
private fun PreviewSignUpSuccess() {
    FoodMarketTheme {
        Surface {
            SignUpSuccess()
        }
    }
}