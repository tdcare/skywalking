/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.storage.plugin.influxdb.installer;

import org.apache.skywalking.oap.server.core.profile.ProfileTaskRecord;
import org.apache.skywalking.oap.server.core.storage.StorageException;
import org.apache.skywalking.oap.server.core.storage.model.Model;
import org.apache.skywalking.oap.server.library.client.Client;
import org.apache.skywalking.oap.server.library.module.ModuleManager;
import org.apache.skywalking.oap.server.storage.plugin.influxdb.InfluxModelConstants;
import org.apache.skywalking.oap.server.storage.plugin.jdbc.h2.dao.H2TableInstaller;

public class H2Installer extends H2TableInstaller {

    public H2Installer(ModuleManager moduleManager) {
        super(moduleManager);
        overrideColumnName(ProfileTaskRecord.DURATION, InfluxModelConstants.DURATION);
    }

    @Override
    protected boolean isExists(Client client, Model model) throws StorageException {
        if (MetaTableDefine.contains(model)) {
            return super.isExists(client, model);
        }
        return true;
    }

}
