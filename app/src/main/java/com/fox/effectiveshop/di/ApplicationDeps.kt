package com.fox.effectiveshop.di

import com.fox.feature_cart_screen.di.CartScreenDeps
import com.fox.feature_details_screen.di.DetailsScreenDeps
import com.fox.feature_main_screen.di.MainScreenDeps

interface ApplicationDeps: MainScreenDeps, DetailsScreenDeps, CartScreenDeps