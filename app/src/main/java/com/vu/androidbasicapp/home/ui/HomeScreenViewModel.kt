package com.vu.androidbasicapp.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: RestfulApiDevRepositoryClass) : ViewModel() {

    val greetingText = MutableStateFlow("Hello you")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())

    init {
        // Add dummy data for testing
        val dummyData = listOf(
            ResponseItem(
                technique = "Long Exposure",
                equipment = "Tripod",
                subject = "Night sky",
                pioneeringPhotographer = "Michael Kenna",
                yearIntroduced = 1975,
                description = "A technique where the camera's shutter is left open for an extended period, capturing motion blur or light trails."
            ),
            ResponseItem(
                technique = "Macro Photography",
                equipment = "Macro lens",
                subject = "Insects",
                pioneeringPhotographer = "Roman Vishniac",
                yearIntroduced = 1930,
                description = "Close-up photography of very small subjects, in which the size of the subject in the photograph is greater than life size."
            ),
            ResponseItem(
                technique = "HDR",
                equipment = "DSLR camera",
                subject = "Landscapes",
                pioneeringPhotographer = "Greg Ward",
                yearIntroduced = 1985,
                description = "High Dynamic Range imaging technique that combines multiple exposures to create a single image with a greater range of tonal detail."
            ),
            ResponseItem(
                technique = "Street Photography",
                equipment = "Compact camera",
                subject = "Urban life",
                pioneeringPhotographer = "Henri Cartier-Bresson",
                yearIntroduced = 1930,
                description = "Photography that features the human condition within public places, often in urban environments."
            ),
            ResponseItem(
                technique = "Aerial Photography",
                equipment = "Drone",
                subject = "Landscapes",
                pioneeringPhotographer = "George R. Lawrence",
                yearIntroduced = 1906,
                description = "Taking photographs from an aircraft or other flying object, providing a bird's-eye view of the subject."
            ),
            ResponseItem(
                technique = "Time-lapse Photography",
                equipment = "Intervalometer",
                subject = "Natural phenomena",
                pioneeringPhotographer = "John Ott",
                yearIntroduced = 1930,
                description = "A technique where a series of images are captured over time and then played back at a faster speed."
            ),
            ResponseItem(
                technique = "Light Painting",
                equipment = "Flashlight",
                subject = "Abstract patterns",
                pioneeringPhotographer = "Man Ray",
                yearIntroduced = 1935,
                description = "A photographic technique in which exposures are made by moving a hand-held light source while taking a long exposure photograph."
            )
        )
        apiResponseObjects.value = dummyData
    }
}

