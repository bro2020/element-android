/*
 * Copyright (c) 2023 New Vector Ltd
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

package org.matrix.android.sdk.internal.session.synapse

import org.matrix.android.sdk.api.session.synapse.SynapseService
import javax.inject.Inject

internal class DefaultSynapseService @Inject constructor(
        private val synapseFeatureEnabledTask: IsSynapseFeatureEnabledTask,
) : SynapseService {
    override suspend fun isFeatureEnabled(feature: String) =
            synapseFeatureEnabledTask
                    .execute(IsSynapseFeatureEnabledTask.Params(feature))
                    .featureIsEnabled
}
