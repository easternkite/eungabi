package com.blucky8649.decompose_navhost.utils

import platform.Foundation.NSUUID

actual val randomUuid: String get() = NSUUID.UUID().UUIDString