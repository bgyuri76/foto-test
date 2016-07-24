/**
 * Copyright 2011 StackMob
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stackmob.sdk.net;

import com.stackmob.sdk.api.StackMob;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;
import org.scribe.services.TimestampService;
import org.scribe.services.TimestampServiceImpl;

import java.util.UUID;

public class StackMobApi extends DefaultApi10a {

    public static class StackMobTimeService extends TimestampServiceImpl {
        @Override
        public String getTimestampInSeconds() {
            //Ensure the timestamp we sends matches up with the server time
            return String.valueOf(StackMob.getStackMob().getSession().getServerTime());
        }

        @Override
        public String getNonce() {
            return UUID.randomUUID().toString();
        }

    }

    @Override
    public String getRequestTokenEndpoint() {
        return null;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    @Override
    public String getAuthorizationUrl(Token token) {
        return null;
    }

    @Override
    public TimestampService getTimestampService()
    {
        return new StackMobTimeService();
    }
}