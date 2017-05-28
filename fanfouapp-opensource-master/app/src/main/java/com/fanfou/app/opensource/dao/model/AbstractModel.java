/*******************************************************************************
 * Copyright 2011, 2012, 2013 fanfou.com, Xiaoke, Zhang
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
 *******************************************************************************/
package com.fanfou.app.opensource.dao.model;

import android.content.ContentValues;
import android.os.Parcelable;

/**
 * @author mcxiaoke
 * @version 1.0 2011.12.21
 * 
 */
public abstract class AbstractModel<T> implements Model, Parcelable {

    public abstract T get(String key);

    public abstract void put();

    public abstract ContentValues values();

}
