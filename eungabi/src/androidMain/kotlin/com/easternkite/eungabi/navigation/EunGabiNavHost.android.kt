/*
 * Copyright 2024 easternkite
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easternkite.eungabi.navigation

import androidx.activity.compose.PredictiveBackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CancellationException

@Composable
actual fun EunGabiNavHost(
    modifier: Modifier,
    controller: EunGabiController,
    startDestination: String,
    transitionState: EunGabiTransitionState,
    predictiveBackTransition: EunGabiPredictiveState,
    builder: EunGabiGraphBuilder.() -> Unit
) {
    val backStack by controller.backStack.collectAsState()

    var inPredictiveBack by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0f) }

    PredictiveBackHandler(backStack.size > 1) { backEvent ->
        try {
            backEvent.collect {
                inPredictiveBack = true
                progress = it.progress
            }
            inPredictiveBack = false
            controller.navigateUp()
        } catch (e: CancellationException) {
            inPredictiveBack = false
        }
    }

    EunGabiNavHostInternal(
        modifier = modifier,
        startDestination = startDestination,
        inPredictiveBack = inPredictiveBack,
        navTransition = transitionState,
        predictiveBackTransition = predictiveBackTransition,
        progress = progress,
        controller = controller,
        builder = builder
    )
}