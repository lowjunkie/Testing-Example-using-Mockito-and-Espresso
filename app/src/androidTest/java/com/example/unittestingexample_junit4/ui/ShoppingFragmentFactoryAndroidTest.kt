package com.example.unittestingexample_junit4.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.unittestingexample_junit4.adapters.ImageAdapter
import com.example.unittestingexample_junit4.adapters.ShoppingItemAdapter
import com.example.unittestingexample_junit4.repositories.FakeShoppingRepositoryAndroidTest
import javax.inject.Inject

class ShoppingFragmentFactoryAndroidTest @Inject constructor(
        private val imageAdapter: ImageAdapter,
        private val glide: RequestManager,
        private val shoppingItemAdapter: ShoppingItemAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            AddShoppingItemFragment::class.java.name -> AddShoppingItemFragment(glide)
            ShoppingFragment::class.java.name -> ShoppingFragment(
                shoppingItemAdapter,
                ShoppingViewModel(FakeShoppingRepositoryAndroidTest())
            )
            else -> return super.instantiate(classLoader, className)

        }
    }
}