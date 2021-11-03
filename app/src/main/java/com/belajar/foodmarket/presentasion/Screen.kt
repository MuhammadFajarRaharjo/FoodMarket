package com.belajar.foodmarket.presentasion

sealed class Screen(val route: String) {

    /* Auth */
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object SignUpAddress : Screen("sign_up_address")
    object SignUpSuccess : Screen("success_sign_up")

    /* Main */
    object Home : Screen("home")
    object Order : Screen("order")
    object Profile : Screen("profile")

    /* Food and Order */
    object FoodDetail : Screen("food_detail")
    object PaymentAndAddressDetails : Screen("payment_and_address_detail")
    object ProgressOrderDetails : Screen("progress_order_detail")
    object SuccessOrder : Screen("success_order")
}
