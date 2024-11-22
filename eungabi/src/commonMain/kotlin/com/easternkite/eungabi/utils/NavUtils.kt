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
package com.easternkite.eungabi.utils

import com.easternkite.eungabi.navigation.SCHEME

/**
 * Add prefix [SCHEME] at the beginning of the given route.
 *
 * @param route The route to add the prefix to.
 * @return The route with the prefix added.
 */
fun withScheme(route: String) = if (route.startsWith(SCHEME)) route else "$SCHEME$route"