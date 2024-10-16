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
package com.blucky8649.eungabi.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

data class EunGabiTransitionState(
    val enter: AnimatedContentTransitionScope<EunGabiEntry>.() -> EnterTransition = { fadeIn(animationSpec = tween(700))},
    val exit: AnimatedContentTransitionScope<EunGabiEntry>.() -> ExitTransition = { fadeOut(animationSpec = tween(700)) },
    val popEnter: AnimatedContentTransitionScope<EunGabiEntry>.() -> EnterTransition = enter,
    val popExit: AnimatedContentTransitionScope<EunGabiEntry>.() -> ExitTransition = exit,
)