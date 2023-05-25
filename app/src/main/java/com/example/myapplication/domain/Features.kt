package com.example.myapplication.domain

import com.example.myapplication.data.Feature
import com.example.myapplication.data.featuresList

class FeatureController () {
    private fun detectScreenDependingOnFeature(feature: Feature) =
        when (feature.name) {
            "Fragments" -> null
            "ScrollView" -> "ListActivity"
            "Activities launch mode" -> "LM Entry Point"
            "Recycler View" -> "Recycler View"
            "Multithreading" -> "Multithreading"
            else -> null
        }

    private fun findFeatureByString(text: String): Feature? {
        return featuresList.find { it -> it.name.contains(text) }
    }

    fun start(featureName: String): String? {
        val feature = findFeatureByString(featureName)
        return if (feature == null) null
        else {
            detectScreenDependingOnFeature(feature)
        }
    }
}