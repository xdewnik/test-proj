package com.kulya.dev.testproject.ui.common.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.kulya.dev.testproject.scopes.PerFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseFragmentModule {

    @Module
    companion object {
        const val FRAGMENT = "BaseFragmentModule.fragment"

        /*
         * Note that this is currently unused in this Kotlin project. However, it is used in the
         * Java branch of this project. We'll keep this private to avoid lint warnings until other
         * Kotlin classes needs it.
         */
        private const val CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager"

        /*
         * This is a valid way to declare static provides methods.
         * See https://github.com/google/dagger/issues/900#issuecomment-337043187
         */
        @JvmStatic
        @Provides
        @Named(CHILD_FRAGMENT_MANAGER)
        @PerFragment
        fun childFragmentManager(@Named(FRAGMENT) fragment: Fragment): FragmentManager =
                fragment.childFragmentManager
    }
}